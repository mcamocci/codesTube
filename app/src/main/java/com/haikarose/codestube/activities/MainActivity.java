package com.haikarose.codestube.activities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.haikarose.codestube.R;
import com.haikarose.codestube.SecondActivity;

public class MainActivity extends FragmentActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });


    }
}
