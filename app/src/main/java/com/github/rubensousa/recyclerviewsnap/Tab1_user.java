package com.github.rubensousa.recyclerviewsnap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rubensousa.recyclerviewsnap.R;

/**
 * Created by Administrator on 2017/6/13.
 */

public class Tab1_user extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1_user,container,false);
    }
}
