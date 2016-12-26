package com.haikarose.codestube.activities;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.haikarose.codestube.R;
import com.haikarose.codestube.adapters.PlayableItemAdapter;
import com.haikarose.codestube.pojos.PlayableItemModel;
import com.haikarose.codestube.pojos.SubCatItemModel;

import java.util.ArrayList;
import java.util.List;

public class ListOfPlayableItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private LinearLayoutManager linearLayoutManager;
    private List<Object> items=new ArrayList<>();
    private PlayableItemAdapter adapter;
    private SubCatItemModel subCatItemModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_playable_item);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        subCatItemModel= new SubCatItemModel();
        subCatItemModel.createFromBundle(getIntent().getExtras());
        Toast.makeText(getBaseContext(),subCatItemModel.getTitle(),Toast.LENGTH_SHORT).show();

        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        linearLayoutManager=new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        loadData(items);
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
}
