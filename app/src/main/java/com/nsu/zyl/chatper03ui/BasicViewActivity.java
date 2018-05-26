package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.nsu.zyl.chatper03ui.R.id.cbx_d;

/**
 * Created by Cary on 2017/2/28.
 */
public class BasicViewActivity extends Activity{

    private RadioGroup sexChoice;
    private TextView sexResult;

    private CheckBox cbxA,cbxB,cbxC,cbxD;
    private TextView answerResult;
    private Button btnSubmit;
    private List<CheckBox> cbxList = new ArrayList<CheckBox>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbox_radio_layout);
        //获取页面上的控件
        sexChoice = (RadioGroup) findViewById(R.id.radio_sex);
        sexResult = (TextView) findViewById(R.id.tv_radio_result);

        sexChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton choice = (RadioButton) findViewById(sexChoice.getCheckedRadioButtonId());
                sexResult.setText("你选择的性别是"+choice.getText().toString());
            }
        });

        cbxA = (CheckBox) findViewById(R.id.cbx_a);
        cbxB = (CheckBox) findViewById(R.id.cbx_b);
        cbxC = (CheckBox) findViewById(R.id.cbx_c);
        cbxD = (CheckBox) findViewById(R.id.cbx_d);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        answerResult = (TextView) findViewById(R.id.tv_cbx_result);

        cbxList.add(cbxA);
        cbxList.add(cbxB);
        cbxList.add(cbxC);
        cbxList.add(cbxD);

        for (final CheckBox cbx:cbxList) {
            cbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        Toast.makeText(BasicViewActivity.this,cbx.getText().toString()+"已选中",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(BasicViewActivity.this,cbx.getText().toString()+"已取消",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer sb = new StringBuffer();
                //遍历集合中的checkBox,判断是否选择，获取选中的文本
                for (CheckBox cbx : cbxList) {
                    if (cbx.isChecked()){
                        sb.append(cbx.getText().toString() + " ");
                    }
                }
                if (sb!=null && "".equals(sb.toString())){
                    Toast.makeText(BasicViewActivity.this, "请至少选择一个", Toast.LENGTH_SHORT).show();
                }else{
                    answerResult.setText("你的选择是 "+sb.toString());
                }

            }
        });

    }
}
