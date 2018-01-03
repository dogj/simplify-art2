package com.github.rubensousa.recyclerviewsnap;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    public static final String ORIENTATION = "orientation";

    private RecyclerView mRecyclerView;
    private boolean mHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setTitle("Simplify");
        toolbar.setTitleMarginStart(100);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        toolbar.setOnMenuItemClickListener(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        if (savedInstanceState == null) {
            mHorizontal = true;
        } else {
            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);
        }

        setupAdapter();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION, mHorizontal);
    }

    private void setupAdapter() {
        List<App> apps = getApps();
        List<App> artists = getArtist();

        SnapAdapter snapAdapter = new SnapAdapter();
        if (mHorizontal) {
            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "Pcitures", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "Artists", artists));
            snapAdapter.addSnap(new Snap(Gravity.END, "Materials", apps));
            snapAdapter.addSnap(new Snap(Gravity.CENTER, "Art type", apps));
            mRecyclerView.setAdapter(snapAdapter);
        } else {
            Adapter adapter = new Adapter(false, false, apps);
            mRecyclerView.setAdapter(adapter);
            new GravitySnapHelper(Gravity.TOP, false, new GravitySnapHelper.SnapListener() {
                @Override
                public void onSnap(int position) {
                    Log.d("Snapped", position + "");
                }
            }).attachToRecyclerView(mRecyclerView);
        }
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

    private List<App> getArtist() {
        List<App> apps = new ArrayList<>();
        apps.add(new App("Vango", R.drawable.van, "descripton"));
        apps.add(new App("Picasso", R.drawable.bi, "descripton"));
        apps.add(new App("Rubens", R.drawable.rubens, "descripton"));
        apps.add(new App("Rembrandit", R.drawable.rembrandt, "descripton"));
        apps.add(new App("Michelangelo", R.drawable.mikailangjiluo, "descripton"));
        apps.add(new App("Da Vinci", R.drawable.dafenqi, "descripton"));
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

        if(id == android.R.id.home)
        {
            finish();
            return true;
        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(this, ImageDetail.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, GridActivity.class));
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }else if (id == R.id.login) {
            startActivity(new Intent(this, Login.class));
        }



        return true;
    }


//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        if (item.getItemId() == R.id.layoutType) {
//            mHorizontal = !mHorizontal;
//            setupAdapter();
//            Log.v("App", "haha");
//            item.setTitle(mHorizontal ? "Vertical" : "Horizontal");
//        } else if (item.getItemId() == R.id.grid) {
//            startActivity(new Intent(this, GridActivity.class));
//        }
//        return false;
//    }
}