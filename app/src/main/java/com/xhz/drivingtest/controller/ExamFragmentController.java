package com.xhz.drivingtest.controller;

import com.xhz.drivingtest.ada.ExamAdapter;
import com.xhz.drivingtest.databinding.FragmentExamBinding;
import com.xhz.drivingtest.fragment.ExamFragment;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 10:27
 */

public class ExamFragmentController {
    private ExamFragment examFragment;
    private FragmentExamBinding binding;

    public ExamFragmentController(ExamFragment examFragment, FragmentExamBinding binding) {
        this.examFragment = examFragment;
        this.binding = binding;

        configVP();

    }

    private void configVP() {
        binding.viewPager.setAdapter(new ExamAdapter(examFragment.getContext(),examFragment.getChildFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);


    }


}
