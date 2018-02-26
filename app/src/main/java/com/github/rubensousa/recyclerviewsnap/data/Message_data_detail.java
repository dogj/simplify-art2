package com.github.rubensousa.recyclerviewsnap.data;

import com.github.rubensousa.recyclerviewsnap.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/12.
 */

public class Message_data_detail {
    private static  List<Integer> icon = new ArrayList<>();
    private static List<String> message = new ArrayList<>();
    private static List<String> name = new ArrayList<>();
    private static List<Integer> type = new ArrayList<>();

    public void initial(){
        if(message.size()<2) {
            for(int a =0;a<5;a++) {
                message.add("I like you work.");
                message.add("Thank you so much");
                message.add("Are you an Artist in Wellington? Shall we have a dinner?");
                icon.add(R.drawable.bi);
                icon.add(R.drawable.dafenqi);
                icon.add(R.drawable.bi);
                name.add("jon");
                name.add("tom");
                name.add("jon");
                type.add(0);
                type.add(2);
                type.add(0);
            }
        }
    }

    public void adddata(String message_new,Integer icon_new,String name_new, Integer type_new){

        message.add(message_new);
        icon.add(icon_new);
        name.add(name_new);
        type.add(type_new);
    }

    public static List<ListItem2> getListData() {
        List<ListItem2> data = new ArrayList<>();

        for ( int i = 0; i <message.size()&& i<icon.size(); i++){
            ListItem2 item = new ListItem2();
            item.setImageResId(icon.get(i));
            item.setMessage(message.get(i));
            item.setName(name.get(i));
            item.setType(type.get(i));
            data.add(item);
        }
        return data;
    }
}
