package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Cary on 2017/2/28.
 */
public class BasicDialogActivity extends Activity{

    private Button btn_dialog1;
    private Button btn_dialog2;
    private Button btn_dialog3;
    private Button btn_dialog4;
    private Button btn_dialog5;
    private Button btn_dialog6;
    private Button btn_dialog7;
    private Button btn_dialog8;
    private Button btn_dialog9;

    private boolean[] user_choice;
    private int index;
    String results = "你选择的是：";
    int year;
    int month;
    int dayOfMonth;
    int hourOfDay;
    int minute;
    Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calendar.setTimeInMillis(System.currentTimeMillis());
        setContentView(R.layout.basic_dialog);
        initView();
    }

    private void initView() {
        btn_dialog1 = (Button)findViewById(R.id.btn_dialog_1);
        btn_dialog1.setOnClickListener(new MyButtonClickListener());
        btn_dialog2 = (Button)findViewById(R.id.btn_dialog_2);
        btn_dialog2.setOnClickListener(new MyButtonClickListener());
        btn_dialog3 = (Button)findViewById(R.id.btn_dialog_3);
        btn_dialog3.setOnClickListener(new MyButtonClickListener());
        btn_dialog4 = (Button)findViewById(R.id.btn_dialog_4);
        btn_dialog4.setOnClickListener(new MyButtonClickListener());
        btn_dialog5 = (Button)findViewById(R.id.btn_dialog_5);
        btn_dialog5.setOnClickListener(new MyButtonClickListener());
        btn_dialog6 = (Button)findViewById(R.id.btn_dialog_6);
        btn_dialog6.setOnClickListener(new MyButtonClickListener());
        btn_dialog7 = (Button)findViewById(R.id.btn_dialog_7);
        btn_dialog7.setOnClickListener(new MyButtonClickListener());
        btn_dialog8 = (Button)findViewById(R.id.btn_dialog_8);
        btn_dialog8.setOnClickListener(new MyButtonClickListener());
        btn_dialog9 = (Button)findViewById(R.id.btn_dialog_9);
        btn_dialog9.setOnClickListener(new MyButtonClickListener());
    }

    private class MyButtonClickListener implements View.OnClickListener,Runnable {

        ProgressDialog pDialog = new ProgressDialog(BasicDialogActivity.this);

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog_1:
                    new AlertDialog.Builder(BasicDialogActivity.this)
                            .setIcon(R.drawable.launcher_icon)
                            .setTitle("注意")
                            .setMessage("确定要退出吗？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            })
                            .setNegativeButton("取消", null)
                            .create()
                            .show();
                    break;

                case R.id.btn_dialog_2:
                    AlertDialog.Builder builder = new AlertDialog.Builder(BasicDialogActivity.this);
                    builder.setTitle("请选择性别");
                    builder.setCancelable(false);
                    builder.setSingleChoiceItems(R.array.sex_array, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            index = which;
                            String content = getResources().getStringArray(R.array.sex_array)[which];
                            Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String content = getResources().getStringArray(R.array.sex_array)[index];
                            Toast.makeText(getApplicationContext(), "你的选择是" + content, Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.create().show();
                    break;

                case R.id.btn_dialog_3:
                    user_choice = new boolean[getResources().getStringArray(R.array.city_array).length];
                    new AlertDialog.Builder(BasicDialogActivity.this)
                            .setTitle("复选对话框")
                            .setMultiChoiceItems(R.array.city_array, null, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    user_choice[which] = isChecked;
                                }
                            })
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    for (int i = 0; i < user_choice.length; i++) {
                                        if (user_choice[i]) {
                                            results = results + getResources().getStringArray(R.array.city_array)[i];
                                        }
                                    }
                                    Toast.makeText(getApplicationContext(), results, Toast.LENGTH_SHORT).show();
                                    results = "你选择的是：";
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create().show();
                    break;

                case R.id.btn_dialog_4:
                    new AlertDialog.Builder(BasicDialogActivity.this)
                            .setTitle("列表对话框")
                            .setItems(R.array.city_array, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    String content = "你点击的是：" + getResources().getStringArray(R.array.city_array)[which];
                                    Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .create()
                            .show();
                    break;

                case R.id.btn_dialog_5:
                    pDialog.setTitle("文件下载中");
                    pDialog.setIcon(R.drawable.launcher_icon);
                    pDialog.setMax(100);
                    pDialog.setMessage("文件已下载");
                    //设置进度条风格 STYLE_SPINNER圆形 旋转 STYLE_HORIZONTAL长形进度条
                    pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    //是否可以按back键取消
                    pDialog.setCancelable(true);
                    pDialog.show();
                    new Thread(this).start();


                    break;

                case R.id.btn_dialog_6:
                    //获取年
                    year = calendar.get(Calendar.YEAR);
                    //获取月，从0开始
                    month = calendar.get(Calendar.MONTH);
                    //获取日
                    dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                    //监听日期设置
                    DatePickerDialog.OnDateSetListener listener1 = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int m_year, int m_month, int m_dayOfMonth) {
                            year = m_year;
                            month = m_month + 1;
                            dayOfMonth = m_dayOfMonth;
                            Toast.makeText(BasicDialogActivity.this, "你设置的时间是：" + year + "年" + month + "月" + dayOfMonth + "日",
                                    Toast.LENGTH_SHORT).show();
                        }
                    };

                    DatePickerDialog dpDialog = new DatePickerDialog(BasicDialogActivity.this,
                            listener1, year, month, dayOfMonth);
                    dpDialog.setIcon(R.drawable.launcher_icon);
                    dpDialog.setMessage("请选择日期");
                    dpDialog.show();
                    break;

                case R.id.btn_dialog_7:

                    //监听时间的设置
                    TimePickerDialog.OnTimeSetListener listener2 = new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int m_hourOfDay, int m_minute) {
                            hourOfDay = m_hourOfDay;
                            minute = m_minute;
                            Toast.makeText(BasicDialogActivity.this, "你设置的时间是： " + hourOfDay + " : " + minute, Toast.LENGTH_SHORT).show();
                        }
                    };

                    TimePickerDialog tpDialog = new TimePickerDialog(BasicDialogActivity.this, listener2,
                            calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
                    tpDialog.setIcon(R.drawable.launcher_icon);
                    tpDialog.setMessage("请设置时间");
                    tpDialog.show();
                    break;

                case R.id.btn_dialog_8:
                    View seekView = getLayoutInflater().inflate(R.layout.seek_dialog, null);
                    SeekBar sbar = (SeekBar) seekView.findViewById(R.id.seekBar1);
                    sbar.setMax(100);
                    final TextView tv_seekbar = (TextView) seekView.findViewById(R.id.tv_seekbar);
                    tv_seekbar.setText("当前的进度为：" + sbar.getProgress());
                    sbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
                        @Override
                        public void onStopTrackingTouch(SeekBar seekBar){

                        }

                        @Override
                        public void onStartTrackingTouch(SeekBar seekBar){

                        }

                        @Override
                        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                            tv_seekbar.setText("当前的进度为：" + seekBar.getProgress());
                        }
                    });
                    new AlertDialog.Builder(BasicDialogActivity.this)
                            .setTitle("拖动对话框")
                            .setView(seekView)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .create()
                            .show();

                    break;

                case R.id.btn_dialog_9:
                    //创建自定义的Dialog对象
                    final MyDialog userDialog = new MyDialog(BasicDialogActivity.this);
                    //设置对话框的图标
                    userDialog.setIcon(R.mipmap.ic_launcher);
                    //设置标题
                    userDialog.setTitle("自定义对话框");
                    //显示对话框
                    userDialog.show();
                    //通过MyDialog对象找到相关控件
                    Button btn_ok = (Button) userDialog.findViewById(R.id.btn_ok_dialog);
                    Button btn_cancel = (Button) userDialog.findViewById(R.id.btn_cancel_dialog);
                    final EditText et_userName = (EditText) userDialog.findViewById(R.id.et_username_dialog);
                    final EditText et_pwd = (EditText) userDialog.findViewById(R.id.et_pwd_dialog);
                    //设置按钮的监听事件
                    btn_ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String userName = et_userName.getText().toString();
                            String userPwd = et_pwd.getText().toString();
                            //弹出一个短消息
                            Toast.makeText(BasicDialogActivity.this, "用户名"+userName+"密码"+userPwd, Toast.LENGTH_SHORT).show();
                        }
                    });
                   btn_cancel.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           //回收对话框
                           userDialog.dismiss();
                       }
                   });
                    break;

            }
        }

        @Override
        public void run() {
            int progress = 0;
            while (progress < 100) {
                try {
                    Thread.sleep(100);
                    progress++;
                    pDialog.incrementProgressBy(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
