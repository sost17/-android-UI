package com.nsu.zyl.chatper03ui;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Cary on 2017/2/28.
 */
public class BasicAdapterActivity extends ListActivity {

    private ArrayAdapter<String> adapter;
    private String[] items = {"AdapterView控件","ArrayAdapter","SimpleAdapter","自定义Adapter","GridView的使用"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ArrayAdapter<String>(this, R.layout.array_adapter_item, items);
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        switch (position){
            case 0:
                intent.setClass(BasicAdapterActivity.this,AdapterViewActivity.class);
                startActivity(intent);
                break;

            case 1:
                intent.setClass(BasicAdapterActivity.this,ArrayAdapterListActivity.class);
                startActivity(intent);
                break;

            case 2:
                intent.setClass(BasicAdapterActivity.this,SimpleAdapterListActivity.class);
                startActivity(intent);
                break;

            case 3:
                intent.setClass(BasicAdapterActivity.this,FriendListActivity.class);
                startActivity(intent);
                break;

            case 4:
                intent.setClass(BasicAdapterActivity.this,GridViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
