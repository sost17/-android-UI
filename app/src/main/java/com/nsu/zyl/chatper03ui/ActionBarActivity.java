package com.nsu.zyl.chatper03ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

/**
 * Created by Cary on 2017/3/6.
 */

public class ActionBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionbar_layout);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            Class<?> menuClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method menuMethod = menuClass.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            menuMethod.setAccessible(true);
            menuMethod.invoke(menu, true);
        }catch (Exception e) {
            e.printStackTrace();
        }

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.actionbar_about:
                Toast.makeText(ActionBarActivity.this,"点击了 关于",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionbar_notification:
                Toast.makeText(ActionBarActivity.this,"点击了 通知",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionbar_search:
                Toast.makeText(ActionBarActivity.this,"点击了 搜索",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.actionbar_settings:
                Toast.makeText(ActionBarActivity.this,"点击了 设置",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
