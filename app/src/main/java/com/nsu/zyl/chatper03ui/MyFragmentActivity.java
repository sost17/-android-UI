package com.nsu.zyl.chatper03ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by Cary on 2017/3/10.
 */

public class MyFragmentActivity extends FragmentActivity  implements View.OnClickListener{

    public static final int TAB_HOME = 0;
    public static final int TAB_NEAR = 1;
    public static final int TAB_ORDER = 2;
    public static final int TAB_MINE = 3;

    private ViewPager viewPager;
    private RadioButton homeBtn;
    private RadioButton nearBtn;
    private RadioButton orderBtn;
    private RadioButton mineBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout);
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.fragment_viewpager);
        homeBtn = (RadioButton) findViewById(R.id.home_tab);
        nearBtn = (RadioButton) findViewById(R.id.near_tab);
        orderBtn = (RadioButton) findViewById(R.id.order_tab);
        mineBtn = (RadioButton) findViewById(R.id.mine_tab);
        homeBtn.setOnClickListener(this);
        nearBtn.setOnClickListener(this);
        orderBtn.setOnClickListener(this);
        mineBtn.setOnClickListener(this);

        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case TAB_HOME:
                        homeBtn.setChecked(true);
                        break;
                    case TAB_NEAR:
                        nearBtn.setChecked(true);
                        break;
                    case TAB_ORDER:
                        orderBtn.setChecked(true);
                        break;
                    case TAB_MINE:
                        mineBtn.setChecked(true);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_tab:
                viewPager.setCurrentItem(TAB_HOME);
                break;
            case  R.id.near_tab:
                viewPager.setCurrentItem(TAB_NEAR);
                break;
            case R.id.order_tab:
                viewPager.setCurrentItem(TAB_ORDER);
                break;
            case R.id.mine_tab:
                viewPager.setCurrentItem(TAB_MINE);
                break;
        }
    }
}
