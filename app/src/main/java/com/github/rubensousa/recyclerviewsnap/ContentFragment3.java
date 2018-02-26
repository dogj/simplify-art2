package com.github.rubensousa.recyclerviewsnap;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import com.github.rubensousa.recyclerviewsnap.adapter.Adapter;

import java.util.ArrayList;
import java.util.List;

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
public class ContentFragment3 extends Fragment {
    private RecyclerView mRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.contentfragment3,container,false);

        mRecyclerView = view.findViewById(R.id.recyclerView_3);

        Adapter adapter = new Adapter(false, false, getApps());

        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2,
                LinearLayoutManager.VERTICAL, true));
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(adapter);
        new GravitySnapHelper(Gravity.TOP).attachToRecyclerView(mRecyclerView);
        return view;
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






    }

