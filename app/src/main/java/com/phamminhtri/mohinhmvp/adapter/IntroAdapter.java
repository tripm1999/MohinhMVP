package com.phamminhtri.mohinhmvp.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.phamminhtri.mohinhmvp.model.Course;

import java.util.ArrayList;

public class IntroAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> mlistfragment;
    private ArrayList<Course> mlistcourse;

    public IntroAdapter(FragmentManager fm, ArrayList<Fragment> mlistfragment, ArrayList<Course> courses) {
        super(fm);
        this.mlistfragment = mlistfragment;
        this.mlistcourse = courses;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = mlistfragment.get(position);
        if (position < mlistfragment.size() - 1) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("couse", mlistcourse.get(position));
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mlistfragment.size();
    }
}
