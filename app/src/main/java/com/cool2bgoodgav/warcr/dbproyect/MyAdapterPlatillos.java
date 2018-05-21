package com.cool2bgoodgav.warcr.dbproyect;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by warcr on 05/12/2017.
 */

public class MyAdapterPlatillos extends RecyclerView.Adapter<MyAdapterPlatillos.ViewHolder>{

    private List<ListItemPlatillos> listItems;
    private Context context;

    public MyAdapterPlatillos(List<ListItemPlatillos> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapterPlatillos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv_platillos,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyAdapterPlatillos.ViewHolder holder, int position) {
        final ListItemPlatillos listItem = listItems.get(position);
        holder.textViewNombrePlatillo.setText(listItem.getNombrePlatillo());
        holder.textViewCostoPlatillo.setText(listItem.getCostoPlatillo());
        holder.textViewTipoPlatillo.setText(listItem.getTipoPlatillo());
        holder.textViewDescripcionPlatillo.setText(listItem.getDescripcionPlatillo());




    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewNombrePlatillo;
        public TextView textViewCostoPlatillo;
        public TextView textViewTipoPlatillo;
        public TextView textViewDescripcionPlatillo;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewNombrePlatillo = (TextView) itemView.findViewById(R.id.textViewNombrePlatillo);
            textViewCostoPlatillo = (TextView) itemView.findViewById(R.id.textViewCostoPlatillo);
            textViewTipoPlatillo = (TextView) itemView.findViewById(R.id.textViewTipoPlatillo);
            textViewDescripcionPlatillo = (TextView) itemView.findViewById(R.id.textViewDescripcionPlatillo);

        }
    }
}
