package com.cool2bgoodgav.warcr.dbproyect;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by warcr on 05/12/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<ListItemRes> listItems;
    private Context context;

    public MyAdapter(List<ListItemRes> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv_res,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        final ListItemRes listItem = listItems.get(position);
        holder.textViewIdRestaurante.setText(listItem.getIdRestaurante());
        holder.textViewNombreRes.setText(listItem.getNombreRes());
        holder.textViewUbicacionRes.setText(listItem.getUbicacionRes());
        holder.textViewHorarioRes.setText(listItem.getHorarioRes());
        holder.textViewAforoRes.setText(listItem.getAforoRes());
        holder.textViewTipoRes.setText(listItem.getTipoRes());
        holder.textViewContactoRes.setText(listItem.getContactoRes());
        Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "You clicked" + listItem.getNombreRes(),Toast.LENGTH_LONG).show();

                Intent intent = new Intent(v.getContext(),ResDetails.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_IdRestaurante",listItem.getIdRestaurante());
                extras.putString("EXTRA_NombreRes",listItem.getNombreRes());
                extras.putString("EXTRA_UbicacionRes",listItem.getUbicacionRes());
                extras.putString("EXTRA_HorarioRes",listItem.getHorarioRes());
                extras.putString("EXTRA_AforoRes",listItem.getAforoRes());
                extras.putString("EXTRA_TipoRes",listItem.getTipoRes());
                extras.putString("EXTRA_ContactoRes",listItem.getContactoRes());
                extras.putString("EXTRA_ImageUrl",listItem.getImageUrl());
                extras.putString("EXTRA_Id_Cliente",Config.KEY_EMP_IdCliente);
                intent.putExtras(extras);
                v.getContext().startActivity(intent);






            }
        });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewIdRestaurante;
        public TextView textViewNombreRes;
        public TextView textViewUbicacionRes;
        public TextView textViewHorarioRes;
        public TextView textViewAforoRes;
        public TextView textViewTipoRes;
        public TextView textViewContactoRes;
        public ImageView imageView;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewIdRestaurante = (TextView) itemView.findViewById(R.id.textViewIdRestaurante);
            textViewNombreRes = (TextView) itemView.findViewById(R.id.textViewNombreRes);
            textViewUbicacionRes = (TextView) itemView.findViewById(R.id.textViewUbicacionRes);
            textViewHorarioRes = (TextView) itemView.findViewById(R.id.textViewHorarioRes);
            textViewAforoRes = (TextView) itemView.findViewById(R.id.textViewAforoRes);
            textViewTipoRes = (TextView) itemView.findViewById(R.id.textViewTipoRes);
            textViewContactoRes = (TextView) itemView.findViewById(R.id.textViewContactoRes);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);
        }
    }
}
