package com.haikarose.codestube.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haikarose.codestube.R;
import com.haikarose.codestube.adapters.PostItemAdapter;
import com.haikarose.codestube.pojos.Post;
import com.haikarose.codestube.tools.CommonInformation;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class PostsActivity extends AppCompatActivity {


    private List<Object> list=new ArrayList<>();
    private PostItemAdapter adapter;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        String category=getIntent().getStringExtra(CommonInformation.KEY_CATEGORY);

        adapter=new PostItemAdapter(getBaseContext(),list);
        recyclerView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        doTask(CommonInformation.POST_URL,0,2,list,category);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
        }

        return true;
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
                Type listType = new TypeToken<List<Post>>() {}.getType();
                List<Post> yourList = new Gson().fromJson(responseString, listType);
                //addNativeAddToList(page,categories);
                categories.addAll(yourList);
                adapter.notifyDataSetChanged();

            }
        });
    }
}
