package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cary on 2017/3/10.
 */

public class ViewPagerActivity extends Activity {

    private ViewPager myViewPager; // 要使用的ViewPager
    private View pageHome, pageNear, pageOrder, pageMine; // ViewPager包含的页面
    private List<View> pageList; // ViewPager包含的页面列表，一般给adapter传的是一个list
    private MyPagerAdapter myPagerAdapter; // 适配器


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_layout);
        myViewPager = (ViewPager) findViewById(R.id.viewpager);
        pageList = new ArrayList<View>();

        LayoutInflater inflater = getLayoutInflater();
        pageHome = inflater.inflate(R.layout.home_activity, null);
        pageNear = inflater.inflate(R.layout.near_activity, null);
        pageOrder = inflater.inflate(R.layout.order_activity, null);
        pageMine = inflater.inflate(R.layout.mine_activity, null);
        pageList.add(pageHome);
        pageList.add(pageNear);
        pageList.add(pageOrder);
        pageList.add(pageMine);

        myPagerAdapter = new MyPagerAdapter(pageList);
        myViewPager.setAdapter(myPagerAdapter);

    }


}
