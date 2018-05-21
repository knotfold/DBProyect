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

public class MyAdapterComments extends RecyclerView.Adapter<MyAdapterComments.ViewHolder>{

    private List<ListItemComments> listItems;
    private Context context;

    public MyAdapterComments(List<ListItemComments> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapterComments.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv_comments,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyAdapterComments.ViewHolder holder, int position) {
        final ListItemComments listItem = listItems.get(position);
        holder.textViewComentarioRes.setText(listItem.getComentarioRes());
        holder.textViewNombreCliente.setText(listItem.getNombreCliente());



    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewComentarioRes;
        public TextView textViewNombreCliente;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewComentarioRes = (TextView) itemView.findViewById(R.id.textViewComntarioRes);
            textViewNombreCliente = (TextView) itemView.findViewById(R.id.textViewNombreCliente);

        }
    }
}
