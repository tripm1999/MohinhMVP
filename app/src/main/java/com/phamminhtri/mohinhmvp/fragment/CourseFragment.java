package com.phamminhtri.mohinhmvp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.phamminhtri.mohinhmvp.OnSkipNextListener;
import com.phamminhtri.mohinhmvp.R;
import com.phamminhtri.mohinhmvp.model.Course;

/**
 * A simple {@link Fragment} subclass.
 */
public class CourseFragment extends Fragment {
    private int positon;
    private static OnSkipNextListener mcallback;

    public CourseFragment() {
        // Required empty public constructor
    }

    public static CourseFragment newInstance(OnSkipNextListener callback) {
        CourseFragment courseFragment = new CourseFragment();
        mcallback = callback;
        return courseFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_course, container, false);
        TextView tvtitle = view.findViewById(R.id.tv_tile);
        TextView tvdesciption = view.findViewById(R.id.tv_desciption);
        ImageView imageView = view.findViewById(R.id.img_background);

        Bundle bundle = getArguments();
        if (bundle != null) {
            positon = bundle.getInt("position");
            Course course = (Course) bundle.getSerializable("couse");
            tvtitle.setText(course.getTitle());
            tvdesciption.setText(course.getDescription());
            imageView.setImageResource(course.getIdimage());

        }
        return view;
    }

}
