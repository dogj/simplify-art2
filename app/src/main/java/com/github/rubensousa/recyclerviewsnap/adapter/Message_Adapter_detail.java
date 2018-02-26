package com.github.rubensousa.recyclerviewsnap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.rubensousa.recyclerviewsnap.R;
import com.github.rubensousa.recyclerviewsnap.data.ListItem;
import com.github.rubensousa.recyclerviewsnap.data.ListItem2;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class Message_Adapter_detail extends RecyclerView.Adapter<Message_Adapter_detail.MyViewHolder> implements View.OnClickListener {

    public static final int sender = 0;
    public static final int receiver = 1;
    private List<ListItem2> listData;
    private LayoutInflater inflater;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public Message_Adapter_detail(List<ListItem2> listData, Context c){

        this.inflater= LayoutInflater.from(c);
        this.listData= listData;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
            View view = inflater.inflate(R.layout.message_send,parent,false);
            view.setOnClickListener(this);
            return new MyViewHolder(view);
        }else{
            View view = inflater.inflate(R.layout.message_get,parent,false);
            view.setOnClickListener(this);
            return new MyViewHolder(view);
        }


    }


    @Override
    public int getItemViewType(int position) {
        ListItem2 listItem2 = listData.get(position);
        switch (listItem2.getType()) {
            case 0:
                return 0;
            case 2:
                return 1;
        }

        return 0;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ListItem2 item =listData.get(position);
        holder.itemView.setTag(position);
        holder.name.setText(item.getName());
        holder.message.setText(item.getMessage() );
        holder.face.setImageResource(item.getImageResId());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView message;
        public TextView time;
        public ImageView face;


        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            message=(TextView)itemView.findViewById(R.id.message);
            face = itemView.findViewById(R.id.face);
            time = itemView.findViewById(R.id.time);
        }
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, String.valueOf(v.getTag()));

            //注意这里使用getTag方法获取数据

//            listData.remove(Integer.parseInt(String.valueOf(v.getTag())));
//            notifyItemRangeRemoved(Integer.parseInt(String.valueOf(v.getTag())),listData.size());
//           notifyItemRemoved(Integer.parseInt(String.valueOf(v.getTag())));
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public  interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }

    public void removeItem(int position){
        listData.remove(position);
        notifyItemRangeRemoved(position,listData.size());
        notifyItemRemoved(position);

    }
}
