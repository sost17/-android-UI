package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cary on 2017/3/9.
 */

public class FriendListActivity extends Activity{

    private ListView listView;
    private MyAdapter listaAdapter;
    private List<Map<String, Object>> listItems;

    private Integer[] imgeIDs = {R.mipmap.baigujing,R.mipmap.sunwukong,
            R.mipmap.zhubajie,R.mipmap.shaseng,R.mipmap.guanyin,
            R.mipmap.baigujing,R.mipmap.baigujing,R.mipmap.baigujing,R.mipmap.baigujing,R.mipmap.baigujing,R.mipmap.baigujing};

    private String[] friendNames = {"女儿国王", "孙悟空",
            "猪八戒", "沙僧", "观音姐姐", "白骨精","东海龙女","龙套1","龙套2","龙套3","龙套4"};

    private String[] msgs = {"御弟哥哥，你好哇","师傅，小心妖怪","师傅，咱歇一歇",
            "师傅，请喝水","你太墨迹了","吃你的肉可以长生？","你想干啥？","What are you 弄啥呢？","What are you 弄啥呢？","What are you 弄啥呢？","What are you 弄啥呢？"};

    private String[] infos = {"相见难,别亦难,怎诉这胸中语万千","孙悟空是我的大徒弟！","猪八戒就是一头懒猪！",
            "沙悟净是个听话的好徒儿！","救苦救难观世音菩萨","白骨精，一直想吃我的肉，可惜你没后台！","小龙女，你在干啥？","你想咋滴？","你想咋滴？","你想咋滴？","你想咋滴？"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_list_layout);

        listView = (ListView) findViewById(R.id.friendlist);
        listItems = getFriendItems();
        listaAdapter = new MyAdapter(this, listItems);
        listView.setAdapter(listaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listaAdapter.hasChecked(position)) {
                    Toast.makeText(FriendListActivity.this, "你想和" + listItems.get(position).get("name")
                                    + "聊天哇！", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(FriendListActivity.this, "你点我干嘛？" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<Map<String,Object>> getFriendItems() {
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < friendNames.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", imgeIDs[i]);  //图片资源
            map.put("name", friendNames[i]);  //好友名称
            map.put("msg", msgs[i]); //最新消息
            map.put("info", infos[i]);
            listItems.add(map);
        }
        return listItems;
    }
}
