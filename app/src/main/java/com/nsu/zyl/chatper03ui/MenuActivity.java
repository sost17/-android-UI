package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Cary on 2017/2/28.
 */
public class MenuActivity extends Activity implements View.OnClickListener{

    private Button btnMenu;
    private Button btnActionBar;
    private Button btnToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_menu);
        initView();
    }

    private void initView() {
        btnMenu = (Button) findViewById(R.id.btn_menu);
        btnActionBar = (Button) findViewById(R.id.btn_action_bar);
        btnToolBar = (Button) findViewById(R.id.btn_tool_bar);
        btnMenu.setOnClickListener(this);
        btnActionBar.setOnClickListener(this);
        btnToolBar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_menu:
                Intent intent1 = new Intent();
                intent1.setClass(MenuActivity.this,MenuContentActivity.class);
                startActivity(intent1);
                break;

            case R.id.btn_action_bar:
                Intent intent2 = new Intent();
                intent2.setClass(MenuActivity.this,ActionBarActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_tool_bar:
                Intent intent3 = new Intent();
                intent3.setClass(MenuActivity.this,ToolBarActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
