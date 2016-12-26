package com.haikarose.codestube.pojos;
import android.support.v4.app.Fragment;

/**
 * Created by root on 12/17/16.
 */

public class FragmentAndTitle {

    private String title;
    private Fragment fragment;

    public FragmentAndTitle(){

    }

    public FragmentAndTitle(String title,Fragment fragment){
        this.title=title;
        this.fragment=fragment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }


}
