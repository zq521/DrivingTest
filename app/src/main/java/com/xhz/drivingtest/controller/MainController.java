package com.xhz.drivingtest.controller;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.xhz.drivingtest.MainActivity;
import com.xhz.drivingtest.R;
import com.xhz.drivingtest.databinding.ActivityMainBinding;
import com.xhz.drivingtest.fragment.ExamFragment;
import com.xhz.drivingtest.fragment.SetFragment;

/**
 * mail：727319870@qq.com
 * Created by ${轩韩子} on 2017/6/22.
 * 09:14
 */

public class MainController {
    private MainActivity mMainActivity;
    private ActivityMainBinding binding;
    private int currentItemId;


    private BottomNavigationView.OnNavigationItemSelectedListener navigation = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int itemId = item.getItemId();
            if (currentItemId == itemId) {
                return false;
            }
            currentItemId = itemId;

            switch (item.getItemId()) {
                case R.id.navigation_Exam:
                    addExamFragment();
                    return true;
                case R.id.navigation_setTings:
                    mMainActivity.getSupportFragmentManager().beginTransaction()
                            //系统动画效果
//                             .setCustomAnimations()
                            .replace(R.id.container,new SetFragment())
                            .commit();
                    return true;

            }
            return false;
        }
    };

    public MainController(MainActivity mainActivity, ActivityMainBinding binding) {
        this.mMainActivity = mainActivity;
        this.binding = binding;

        addListener();
    }

    private void addListener() {
        binding.navigation.setOnNavigationItemSelectedListener(navigation);
    }

    private void addExamFragment(){
        mMainActivity.getSupportFragmentManager().beginTransaction()
                //系统动画效果
                // .setCustomAnimations()
                .replace(R.id.container, new ExamFragment())
                .commit();
        currentItemId=R.id.navigation_Exam;
    }
}
