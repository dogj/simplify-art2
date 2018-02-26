package com.github.rubensousa.recyclerviewsnap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.github.rubensousa.recyclerviewsnap.adapter.Message_Adapter;
import com.github.rubensousa.recyclerviewsnap.data.Message_data;

public class Message extends AppCompatActivity {

    RecyclerView recyclerView;
    Message_data messageData;
    Message_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message);
        recyclerView = findViewById(R.id.message_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageData = new Message_data();
        messageData.initial();
        adapter = new Message_Adapter(Message_data.getListData(), this);
        adapter.setOnItemClickListener(new Message_Adapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(Message.this,data,Toast.LENGTH_SHORT).show();
                int item_position = Integer.parseInt(data);
                startActivity(new Intent(Message.this, Message_detail.class));
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
        recyclerView.setAdapter(adapter);
    }
}
