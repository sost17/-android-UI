package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cary on 2017/3/9.
 */

public class ArrayAdapterListActivity extends Activity {

    private ListView listView;
    private List<String> dataList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.array_listview_layout);
        listView = (ListView) findViewById(R.id.array_listview);
        dataList = new ArrayList<String>();
        for (int i = 0; i <=50; i++) {
            dataList.add("ListView 测试文本,第"+(i+1)+"项");
        }
        adapter = new ArrayAdapter<String>(this, R.layout.array_adapter_item, dataList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ArrayAdapterListActivity.this, "你点击的是"+(position+1)+"项",
                        Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int myPosition = position;
                new AlertDialog.Builder(ArrayAdapterListActivity.this)
                        .setIcon(R.mipmap.ic_launcher)
                        .setTitle("警告")
                        .setMessage("你确定要删除吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dataList.remove(myPosition);
                                adapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .create().show();

                return true;
            }
        });
    }
}
