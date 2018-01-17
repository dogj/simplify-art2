package com.github.rubensousa.recyclerviewsnap;

import android.app.LauncherActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class Message_data {
    private static  List<Integer> icon = new ArrayList<>();
    private static List<String> message = new ArrayList<>();
    private static List<Integer> type = new ArrayList<>();

    public void initial(){
        message.add("第一");
        message.add("第二");
        message.add("第三");
        icon.add(R.drawable.bi);
        icon.add(R.drawable.dafenqi);
        icon.add(R.drawable.bi);
        type.add(2);
        type.add(0);
        type.add(2);
    }

    public void adddata(String message_new,Integer icon_new,Integer type_new){

        message.add(message_new);
        icon.add(icon_new);
        type.add(type_new);
    }

    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();

        for ( int i = 0; i <message.size()&& i<icon.size(); i++){
            ListItem item = new ListItem();
            item.setImageResId(icon.get(i));
            item.setMessage(message.get(i));
            item.setType(type.get(i));
            data.add(item);
        }
        return data;
    }
}
