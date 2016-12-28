package com.haikarose.codestube.activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.features.ImagePickerActivity;
import com.esafirm.imagepicker.features.camera.OnImageReadyListener;
import com.esafirm.imagepicker.model.Image;
import com.haikarose.codestube.R;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends FragmentActivity implements TimePickerDialog.OnTimeSetListener {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);


        /*NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
        niceSpinner.attachDataSource(dataset);*/
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

               /* Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);*/
                ImagePicker.create(MainActivity.this)
                        .returnAfterFirst(true) // set whether pick or camera action should return immediate result or not. For pick image only work on single mode
                        .folderMode(true) // folder mode (false by default)
                        .folderTitle("Folder") // folder selection title
                        .imageTitle("Tap to select") // image selection title
                        .single() // single mode
                        .multi() // multi mode (default mode)
                        .limit(5) // max images can be selected (99 by default)
                        .showCamera(true) // show camera or not (true by default)/*
                        /*.imageDirectory("Camera")  directory name for captured image  ("Camera" folder by default)
                        .origin(images) original selected images, used in multi mode*/
                        .start(1994);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1994 && resultCode == RESULT_OK && data != null) {

            ArrayList<Image> images = (ArrayList<Image>) ImagePicker.getImages(data);
            Toast.makeText(getBaseContext(),images.get(0).getName(),Toast.LENGTH_SHORT).show();

            Glide
                    .with(MainActivity.this)
                    .load(images.get(0).getPath())
                    .centerCrop()
                    .placeholder(android.R.drawable.alert_dark_frame)
                    .crossFade()
                    .into((ImageView)findViewById(R.id.imageView));
        }


    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}
