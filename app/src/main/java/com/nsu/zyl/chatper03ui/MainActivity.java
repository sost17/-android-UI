package com.nsu.zyl.chatper03ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_basicLayout;
    private Button btn_basicView;
    private Button btn_basicDialog;
    private Button btn_basicToast;
    private Button btn_menu;
    private Button btn_guide;
    private Button btn_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn_basicView = (Button)findViewById(R.id.btn_basic_layout);
        btn_basicLayout = (Button)findViewById(R.id.btn_basic_view);
        btn_basicDialog = (Button) findViewById(R.id.btn_basic_dialog);
        btn_basicToast = (Button) findViewById(R.id.btn_basic_toast);
        btn_menu = (Button) findViewById(R.id.btn_basic_menu);
        btn_guide = (Button) findViewById(R.id.btn_basic_guide);
        btn_adapter = (Button) findViewById(R.id.btn_basic_adapter);

        btn_basicLayout.setOnClickListener(new MyClickListener());
        btn_basicView.setOnClickListener(new MyClickListener());
        btn_basicDialog.setOnClickListener(new MyClickListener());
        btn_basicToast.setOnClickListener(new MyClickListener());
        btn_menu.setOnClickListener(new MyClickListener());
        btn_guide.setOnClickListener(new MyClickListener());
        btn_adapter.setOnClickListener(new MyClickListener());
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_basic_layout:
                    Intent intent1 = new Intent();
                    intent1.setClass(MainActivity.this, BasicLayoutActivity.class);
                    startActivity(intent1);
                    break;

                case R.id.btn_basic_view:
                    Intent intent2 = new Intent();
                    intent2.setClass(MainActivity.this, BasicViewActivity.class);
                    startActivity(intent2);
                    break;

                case R.id.btn_basic_dialog:
                    Intent intent3 = new Intent();
                    intent3.setClass(MainActivity.this, BasicDialogActivity.class);
                    startActivity(intent3);
                    break;

                case R.id.btn_basic_toast:
                    Intent intent4 = new Intent();
                    intent4.setClass(MainActivity.this,BasicToastActivity.class);
                    startActivity(intent4);
                    break;

                case R.id.btn_basic_menu:
                    Intent intent5 = new Intent();
                    intent5.setClass(MainActivity.this, MenuActivity.class);
                    startActivity(intent5);
                    break;

                case R.id.btn_basic_guide:
                    Intent intent6 = new Intent();
                    intent6.setClass(MainActivity.this, MyTableActivity.class);
                    startActivity(intent6);
                    break;

                case R.id.btn_basic_adapter:
                    Intent intent7 = new Intent();
                    intent7.setClass(MainActivity.this, BasicAdapterActivity.class);
                    startActivity(intent7);
                    break;

            }
        }
    }
}
