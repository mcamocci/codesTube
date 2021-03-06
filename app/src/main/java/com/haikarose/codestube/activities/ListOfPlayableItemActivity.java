package com.haikarose.codestube.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haikarose.codestube.R;
import com.haikarose.codestube.adapters.PlayableItemAdapter;
import com.haikarose.codestube.pojos.PlayableItemModel;
import com.haikarose.codestube.pojos.Post;
import com.haikarose.codestube.pojos.Resource;
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

public class ListOfPlayableItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager linearLayoutManager;
    private List<Object> items=new ArrayList<>();
    private PlayableItemAdapter adapter;
    private Resource resource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_playable_item);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        linearLayoutManager=new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        //loadData(items);
        doTask(CommonInformation.RESOURCE_LIST,0,2,items,"name");
        adapter=new PlayableItemAdapter(getBaseContext(),items);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
        }
        return true;
    }

    public void loadData(List<Object> items){

        for(int i=0;i<15;i++){
            PlayableItemModel itemModel=new PlayableItemModel();
            itemModel.setId(new Long(1));
            itemModel.setDescription("this is just a video");
            itemModel.setUrl("wLRobpXVlf0");
            items.add(i,itemModel);
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
                Type listType = new TypeToken<List<Resource>>() {}.getType();
                List<Resource> yourList = new Gson().fromJson(responseString, listType);
                //addNativeAddToList(page,categories);
                categories.addAll(yourList);
                adapter.notifyDataSetChanged();

            }
        });
    }
}
