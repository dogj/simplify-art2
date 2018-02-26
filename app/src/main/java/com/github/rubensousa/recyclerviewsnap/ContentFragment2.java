package com.github.rubensousa.recyclerviewsnap;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.github.rubensousa.recyclerviewsnap.adapter.Message_Adapter;
import com.github.rubensousa.recyclerviewsnap.data.Message_data;

/***
 * ━━━━ Code is far away from ━━━━━━
 * 　　  () 　　　  ()
 * 　　  ( ) 　　　( )
 * 　　  ( ) 　　　( )
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━ bug with the more protecting ━━━
 * <p/>
 * Created by PangHaHa12138 on 2017/6/6.
 */
public class ContentFragment2 extends Fragment {

    Message_data messageData;
    Message_Adapter adapter;
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.contentfragment2,container,false);
        mRecyclerView = view.findViewById(R.id.recyclerView_2);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        messageData = new Message_data();
        messageData.initial();
        adapter = new Message_Adapter(Message_data.getListData(), getActivity());
        adapter.setOnItemClickListener(new Message_Adapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                int item_position = Integer.parseInt(data);
                startActivity(new Intent(getActivity(), Message_detail.class));
//                SharedPreferences.Editor sharedata = getSharedPreferences("groupData", 0).edit();
//                sharedata.putString("position",data);
//                sharedata.commit();
//
//
//
//                Intent intent = new Intent(Course_home.this,TaskHome.class);
//                intent.putExtra("position",data);
//                startActivity(intent);
            }
        });

//        adapter.setOnItemClickListener(new Adapter2.OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, String groupData) {
//                Toast.makeText(AddTask.this,groupData,Toast.LENGTH_SHORT).show();
//            }
//        });
        mRecyclerView.setAdapter(adapter);


        return view;

    }



}
