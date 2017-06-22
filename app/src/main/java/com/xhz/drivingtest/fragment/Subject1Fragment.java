package com.xhz.drivingtest.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhz.drivingtest.databinding.FragmentSubject1Binding;
import com.xhz.drivingtest.fragment.subject1.Subject1FragmentController;

/**
 * A simple {@link Fragment} subclass.
 */
public class Subject1Fragment extends SubjectFragment {


    private FragmentSubject1Binding mBinding;
    private Subject1FragmentController mSubject1FragmentController;

    public Subject1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentSubject1Binding.inflate(inflater);
        mSubject1FragmentController = new Subject1FragmentController(this, mBinding);
        mBinding.setController(mSubject1FragmentController);
        return mBinding.getRoot();

    }

    @Override
    public void onResume() {
        mSubject1FragmentController.onResume();
        super.onResume();
    }
}
