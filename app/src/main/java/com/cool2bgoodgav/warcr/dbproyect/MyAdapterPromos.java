package com.cool2bgoodgav.warcr.dbproyect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by warcr on 05/12/2017.
 */

public class MyAdapterPromos extends RecyclerView.Adapter<MyAdapterPromos.ViewHolder>{

    private List<ListItemPromos> listItems;
    private Context context;

    public MyAdapterPromos(List<ListItemPromos> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapterPromos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv_promos,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyAdapterPromos.ViewHolder holder, int position) {
        ListItemPromos listItem = listItems.get(position);
        Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{



        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
