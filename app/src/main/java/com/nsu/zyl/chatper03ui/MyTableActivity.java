package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cary on 2017/2/28.
 */
public class MyTableActivity extends Activity{

    private Button btnTabActivity;
    private Button btnTabActivity2;
    private Button btnWeixin;
    private Button btnViewPager;
    private Button btnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_table);
        initView();
    }

    private void initView() {
        btnTabActivity = (Button) findViewById(R.id.btn_tab_activity);
        btnTabActivity2 = (Button) findViewById(R.id.btn_tab_activity2 );
        btnWeixin = (Button) findViewById(R.id.btn_weixin);
        btnViewPager = (Button) findViewById(R.id.btn_viewpager);
        btnFragment = (Button) findViewById(R.id.btn_fragment);

        btnTabActivity.setOnClickListener(new MyBtnClickListener());
        btnTabActivity2.setOnClickListener(new MyBtnClickListener());
        btnWeixin.setOnClickListener(new MyBtnClickListener());
        btnViewPager.setOnClickListener(new MyBtnClickListener());
        btnFragment.setOnClickListener(new MyBtnClickListener());
    }

    private class MyBtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent();

            switch (v.getId()){
                case R.id.btn_tab_activity:

                    intent.setClass(MyTableActivity.this,TableActivity1.class);
                    startActivity(intent);
                    break;

                case R.id.btn_tab_activity2:
                    break;

                case R.id.btn_weixin:
                    break;

                case R.id.btn_viewpager:
                    intent.setClass(MyTableActivity.this,ViewPagerActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btn_fragment:
                    intent.setClass(MyTableActivity.this,MyFragmentActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
