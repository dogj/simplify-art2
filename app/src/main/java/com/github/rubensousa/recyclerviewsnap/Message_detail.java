package com.github.rubensousa.recyclerviewsnap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.rubensousa.recyclerviewsnap.adapter.Message_Adapter;
import com.github.rubensousa.recyclerviewsnap.adapter.Message_Adapter_detail;
import com.github.rubensousa.recyclerviewsnap.data.Message_data;
import com.github.rubensousa.recyclerviewsnap.data.Message_data_detail;

public class Message_detail extends AppCompatActivity {

    RecyclerView recyclerView;
    Message_data_detail messageData;
    Message_Adapter_detail adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_message);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        toolbar.setTitle("name");
        toolbar.setTitleMarginStart(260);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.message_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageData = new Message_data_detail();
        messageData.initial();
        adapter = new Message_Adapter_detail(messageData.getListData(), this);
        adapter.setOnItemClickListener(new Message_Adapter_detail.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(Message_detail.this,data,Toast.LENGTH_SHORT).show();
                int item_position = Integer.parseInt(data);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
