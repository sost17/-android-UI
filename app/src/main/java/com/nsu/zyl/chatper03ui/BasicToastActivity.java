package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cary on 2017/3/8.
 */

public class BasicToastActivity extends Activity implements View.OnClickListener{

    private Button btnNormalToast;
    private Button btnGravityToast;
    private Button btnPicToast;
    private Button btnDiyToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_toast);
        btnNormalToast = (Button) findViewById(R.id.btn_normal_toast);
        btnGravityToast = (Button) findViewById(R.id.btn_gravity_toast);
        btnPicToast = (Button) findViewById(R.id.btn_pic_toast);
        btnDiyToast = (Button) findViewById(R.id.btn_diy_toast);
        btnNormalToast.setOnClickListener(this);
        btnGravityToast.setOnClickListener(this);
        btnPicToast.setOnClickListener(this);
        btnDiyToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_normal_toast:
                Toast.makeText(this, "这是一个默认的Toast消息", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_gravity_toast:
                Toast toast1 = Toast.makeText(this,"这是一个自定义位置的Toast消息",Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.TOP|Gravity.CENTER, -50, 100);
                toast1.show();
                break;

            case R.id.btn_pic_toast:
                Toast toast2 = Toast.makeText(this,"这是一个显示图片的Toast消息",Toast.LENGTH_SHORT);
                //创建图片视图对象
                ImageView imageView= new ImageView(getApplicationContext());
                //设置图片
                imageView.setImageResource(R.mipmap.ic_launcher);
                //获得toast的布局
                LinearLayout toastView = (LinearLayout) toast2.getView();
                //设置此布局为横向的
                toastView.setOrientation(LinearLayout.HORIZONTAL);
                //将ImageView在加入到此布局中的第一个位置
                toastView.addView(imageView, 0);
                toast2.show();
                break;

            case R.id.btn_diy_toast:
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.toast_diy_layout,null);
                ImageView imgToast = (ImageView) view.findViewById(R.id.img_diy_toast);
                imgToast.setImageResource(R.mipmap.ic_launcher);
                TextView tvToast = (TextView) view.findViewById(R.id.tv_diy_toast);
                tvToast.setText("这是一个自定义视图的Toast消息");

                Toast toast3 = new Toast(this);
                toast3.setGravity(Gravity.CENTER, 0, 0);
                toast3.setDuration(Toast.LENGTH_SHORT);
                toast3.setView(view);
                toast3.show();
                break;
        }
    }
}
