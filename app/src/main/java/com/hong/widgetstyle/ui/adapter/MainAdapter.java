package com.hong.widgetstyle.ui.adapter;


import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hong.widgetstyle.R;
import com.hong.widgetstyle.bean.TypleBean;

 import java.util.List;

/**
 * Created by root on 2018/9/10.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<TypleBean> list;
    private Handler handler;

    public MainAdapter(Context context, List<TypleBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_recycler_file, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        TypleBean typleBean = list.get(position);
        if (null == typleBean) {
            return;
        }

        if (holder instanceof MainViewHolder) {
            ((MainViewHolder)holder).tvItem.setText(list.get(position).getTitle());
            ((MainViewHolder)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Message msg = handler.obtainMessage(0);
                    msg.obj = list.get(position).getType();
                    handler.removeMessages(0);
                    handler.sendMessageDelayed(msg, 100);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MainViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;

        public MainViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView)itemView.findViewById(R.id.tv_reccycle_item);
        }
    }
}
