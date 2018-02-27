package com.github.rubensousa.recyclerviewsnap;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.github.rubensousa.recyclerviewsnap.test.ImageActivity;
import com.yanzhenjie.album.Album;
import com.yanzhenjie.album.AlbumConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    public static final String ORIENTATION = "orientation";

//    private RecyclerView mRecyclerView;
//    private boolean mHorizontal;

    private BottomNavigationBar bottomNavigationBar;
    private ContentFragment contentFragment;
    private ContentFragment2 contentFragment2;
    private ContentFragment3 contentFragment3;
    private ContentFragment4 contentFragment4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        setDefaultFragment();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottomNavigationBar //值得一提，模式跟背景的设置都要在添加tab前面，不然不会有效果。
                .setActiveColor(R.color.green)//选中颜色 图标和文字
//                .setInActiveColor("#8e8e8e")//默认未选择颜色
                .setBarBackgroundColor("#ECECEC");//默认背景色
        bottomNavigationBar.setAutoHideEnabled(false);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.weixin_pressed,"Home").setInactiveIconResource(R.drawable.weixin_normal))
                .addItem(new BottomNavigationItem(R.drawable.contact_list_pressed,"Contact").setInactiveIconResource(R.drawable.contact_list_normal))
                .addItem(new BottomNavigationItem(R.drawable.find_pressed,"Collection").setInactiveIconResource(R.drawable.find_normal))
//                .addItem(new BottomNavigationItem(R.drawable.profile_pressed,"My settings").setInactiveIconResource(R.drawable.profile_normal))

//                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"Like").setActiveColor().setInActiveColor())
//                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"Home").setActiveColor().setInActiveColor())
//                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp,"Music").setActiveColor().setInActiveColor())
//                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp,"TV").setActiveColor().setInActiveColor())
//                .setFirstSelectedPosition(0)//设置默认选择的按钮
                .initialise();//所有的设置需在调用该方法前完成

        bottomNavigationBar //设置lab点击事件
                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        FragmentManager fm = getFragmentManager();
                        // 开启Fragment事务
                        FragmentTransaction transaction = fm.beginTransaction();
                        switch (position){


                            case 0:
//                                Toast.makeText(MainActivity.this,"竟让有这种操作！",Toast.LENGTH_SHORT).show();
                                if (contentFragment == null)
                                {
                                    contentFragment = new ContentFragment();
                                }
                                transaction.replace(R.id.content, contentFragment);

                                break;
                            case 1:
//                                Toast.makeText(MainActivity.this,"真的有这种操作！",Toast.LENGTH_SHORT).show();
                                if (contentFragment2 == null)
                                {
                                    contentFragment2 = new ContentFragment2();
                                }
                                transaction.replace(R.id.content, contentFragment2);

                                break;
                            case 2:
//                                Toast.makeText(MainActivity.this,"这是假的操作！",Toast.LENGTH_SHORT).show();
                                if (contentFragment3 == null)
                                {
                                    contentFragment3 = new ContentFragment3();
                                }
                                transaction.replace(R.id.content, contentFragment3);

                                break;
                            case 3:
//                                Toast.makeText(MainActivity.this,"我有一句吗卖批不知当讲不当讲！",Toast.LENGTH_SHORT).show();
                                if (contentFragment4 == null)
                                {
                                    contentFragment4 = new ContentFragment4();
                                }
                                transaction.replace(R.id.content, contentFragment4);

                                break;

                        }

                        transaction.commit();
                    }

                    @Override
                    public void onTabUnselected(int position) {

                    }

                    @Override
                    public void onTabReselected(int position) {

                    }
                });


//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
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
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setHasFixedSize(true);
//
//        if (savedInstanceState == null) {
//            mHorizontal = true;
//        } else {
//            mHorizontal = savedInstanceState.getBoolean(ORIENTATION);
//        }
//
//        setupAdapter();
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
//        outState.putBoolean(ORIENTATION, mHorizontal);
    }

//    private void setupAdapter() {
//        List<App> apps = getApps();
//        List<App> artists = getArtist();
//
//        SnapAdapter snapAdapter = new SnapAdapter();
//        if (mHorizontal) {
//            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "Pcitures", apps));
//            snapAdapter.addSnap(new Snap(Gravity.START, "Artists", artists));
//            snapAdapter.addSnap(new Snap(Gravity.END, "Materials", apps));
//            snapAdapter.addSnap(new Snap(Gravity.CENTER, "Art type", apps));
//            mRecyclerView.setAdapter(snapAdapter);
//        } else {
//            Adapter adapter = new Adapter(false, false, apps);
//            mRecyclerView.setAdapter(adapter);
//            new GravitySnapHelper(Gravity.TOP, false, new GravitySnapHelper.SnapListener() {
//                @Override
//                public void onSnap(int position) {
//                    Log.d("Snapped", position + "");
//                }
//            }).attachToRecyclerView(mRecyclerView);
//        }
//    }

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
            startActivity(new Intent(this, Message.class));
        } else if (id == R.id.nav_manage) {
            startActivity(new Intent(this, Message_detail.class));
        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this, ImageActivity.class));

        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, ImageSelect.class));
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

    private void setDefaultFragment()
    {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        contentFragment = new ContentFragment();
        transaction.replace(R.id.content, contentFragment);
        transaction.commit();
    }


}
