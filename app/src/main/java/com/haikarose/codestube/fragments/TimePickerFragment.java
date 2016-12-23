package com.haikarose.codestube.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TimePicker;


import com.haikarose.codestube.R;

import java.util.Calendar;

/**
 * Created by root on 12/18/16.
 */

//BottomSheetDialogFragment
//DialogFragment
public class TimePickerFragment extends DialogFragment {



  @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
 /*
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);


        // Activity has to implement this interface
        TimePickerDialog.OnTimeSetListener listener = (TimePickerDialog.OnTimeSetListener) getActivity();

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), listener, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
                */
                  Dialog dialog = super.onCreateDialog(savedInstanceState);
    // request a window without the title
    dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
    return dialog;


    }

    public void onTimeSet(TimePicker view,int hourOfDay,int minute){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.bottom_sheet,container);
    }
}
