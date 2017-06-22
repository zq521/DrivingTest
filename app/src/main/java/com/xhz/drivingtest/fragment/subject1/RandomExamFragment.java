package com.xhz.drivingtest.fragment.subject1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhz.drivingtest.databinding.FragmentRandomExamBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class RandomExamFragment extends BaseSubject1ContentFragment {

    private FragmentRandomExamBinding mBinding;

    public RandomExamFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentRandomExamBinding.inflate(inflater);
        mBinding.setController(new RandomExamFragmentController(this,mBinding));

        return mBinding.getRoot();
    }


}
