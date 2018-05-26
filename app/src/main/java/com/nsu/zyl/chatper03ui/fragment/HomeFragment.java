package com.nsu.zyl.chatper03ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nsu.zyl.chatper03ui.MainActivity;
import com.nsu.zyl.chatper03ui.R;

/**
 * Created by Cary on 2017/3/10.
 */

public class HomeFragment extends Fragment {

    private Button btn_home;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_activity, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_home = (Button) getActivity().findViewById(R.id.btn_home);
        //点击跳转到另一个Activity
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
