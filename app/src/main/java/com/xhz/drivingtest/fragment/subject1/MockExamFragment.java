package com.xhz.drivingtest.fragment.subject1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhz.drivingtest.databinding.FragmentMockExamBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MockExamFragment extends BaseSubject1ContentFragment {


    private FragmentMockExamBinding mBinding;

    public MockExamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentMockExamBinding.inflate(inflater);
        mBinding.setController(new MockExamFragmentController(this, mBinding));

        return mBinding.getRoot();
    }

}
