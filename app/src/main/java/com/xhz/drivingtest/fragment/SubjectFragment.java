package com.xhz.drivingtest.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 10:43
 */

public class SubjectFragment extends Fragment {

    public static final java.lang.String KEY_TITLE = "title";

    public SubjectFragment() {
        setArguments(new Bundle());
    }

    public SubjectFragment setTitle(String title) {
        getArguments().putString(KEY_TITLE, title);
        return this;
    }

    public String getTitle() {
        return getArguments().getString(KEY_TITLE, "None");
    }


}
