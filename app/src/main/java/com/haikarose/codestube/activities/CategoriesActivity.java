package com.haikarose.codestube.activities;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haikarose.codestube.R;
import com.haikarose.codestube.adapters.CategoryItemAdapter;
import com.haikarose.codestube.pojos.Category;
import com.haikarose.codestube.pojos.CategoryItem;
import com.haikarose.codestube.pojos.SubCatItemModel;
import com.haikarose.codestube.tools.CommonInformation;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class CategoriesActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private CategoryItemAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<Object> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().setTitle(getIntent().getStringExtra(Category.NAME));

        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);

        String categoryName=getIntent().getStringExtra(Category.NAME);

        doTask(CommonInformation.CATEGORY_SUB_ITEMS,0,2,items,categoryName);
        //populateFakeData(items);

        adapter=new CategoryItemAdapter(getBaseContext(),items);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public ActionBar getSupportActionBar() {
        ActionBar actionBar=super.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        return actionBar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sub_cat_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==android.R.id.home){

            finish();

        }

        return true;
    }


    public void populateFakeData(List<Object> items){

        for(int i=0;i<15;i++){
            SubCatItemModel model=new SubCatItemModel();

            if(i%2==0){
                model.setPromoImage("https://img.youtube.com/vi/k6ZiPqsBvEQ/0.jpg");
            }else if(i%3==0){
                model.setPromoImage("https://img.youtube.com/vi/hXfigUyeHaY/0.jpg");
            }else{
                model.setPromoImage("https://img.youtube.com/vi/oX2rw5pAdxw/0.jpg");
            }

            model.setTitle("ujinga");
            model.setDescription("It is a long established fact that a reader will be distracted by the " +
                    "readable content of a page when looking at its layout. The point of using Lorem Ipsum is" +
                    " that it has a more-or-less normal distribution of letters, as opposed to using " +
                    "'Content here, content here', making it look like readable English. " +
                    "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text," +
                    " and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions " +
                    "have evolved over the years, sometimes by accident," +
                    " sometimes on purpose (injected humour and the like).");

            model.setId(new Long(i));
            items.add(i,model);
        }

    }

    public void doTask(String url, final int page, int total, final List<Object> categories,String name){

        AsyncHttpClient client=new AsyncHttpClient();
        RequestParams params=new RequestParams();

        try{
            url+= URLEncoder.encode(name,"UTF-8");
        }catch (Exception ex){

        }


        client.get(getBaseContext(), url, params, new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                swipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                swipeRefreshLayout.setRefreshing(false);
                Type listType = new TypeToken<List<CategoryItem>>() {}.getType();
                List<CategoryItem> yourList = new Gson().fromJson(responseString, listType);
                //addNativeAddToList(page,categories);
                categories.addAll(yourList);
                adapter.notifyDataSetChanged();

            }
        });
    }


}
