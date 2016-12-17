package com.haikarose.codestube.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.haikarose.codestube.R;
import com.haikarose.codestube.adapters.FragmentAdapter;
import com.haikarose.codestube.fragments.Home;
import com.haikarose.codestube.pojos.FragmentAndTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/17/16.
 */

public class HomeActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentAdapter fragmentAdapter;
    private Toolbar toolbar;
    private List<FragmentAndTitle> fragmentAndTitleCollection;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        tabLayout=(TabLayout)findViewById(R.id.sliding_tabs);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentAndTitleCollection=new ArrayList<>();
        fragmentAndTitleCollection.add(new FragmentAndTitle("One",new Home()));
        fragmentAndTitleCollection.add(new FragmentAndTitle("two",new Home()));
        fragmentAndTitleCollection.add(new FragmentAndTitle("Three",new Home()));

        fragmentAdapter=new FragmentAdapter(getBaseContext(),getSupportFragmentManager(),fragmentAndTitleCollection);
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.one);
        tabLayout.getTabAt(1).setIcon(android.R.drawable.sym_def_app_icon);
        tabLayout.getTabAt(2).setIcon(android.R.drawable.arrow_up_float);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==android.R.id.home){
            finish();
        }

        return true;
    }
}
