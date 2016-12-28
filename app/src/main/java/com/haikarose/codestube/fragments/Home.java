package com.haikarose.codestube.fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.haikarose.codestube.R;
import com.haikarose.codestube.adapters.CategoryItemAdapter;
import com.haikarose.codestube.pojos.Category;
import com.haikarose.codestube.tools.CommonInformation;
import com.haikarose.codestube.tools.EndlessRecyclerViewScrollListener;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.File;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements TimePickerDialog.OnTimeSetListener{


    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private CategoryItemAdapter adapter;
    private int lastAdPosition=0;

    public Home() {
        // Required empty public constructor
    }

    private TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        }
    };
    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            //Do whatever you want
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        FragmentManager fragmentManager=getFragmentManager();

        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.swipeRefresh);
        recyclerView=(RecyclerView)view.findViewById(R.id.recyclerView);


        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        final List<Object> categories=new ArrayList<>();

        //page//total//count/list
        //loadData(0,0,categories);

        //the first loading task.
        doTask(CommonInformation.CATEGORY_LIST,0,2,categories);




        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {

                   doTask(CommonInformation.CATEGORY_LIST,page,2,categories);

            }
        });



        adapter=new CategoryItemAdapter(getContext(),fragmentManager,categories);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //loadData(0,8,categories);

            }
        });

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    }

    public void addNativeAddToList(int on, final List<Object> objects){




                NativeExpressAdView nativeExpressAdView=new NativeExpressAdView(getContext());
                nativeExpressAdView.setAdUnitId("ca-app-pub-3940256099942544/1072772517");


                lastAdPosition=on+7;
                ////////////-------------------------////////////////////////////////
            if(on==0){
                AdSize size=new AdSize(300,150);
                objects.add(on,nativeExpressAdView);

                try{
                    //NativeExpressAdView nativeExpressAdView=(NativeExpressAdView)objects.get(on);
                    if(nativeExpressAdView.getAdSize()==null){
                        nativeExpressAdView.setAdSize(size);
                    }
                    nativeExpressAdView.loadAd(new AdRequest.Builder().build());
                }catch (Exception ex){

                }

                ////////////-------------------------////////////////////////////////
            }


    }

    public void loadData(int page, int total,List<Object> categories){

        swipeRefreshLayout.setRefreshing(true);

        if(page==0){

            for(int i=0;i<7;i++) {

                    Category category = new Category();
                    category.setName("System Analysis and Design");
                    category.setCat_descr("Java programming language is the best Java programming ");
                    category.setType("Java");

                    categories.add(category);
            }

            addNativeAddToList(page,categories);

        }else{

                 int value=total;
                 for(int i=total;i<value+8;i++){
                         Category category = new Category();
                         category.setName("System Analysis and Design");
                         category.setCat_descr("Java programming language is the best Java programming ");
                         category.setType("Java");

                         categories.add(category);
                         categories.add(category);
                        }

            addNativeAddToList(total,categories);

        }



        swipeRefreshLayout.setRefreshing(false);
    }


    public void doTask(String url, final int page, int total, final List<Object> categories){

        AsyncHttpClient client=new AsyncHttpClient();
        RequestParams params=new RequestParams();

        try{
            url+=URLEncoder.encode(Integer.toString(page),"UTF-8")+"/"+URLEncoder.encode(Integer.toString(total),"UTF-8");
        }catch (Exception ex){

        }


        client.get(getContext(), url, params, new TextHttpResponseHandler() {

            @Override
            public void onStart() {
                super.onStart();
                swipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(getContext(),responseString,Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {

                swipeRefreshLayout.setRefreshing(false);
                    Type listType = new TypeToken<List<Category>>() {}.getType();
                    List<Category> yourList = new Gson().fromJson(responseString, listType);
                    addNativeAddToList(page,categories);
                    categories.addAll(yourList);
                    adapter.notifyDataSetChanged();

            }
        });
    }

}
