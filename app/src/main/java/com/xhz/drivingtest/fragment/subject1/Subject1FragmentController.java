package com.xhz.drivingtest.fragment.subject1;

import com.xhz.drivingtest.R;
import com.xhz.drivingtest.databinding.FragmentSubject1Binding;
import com.xhz.drivingtest.fragment.Subject1Fragment;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 13:42
 */

public class Subject1FragmentController {

    private Subject1Fragment subject1Fragment;
    private FragmentSubject1Binding binding;


    public Subject1FragmentController(Subject1Fragment subject1Fragment, FragmentSubject1Binding binding) {
        this.subject1Fragment = subject1Fragment;
        this.binding = binding;

    }

    public void onResume() {
        subject1Fragment.getChildFragmentManager().beginTransaction()
                .replace(R.id.examContainer, new RandomExamFragment())
                .commit();
    }
}
