package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Cary on 2017/3/6.
 */

public class ToolBarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.toolbar_menu);

        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setTitle("首页");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //toolbar的menu点击事件的监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.toolbar_about:
                        Toast.makeText(ToolBarActivity.this,"点击了 关于",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.toolbar_notification:
                        Toast.makeText(ToolBarActivity.this,"点击了 通知",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.toolbar_search:
                        Toast.makeText(ToolBarActivity.this,"点击了 搜索",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.toolbar_settings:
                        Toast.makeText(ToolBarActivity.this,"点击了 设置",Toast.LENGTH_SHORT).show();
                        return  true;
                    default:
                        return false;
                }
            }
        });
    }

}
