package com.nsu.zyl.chatper03ui;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost;

import com.nsu.zyl.chatper03ui.table.HomeActivity;
import com.nsu.zyl.chatper03ui.table.MineActivity;
import com.nsu.zyl.chatper03ui.table.NearActivity;
import com.nsu.zyl.chatper03ui.table.OrderActivity;

/**
 * Created by Cary on 2017/2/28.
 */

public class TableActivity1 extends TabActivity implements CompoundButton.OnCheckedChangeListener{

    private TabHost tabhost;
    private RadioButton homeBtn;
    private RadioButton nearBtn;
    private RadioButton orderBtn;
    private RadioButton mineBtn;

    private Intent homeIntent;
    private Intent nearIntent;
    private Intent orderIntent;
    private Intent mineIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_layout1);

        homeBtn = (RadioButton) findViewById(R.id.home_tab);
        nearBtn = (RadioButton) findViewById(R.id.near_tab);
        orderBtn = (RadioButton) findViewById(R.id.order_tab);
        mineBtn = (RadioButton) findViewById(R.id.mine_tab);

        homeIntent = new Intent(TableActivity1.this, HomeActivity.class);
        nearIntent = new Intent(TableActivity1.this, NearActivity.class);
        orderIntent = new Intent(TableActivity1.this, OrderActivity.class);
        mineIntent = new Intent(TableActivity1.this, MineActivity.class);

        tabhost = getTabHost();
        tabhost.addTab(tabhost.newTabSpec("home").setIndicator("0").setContent(homeIntent));
        tabhost.addTab(tabhost.newTabSpec("near").setIndicator("1").setContent(nearIntent));
        tabhost.addTab(tabhost.newTabSpec("order").setIndicator("2").setContent(orderIntent));
        tabhost.addTab(tabhost.newTabSpec("mine").setIndicator("3").setContent(mineIntent));

        homeBtn.setOnCheckedChangeListener(this);
        nearBtn.setOnCheckedChangeListener(this);
        orderBtn.setOnCheckedChangeListener(this);
        mineBtn.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked){
            switch (buttonView.getId()){
                case R.id.home_tab:
                    tabhost.setCurrentTab(0);
                    break;
                case  R.id.near_tab:
                    tabhost.setCurrentTab(1);
                    break;
                case R.id.order_tab:
                    tabhost.setCurrentTab(2);
                    break;
                case R.id.mine_tab:
                    tabhost.setCurrentTab(3);
                    break;
            }
        }
    }
}
