package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

/**
 * Created by Cary on 2017/3/12.
 */

public class ToggleButtonActivity extends Activity {

    private ImageView imageView;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggle_button_layout);

        imageView = (ImageView) findViewById(R.id.img_light_on);
        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setTextOn("关灯");
        toggleButton.setTextOff("开灯");
        toggleButton.setChecked(false);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    imageView.setImageResource(R.mipmap.open);
                }else {
                    imageView.setImageResource(R.mipmap.close);
                }
            }
        });

    }
}
