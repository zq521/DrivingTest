package com.xhz.drivingtest.ada;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xhz.drivingtest.R;
import com.xhz.drivingtest.fragment.Subject1Fragment;
import com.xhz.drivingtest.fragment.Subject2Fragment;
import com.xhz.drivingtest.fragment.Subject3Fragment;
import com.xhz.drivingtest.fragment.Subject4Fragment;
import com.xhz.drivingtest.fragment.SubjectFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 10:31
 */

public class ExamAdapter extends FragmentPagerAdapter {
    private List<SubjectFragment> fragment = new ArrayList<>();

    public ExamAdapter(Context context, FragmentManager fm) {
        super(fm);

        fragment.add(new Subject1Fragment().setTitle(context.getString(R.string.subject1)));
        fragment.add(new Subject2Fragment().setTitle(context.getString(R.string.subject2)));
        fragment.add(new Subject3Fragment().setTitle(context.getString(R.string.subject2)));
        fragment.add(new Subject4Fragment().setTitle(context.getString(R.string.subject2)));

    }

    @Override
    public SubjectFragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragment.get(position).getTitle();
    }
}
