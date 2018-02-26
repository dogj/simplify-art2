package com.github.rubensousa.recyclerviewsnap.data;

import com.github.rubensousa.recyclerviewsnap.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class Message_data {
    private static  List<Integer> icon = new ArrayList<>();
    private static List<String> message = new ArrayList<>();
    private static List<String> name = new ArrayList<>();

    public void initial(){
        if(message.size()<2) {
            for(int a =0;a<5;a++){
                message.add("hello");
                message.add("thank you");
                message.add("I like your work");
                icon.add(R.drawable.bi);
                icon.add(R.drawable.dafenqi);
                icon.add(R.drawable.icon_photo);
                name.add("jon");
                name.add("tom");
                name.add("jon");
            }
        }
    }

    public void adddata(String message_new,Integer icon_new,String name_new){

        message.add(message_new);
        icon.add(icon_new);
        name.add(name_new);
    }

    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();

        for ( int i = 0; i <message.size()&& i<icon.size(); i++){
            ListItem item = new ListItem();
            item.setImageResId(icon.get(i));
            item.setMessage(message.get(i));
            item.setName(name.get(i));
            data.add(item);
        }
        return data;
    }
}
