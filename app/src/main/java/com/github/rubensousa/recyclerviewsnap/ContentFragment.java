package com.github.rubensousa.recyclerviewsnap;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

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
public class ContentFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.contentfragment,container,false);
        mRecyclerView = view.findViewById(R.id.recyclerView_1);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setHasFixedSize(true);


        setupAdapter();
        return view;
    }

    private void setupAdapter() {
        List<App> apps = getApps();
        List<App> artists = getArtist();

        SnapAdapter snapAdapter = new SnapAdapter();

            snapAdapter.addSnap(new Snap(Gravity.CENTER_HORIZONTAL, "Pcitures", apps));
            snapAdapter.addSnap(new Snap(Gravity.START, "Artists", artists));
            snapAdapter.addSnap(new Snap(Gravity.END, "Materials", apps));
            snapAdapter.addSnap(new Snap(Gravity.CENTER, "Art type", apps));
            mRecyclerView.setAdapter(snapAdapter);

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

}
