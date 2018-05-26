package com.nsu.zyl.chatper03ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Cary on 2017/3/6.
 */

public class MenuContentActivity extends Activity {

    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        imageView = (ImageView) findViewById(R.id.img_menu);
        registerForContextMenu(imageView);

        button = (Button) findViewById(R.id.btn_pop_menu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MenuContentActivity.this,button);
                popupMenu.getMenuInflater().inflate(R.menu.pop_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.mi_qq:
                                Toast.makeText(MenuContentActivity.this, "你打算分享到QQ空间哇", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.mi_friend:
                                Toast.makeText(MenuContentActivity.this, "你打算分享到朋友圈哇", Toast.LENGTH_SHORT).show();
                                break;

                            default:
                                break;
                        }
                        return true;
                    }
                });
                //使用反射，强制显示菜单图标
                try {
                    Field field = popupMenu.getClass().getDeclaredField("mPopup");
                    field.setAccessible(true);
                    MenuPopupHelper mHelper = (MenuPopupHelper) field.get(popupMenu);
                    mHelper.setForceShowIcon(true);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
                //显示下拉菜单
                popupMenu.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        try {
            Class<?> menuClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method menuMethod = menuClass.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            menuMethod.setAccessible(true);
            menuMethod.invoke(menu, true);
        }catch (Exception e) {
            e.printStackTrace();
        }

        MenuItem show_item = menu.add(0, Menu.FIRST, 0, "显示").setIcon(R.mipmap.ic_launcher);
        //子菜单
        SubMenu shareMenu = menu.addSubMenu(0, Menu.FIRST+1, 0, "分享").setIcon(R.mipmap.ic_launcher);
        shareMenu.setHeaderIcon(R.mipmap.ic_launcher);
        shareMenu.setHeaderTitle("分享到...");
        shareMenu.add(0, 100, 0, "微信");
        shareMenu.add(0, 101, 0, "QQ");
        shareMenu.add(0, 102, 0, "新浪微博");

        MenuItem detail_item = menu.add(0, Menu.FIRST+2, 0, "详细");
        MenuItem save_item = menu.add(0, Menu.FIRST+3, 0, "保存").setIcon(R.mipmap.ic_launcher);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case Menu.FIRST:
                Toast.makeText(MenuContentActivity.this, "你点击了第一个菜单", Toast.LENGTH_SHORT).show();
                break;

            case 100:
                Toast.makeText(MenuContentActivity.this, "你打算分享到微信哇", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        switch (v.getId()) {
            case R.id.img_menu:
                menu.setHeaderIcon(R.mipmap.ic_launcher);
                menu.setHeaderTitle("分享到......");
                //menu.add(int groupId, int itemId, int order, CharSequence title)
                menu.add(0, 200, 0, "QQ空间");
                menu.add(0, 201, 0, "朋友圈");
                SubMenu subMenu = menu.addSubMenu(0, 202, 0, "微博...");
                subMenu.add(0, 203, 0, "腾讯微博");
                subMenu.add(0, 204, 0, "新浪微博");
                break;

            default:
                break;
        }

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 200:
                Toast.makeText(MenuContentActivity.this, "你打算分享到QQ空间哇", Toast.LENGTH_SHORT).show();
                break;
            case 201:
                Toast.makeText(MenuContentActivity.this, "你打算分享到朋友圈哇", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
