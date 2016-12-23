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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.NativeExpressAdView;
import com.haikarose.codestube.R;
import com.haikarose.codestube.adapters.CategoryItemAdapter;
import com.haikarose.codestube.pojos.Category;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment implements TimePickerDialog.OnTimeSetListener{


    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;

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

        List<Object> categories=new ArrayList<>();

        for(int i=0;i<11;i++){
            if(i%2==0){
                Category category=new Category("Java",
                        "Java programming language is the best Java programming " +
                                "language is the best Java programming language is the best " +
                                "Java programming language is the best Java programming language " +
                                "is the bestJava programming language is the best","21 dec 2016");
                categories.add(category);
            }else if(i%3==0){
                Category category=new Category("System Analysis and Design",
                        "Java programming language is the best Java programming " +
                                "language is the best Java programming language is the best " +
                                "Java programming language is the best Java programming language " +
                                "is the bestJava programming language is the best","21 dec 2016");
                categories.add(category);
            }else{
                Category category=new Category("Operating System",
                        "Java programming language is the best Java programming " +
                                "language is the best Java programming language is the best " +
                                "Java programming language is the best Java programming language " +
                                "is the bestJava programming language is the best","21 dec 2016");
                categories.add(category);

            }

        }

        //adding the ads to the category list.
        addNativeAddToList(categories);

        CategoryItemAdapter adapter=new CategoryItemAdapter(getContext(),fragmentManager,categories);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(),"someone pull up",Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);



       /* TextView text=(TextView)view.findViewById(R.id.text);

        text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                TimePickerDialog dialog =  new TimePickerDialog(
                        getActivity(),R.style.DialogTheme,
                        timeSetListener,
                        05,
                        12,
                        true);
                dialog.show();

               *//*TimePickerFragment fragment=new TimePickerFragment();
                fragment.show(getFragmentManager(),"show");*//*

            }
        });*/

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
    }

    public void addNativeAddToList(final List<Object> objects){
        for(int i=0; i<objects.size();i+=8){
                NativeExpressAdView nativeExpressAdView=new NativeExpressAdView(getContext());
                nativeExpressAdView.setAdUnitId("ca-app-pub-3940256099942544/1072772517");
                objects.add(i,nativeExpressAdView);


        }

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                final float density=getActivity().getResources().getDisplayMetrics().density;

                int width=(int)(recyclerView.getWidth()/density);
                if(width>=600){
                    width=500;
                }
                AdSize size=new AdSize(width,150);
                Toast.makeText(getContext(),Float.toString(recyclerView.getWidth()/density),Toast.LENGTH_SHORT).show();

                for(int i=0; i<objects.size();i+=8){
                    NativeExpressAdView nativeExpressAdView=(NativeExpressAdView)objects.get(i);
                    nativeExpressAdView.setAdSize(size);
                    nativeExpressAdView.loadAd(new AdRequest.Builder().build());
                }
            }
        });

    }

}
