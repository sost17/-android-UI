package com.nsu.zyl.chatper03ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Cary on 2017/3/9.
 */

public class MyDialog extends AlertDialog {

    private Context context;

    protected MyDialog(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //通过LayoutInflater来获取布局文件对象
        LayoutInflater inflater = LayoutInflater.from(context);
        View userDialog = inflater.inflate(R.layout.user_dialog_layout, null);
        setView(userDialog);
        super.onCreate(savedInstanceState);
    }
}
