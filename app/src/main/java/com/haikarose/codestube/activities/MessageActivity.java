package com.haikarose.codestube.activities;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.haikarose.codestube.R;

public class MessageActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        getSupportActionBar();
    }

    @Nullable
    @Override
    public ActionBar getSupportActionBar() {
        ActionBar bar= super.getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        return bar;
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
