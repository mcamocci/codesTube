package com.haikarose.codestube.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.haikarose.codestube.R;

import java.util.zip.Inflater;

/**
 * Created by root on 12/21/16.
 */

public class MoreOptionDialog extends BottomSheetDialogFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.more_option,container);
    }


}
