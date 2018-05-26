package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cary on 2017/3/9.
 */

public class GridViewActivity extends Activity {

    private GridView imageGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_layout);

        imageGridView = (GridView) findViewById(R.id.grid_view);
        final List<HashMap<String, Object>> mapsList = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 60; i++) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("Image", R.mipmap.guanyin);
            hashMap.put("text", "人物卡牌"+i);
            hashMap.put("pro", "售价"+i);
            mapsList.add(hashMap);
        }
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(),
                mapsList, R.layout.grid_view_item_layout, new String[] {
                "Image", "text","pro" }, new int[] {R.id.gridItemImage , R.id.gridItemText , R.id.gridItemPriceText});
        imageGridView.setAdapter(adapter);

        imageGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"你选的是"+mapsList.get(position).get("text"),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
