package com.phamminhtri.mohinhmvp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.phamminhtri.mohinhmvp.OnSkipNextListener;
import com.phamminhtri.mohinhmvp.R;
import com.phamminhtri.mohinhmvp.adapter.IntroAdapter;
import com.phamminhtri.mohinhmvp.model.Course;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements OnSkipNextListener, View.OnClickListener {

    private ViewPager viewPager;
    private OnSkipNextListener callback;
    private RelativeLayout relativeLayout;
    private int curent = 0;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        relativeLayout = view.findViewById(R.id.rl_bottom);
        callback = this;

        CourseFragment javafragment = CourseFragment.newInstance(callback);
        CourseFragment androidfragment = CourseFragment.newInstance(callback);
        CourseFragment iosfragment = CourseFragment.newInstance(callback);
        LoginRegisterFragment loginRegisterFragment = LoginRegisterFragment.newInstance();

        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(javafragment);
        fragmentArrayList.add(androidfragment);
        fragmentArrayList.add(iosfragment);
        fragmentArrayList.add(loginRegisterFragment);

        ArrayList<Course> courseArrayList = new ArrayList<>();
        Course javacourses = new Course(getString(R.string.title), getString(R.string.description), R.drawable.java);
        Course androidcourses = new Course(getString(R.string.title2), getString(R.string.description2), R.drawable.andorid);
        Course ioscourses = new Course(getString(R.string.title3), getString(R.string.description3), R.drawable.ios);

        courseArrayList.add(javacourses);
        courseArrayList.add(androidcourses);
        courseArrayList.add(ioscourses);

        IntroAdapter adapter = new IntroAdapter(getFragmentManager(), fragmentArrayList, courseArrayList);
        viewPager.setAdapter(adapter);
        final View indicator1 = view.findViewById(R.id.indicator1);
        final View indicator2 = view.findViewById(R.id.indicator2);
        final View indicator3 = view.findViewById(R.id.indicator3);
        TextView tvskip = view.findViewById(R.id.tv_skip);
        TextView tvnext = view.findViewById(R.id.tv_next);

        tvskip.setOnClickListener(this);
        tvnext.setOnClickListener(this);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int positon) {
                switch (positon) {
                    case 0:
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_active);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        relativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_active);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        relativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_active);
                        relativeLayout.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        indicator1.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator2.setBackgroundResource(R.drawable.bg_indicator_inactive);
                        indicator3.setBackgroundResource(R.drawable.bg_indicator_active);
                        relativeLayout.setVisibility(View.GONE);
                        break;
                }
                curent = positon;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        return view;
    }

    @Override
    public void OnClickNext(int curentPage) {
        viewPager.setCurrentItem(curentPage + 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip:
                viewPager.setCurrentItem(4);
                break;
            case R.id.tv_next:
                viewPager.setCurrentItem(curent + 1);
                break;
        }
    }
}
