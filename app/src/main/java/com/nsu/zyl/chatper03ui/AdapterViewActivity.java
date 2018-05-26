package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Cary on 2017/3/9.
 */

public class AdapterViewActivity extends Activity{

    private AutoCompleteTextView autoText;
    private Spinner spinner;
    String[] contents = new String[]{"China","China1", "china2","USA","USA1","USA2","唱歌","china", "cd","ch","chi","chin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_view_layout);
        initView();
    }

    private void initView() {
        autoText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, contents);
        //将adapter1 添加到AutoCompleteTextView中
        autoText.setAdapter(adapter1);
        autoText.setTextColor(Color.BLACK);
        //设置输入2个字符后开始提示
        autoText.setThreshold(2);

        spinner = (Spinner) findViewById(R.id.spinner1);
        //将可选内容与ArrayAdapter连接起来
        final ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.corse_array, android.R.layout.simple_spinner_item);
        //设置下拉列表的风格
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter2 添加到spinner中
        spinner.setAdapter(adapter2);

        spinner.setPrompt("请选择课程");
        spinner.setSelection(0, true);
        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String choice = getResources().getStringArray(R.array.corse_array)[position];
                Toast.makeText(AdapterViewActivity.this,
                        "你选的是"+choice, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
