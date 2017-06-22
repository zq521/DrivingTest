package com.xhz.drivingtest.fragment.subject1;

import android.view.View;
import android.view.animation.Animation;

import com.xhz.drivingtest.R;
import com.xhz.drivingtest.anim.AnimationListenerAdapter;
import com.xhz.drivingtest.anim.Translate3D;
import com.xhz.drivingtest.databinding.FragmentMockExamBinding;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 13:58
 */

public class MockExamFragmentController {
    private MockExamFragment mockExamFragment;
    private FragmentMockExamBinding binding;

    public MockExamFragmentController(MockExamFragment mockExamFragment, FragmentMockExamBinding binding) {
        this.mockExamFragment = mockExamFragment;
        this.binding = binding;
    }

    public void btnNavigateToRandomExamFragment(View v) {
        mockExamFragment.getView().startAnimation(new Translate3D(-0, -90, true, 350, new AnimationListenerAdapter() {
            @Override
            public void onAnimationEnd(Animation animation) {

                RandomExamFragment randomExamFragment = new RandomExamFragment();
                randomExamFragment.setInitAnimation(new Translate3D(90, 0, false, 350, null));
                mockExamFragment.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.examContainer, randomExamFragment)
                        .commit();
                super.onAnimationEnd(animation);
            }
        }));


    }

}
