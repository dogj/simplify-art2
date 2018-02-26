package com.github.rubensousa.recyclerviewsnap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.github.rubensousa.recyclerviewsnap.data.ListItem;
import com.github.rubensousa.recyclerviewsnap.R;

import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

/**
 * Created by Administrator on 2017/1/9.
 */

public class Message_Adapter extends RecyclerView.Adapter<Message_Adapter.MyViewHolder> implements View.OnClickListener {


    private List<ListItem> listData;
    private LayoutInflater inflater;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public Message_Adapter(List<ListItem> listData, Context c){

        this.inflater= LayoutInflater.from(c);
        this.listData= listData;
        Log.d(TAG, this.listData+"");
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.message_get,parent,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ListItem item =listData.get(position);
        holder.itemView.setTag(position);
        holder.name.setText(item.getName());
        holder.message.setText(item.getMessage() );
        holder.face.setImageResource(item.getImageResId());
        Log.d(TAG, "test"+item.getName());
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
