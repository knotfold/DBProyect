package com.cool2bgoodgav.warcr.dbproyect;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/**
 * Created by warcr on 05/12/2017.
 */

public class MyAdapterCommentsUser extends RecyclerView.Adapter<MyAdapterCommentsUser.ViewHolder> {

    private List<ListItemCommentsUser> listItems;

    private Context context;

    public MyAdapterCommentsUser(List<ListItemCommentsUser> listItems, Context context) {

        this.listItems = listItems;
        this.context = context;

    }

    @Override
    public MyAdapterCommentsUser.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v ;
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv_comments_user,parent,false));

    }

    @Override
    public void onBindViewHolder(final MyAdapterCommentsUser.ViewHolder holder, int position) {
        final ListItemCommentsUser listItem = listItems.get(position);
        holder.textViewIdComentario.setText(listItem.getIdComentario());
        holder.editTextComentarioRes.setText(listItem.getComentarioRes());
        holder.textViewNombreCliente.setText(listItem.getNombreCliente());
        holder.editTextComentarioRes.setEnabled(false);
        final String[] comment = new String[1];
        final String[] idComment = new String[1];
        final boolean[] buttons = {false};

        holder.linearLayoutCommentUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                comment[0] = listItem.getComentarioRes();
                idComment[0] = listItem.getIdComentario();
            }


        });

        holder.buttonEdit.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                if(buttons[0] == false)
                {   buttons[0] = true;
                    holder.editTextComentarioRes.setEnabled(true);
                    holder.buttonEdit.setText("Aceptar");
                    holder.buttonDelete.setText("Cancelar");
                }
                else
                {
                    buttons[0] = false;
                    updateComment(holder.editTextComentarioRes,holder.textViewIdComentario);
                    if(context instanceof ResDetails)
                    {
                        ((ResDetails)context).loadRecyclerViewDataCommentsUser();
                    }
                    holder.editTextComentarioRes.setEnabled(false);
                    holder.buttonEdit.setText("Editar");
                    holder.buttonDelete.setText("Eliminar");


                }



            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.editTextComentarioRes.isEnabled())
                {
                    holder.editTextComentarioRes.setEnabled(false);
                    holder.buttonEdit.setText("Editar");
                    holder.buttonDelete.setText("Eliminar");
                }
                else
                {

                }
            }
        });


    }

    private void updateComment(EditText editText,TextView textView){
        final String IdCometario = textView.getText().toString().trim();
        final String Comentario =  editText.getText().toString().trim();


        class UpdateEmployee extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);


            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Config.KEY_EMP_IdComentario,IdCometario);
                hashMap.put(Config.KEY_EMP_ComentarioRes,Comentario);


                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(Config.URL_UPDATE_USER_COMMENT,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }



    @Override
    public int getItemCount() {
        return listItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewIdComentario;
        public EditText editTextComentarioRes;
        public TextView textViewNombreCliente;
        public LinearLayout linearLayoutCommentUser;
        public WeakReference<ClickListener> listenerRef;
        public Button buttonEdit;
        public Button buttonDelete;

        public ViewHolder(View itemView) {
            super(itemView);


            textViewIdComentario = (TextView) itemView.findViewById(R.id.textViewIdComentario);
            editTextComentarioRes = (EditText) itemView.findViewById(R.id.EditTextComntarioRes);
            textViewNombreCliente = (TextView) itemView.findViewById(R.id.textViewNombreCliente);
            linearLayoutCommentUser = (LinearLayout) itemView.findViewById(R.id.linearLayoutCommentUser);
            buttonEdit = (Button) itemView.findViewById(R.id.buttonEdit);
            buttonDelete = (Button) itemView.findViewById(R.id.buttonDelete);





        }


    }


}
