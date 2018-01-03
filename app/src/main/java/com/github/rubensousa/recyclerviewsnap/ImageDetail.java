package com.github.rubensousa.recyclerviewsnap;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ImageDetail extends AppCompatActivity {

    private TabLayout tabLayout;
    private List<String> titles = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentAdapter adapter;
    private ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        initData();
        initView();
    }

    private void initData() {
        titles.add("Image Detail");
        titles.add("Documentation");


        fragments.add(new Tab1());
        fragments.add(new Tab2());

    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        vp = (ViewPager) findViewById(R.id.vp);
        adapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);
        vp.setAdapter(adapter);
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));


        tabLayout.setupWithViewPager(vp);
    }
}
