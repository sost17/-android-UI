package com.nsu.zyl.chatper03ui;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cary on 2017/3/9.
 */

public class MyAdapter extends BaseAdapter{

    private Context context;//运行上下文
    private List<Map<String, Object>> listItems;//好友信息集合
    private LayoutInflater listContainer;//视图容器
    //用于存储CheckBox选中状态
    public  Map<Integer,Boolean> cbxFlag = null;


    public class ViewHolder{
        //自定义控件集合
        public ImageView image;
        public TextView name;
        public TextView msg;
        public CheckBox cbx;
        public Button detail;
    }

    public MyAdapter(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
        cbxFlag = new HashMap<Integer, Boolean>();
        init();

    }

    private void init() {
        for (int i = 0; i < listItems.size(); i++) {
            cbxFlag.put(i, false);
        }
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public boolean hasChecked(int position) {
        return cbxFlag.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int selectId = position;
        ViewHolder holder = null;

        if (convertView == null) {
            holder = new ViewHolder();
            //获取list_item布局文件的视图
            convertView = listContainer.inflate(R.layout.friend_list_item_layout, null);
            //获取控件对象
            holder.image = (ImageView) convertView.findViewById(R.id.iv_friend);
            holder.name = (TextView) convertView.findViewById(R.id.tv_friend_name);
            holder.msg = (TextView) convertView.findViewById(R.id.tv_friend_msg);
            holder.cbx = (CheckBox) convertView.findViewById(R.id.cbx_friend);
            holder.detail = (Button) convertView.findViewById(R.id.btn_friend_detail);
            //设置控件集到convertView
            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        //设置颜色交替
        if (position%2 ==0) {
            convertView.setBackgroundColor(Color.parseColor("#CAFFFF"));
        } else {
            convertView.setBackgroundColor(Color.parseColor("#B3FAFAFA"));
        }

        holder.image.setImageResource((Integer) listItems.get(position).get("image"));
        holder.name.setText((String) listItems.get(position).get("name"));
        holder.msg.setText((String) listItems.get(position).get("msg"));

        holder.detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setIcon((Integer) listItems.get(selectId).get("image"))
                        .setTitle((String) listItems.get(selectId).get("name"))
                        .setMessage((String) listItems.get(selectId).get("info"))
                        .setPositiveButton("确定", null)
                        .create()
                        .show();
            }
        });
        holder.cbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cbxFlag.put(selectId, true);
                } else {
                    cbxFlag.put(selectId, false);
                }
            }
        });
        holder.cbx.setChecked(cbxFlag.get(selectId));
        return convertView;
    }
}
