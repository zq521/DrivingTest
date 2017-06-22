package com.xhz.drivingtest.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhz.drivingtest.controller.ExamFragmentController;
import com.xhz.drivingtest.databinding.FragmentExamBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExamFragment extends Fragment {


    private FragmentExamBinding mBinding;

    public ExamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        mBinding = FragmentExamBinding.inflate(inflater);
        mBinding.setController(new ExamFragmentController(this,mBinding));
        return mBinding.getRoot();

    }

}
