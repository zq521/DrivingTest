package com.xhz.drivingtest.fragment.subject1;

import android.support.v4.app.Fragment;
import android.view.animation.Animation;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 15:20
 */

public class BaseSubject1ContentFragment extends Fragment {
    private Animation initAnimation=null;

    public void setInitAnimation(Animation initAnimation) {
        this.initAnimation = initAnimation;
    }

    public Animation getInitAnimation() {
        return initAnimation;
    }

    @Override
    public void onResume() {
        if (getInitAnimation()!=null){
            getView().startAnimation(getInitAnimation());
        }
        super.onResume();
    }
}
