package com.github.rubensousa.recyclerviewsnap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;


public class GridActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        mRecyclerView = findViewById(R.id.recyclerView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Adapter adapter = new Adapter(false, false, getApps());

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2,
                LinearLayoutManager.VERTICAL, true));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        new GravitySnapHelper(Gravity.TOP).attachToRecyclerView(mRecyclerView);
    }

    private List<App> getApps() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("pic1", R.drawable.p1, "descripton"));
        apps.add(new App("pic2", R.drawable.p2, "descripton"));
        apps.add(new App("pic3", R.drawable.p3, "descripton"));
        apps.add(new App("pic4", R.drawable.p4, "descripton"));
        apps.add(new App("pic5", R.drawable.p1, "descripton"));
        apps.add(new App("pic6", R.drawable.p2, "descripton"));
        apps.add(new App("pic7", R.drawable.p3, "descripton"));
        apps.add(new App("pic8", R.drawable.p4, "descripton"));
        return apps;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
