package com.nsu.zyl.chatper03ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Switch;

import com.nsu.zyl.chatper03ui.fragment.HomeFragment;
import com.nsu.zyl.chatper03ui.fragment.MineFragment;
import com.nsu.zyl.chatper03ui.fragment.NearFragment;
import com.nsu.zyl.chatper03ui.fragment.OrderFragment;

/**
 * Created by Cary on 2017/3/10.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    public final static int TAB_COUNT = 4;

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case MyFragmentActivity.TAB_HOME:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;

            case MyFragmentActivity.TAB_NEAR:
                NearFragment nearFragment = new NearFragment();
                return  nearFragment;

            case MyFragmentActivity.TAB_ORDER:
                OrderFragment orderFragment = new OrderFragment();
                return orderFragment;

            case MyFragmentActivity.TAB_MINE:
                MineFragment mineFragment = new MineFragment();
                return mineFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }
}
