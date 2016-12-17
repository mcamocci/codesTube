package com.haikarose.codestube.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.haikarose.codestube.pojos.FragmentAndTitle;

import java.util.List;

/**
 * Created by root on 12/17/16.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    List<FragmentAndTitle> fragmentAndTitleCollection;

    public FragmentAdapter(Context context, FragmentManager manager,List<FragmentAndTitle> fragmentAndTitles){
        super(manager);
        this.fragmentAndTitleCollection=fragmentAndTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentAndTitleCollection.get(position).getFragment();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    @Override
    public int getCount() {
        return fragmentAndTitleCollection.size();
    }

}
