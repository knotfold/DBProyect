package com.cool2bgoodgav.warcr.dbproyect;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResDetails extends AppCompatActivity  {

    public TextView textViewNombreRes;
    public TextView textViewUbicacionRes;
    public TextView textViewHorarioRes;
    public TextView textViewAforoRes;
    public TextView textViewTipoRes;
    public TextView textViewContactoRes;
    public ImageView imageViewRes;
    public Context context;
    public Button buttonAddComment;
    public EditText editTextAddComment;

    String IdRestaurante;
    String IdCliente;

    private RecyclerView recyclerViewPlatillos;
    private RecyclerView.Adapter adapter;

    private RecyclerView recyclerViewComments;
    private RecyclerView.Adapter adapterComments;

    private RecyclerView recyclerViewCommentsUser;
    private RecyclerView.Adapter adapterCommentsUser;


    /*private static final String URL_DATA="https://knotfoldbase.000webhostapp.com/get_res.php";*/
    public List<ListItemPlatillos> listItems;
    public List<ListItemComments> listItemsComments;
    public List<ListItemCommentsUser> listItemCommentsUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_details);
        recyclerViewPlatillos = (RecyclerView) findViewById(R.id.recycleViewPlatillos);
        recyclerViewPlatillos.setHasFixedSize(true);
        recyclerViewPlatillos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        recyclerViewComments = (RecyclerView) findViewById(R.id.recycleViewComents);
        recyclerViewComments.setHasFixedSize(true);
        recyclerViewComments.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewCommentsUser = (RecyclerView) findViewById(R.id.recycleViewComentsUser);
        recyclerViewCommentsUser.setHasFixedSize(true);
        recyclerViewCommentsUser.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        IdRestaurante = extras.getString("EXTRA_IdRestaurante");
        String NombreRes = extras.getString("EXTRA_NombreRes");
        String UbicacionRes = extras.getString("EXTRA_UbicacionRes");
        String HorarioRes = extras.getString("EXTRA_HorarioRes");
        String AforoRes = extras.getString("EXTRA_AforoRes");
        String TipoRes = extras.getString("EXTRA_TipoRes");
        String ContactoRes = extras.getString("EXTRA_ContactoRes");
        String ImageUrl = extras.getString("EXTRA_ImageUrl");
        IdCliente = extras.getString("EXTRA_Id_Cliente");


        textViewNombreRes = (TextView) findViewById(R.id.textViewNombreRes);
        textViewUbicacionRes = (TextView) findViewById(R.id.textViewUbicacionRes);
        textViewHorarioRes = (TextView) findViewById(R.id.textViewHorarioRes);
        textViewAforoRes = (TextView) findViewById(R.id.textViewAforoRes);
        textViewTipoRes = (TextView) findViewById(R.id.textViewTipoRes);
        textViewContactoRes = (TextView) findViewById(R.id.textViewContactoRes);
        imageViewRes = (ImageView) findViewById(R.id.imageViewRes);
        buttonAddComment = (Button) findViewById(R.id.buttonAddComment);
        editTextAddComment = (EditText) findViewById(R.id.editTextAddComment);

        textViewNombreRes.setText(NombreRes);
        textViewUbicacionRes.setText(UbicacionRes);
        textViewHorarioRes.setText(HorarioRes);
        textViewAforoRes.setText(AforoRes);
        textViewTipoRes.setText(TipoRes);
        textViewContactoRes.setText(ContactoRes);
        Picasso.with(context).load(ImageUrl).into(imageViewRes);

        listItems = new ArrayList<>();
        listItemsComments = new ArrayList<>();
        listItemCommentsUser = new ArrayList<>();

        loadRecyclerViewDataPlatillos();
        loadRecyclerViewDataComments();
        loadRecyclerViewDataCommentsUser();


    }


    public void loadRecyclerViewDataPlatillos() {

        /*URL_DATA = "http://10.0.2.2:81/dbproject/get_platillos.php?IdRestaurante=" + IdRestaurante;*/
        final String URL_DATA = "https://knotfoldbase.000webhostapp.com/get_platillos.php?IdRestaurante=" + IdRestaurante;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("result");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                ListItemPlatillos item = new ListItemPlatillos(
                                        o.getString("NombrePlatillo"),
                                        o.getString("CostoPlatillo"),
                                        o.getString("TipoPlatillo"),
                                        o.getString("DescripcionPlatillo")


                                );
                                listItems.add(item);
                            }
                            adapter = new MyAdapterPlatillos(listItems, getApplicationContext());
                            recyclerViewPlatillos.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void loadRecyclerViewDataComments() {

        /*URL_DATA = "http://10.0.2.2:81/dbproject/get_platillos.php?IdRestaurante=" + IdRestaurante;*/
        final String URL_DATA = "https://knotfoldbase.000webhostapp.com/get_comments.php?IdRestaurante=" + IdRestaurante + "&IdCliente=" + IdCliente;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("result");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                ListItemComments item = new ListItemComments(
                                        o.getString("ComentarioRes"),
                                        o.getString("NombreCliente")


                                );
                                listItemsComments.add(item);
                            }
                            adapterComments = new MyAdapterComments(listItemsComments, getApplicationContext());
                            recyclerViewComments.setAdapter(adapterComments);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    public void addCommentUser(View view) {
        final String IdRest = IdRestaurante.trim();
        final String IdC = IdCliente.trim();
        final String ComentarioRes = editTextAddComment.getText().toString().trim();


        class AddComment extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ResDetails.this, "Adding...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ResDetails.this, s, Toast.LENGTH_LONG).show();
                loadRecyclerViewDataCommentsUser();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_EMP_IdCliente_Coment, IdC);
                params.put(Config.KEY_EMP_IdRestaurante, IdRest);
                params.put(Config.KEY_EMP_ComentarioRes, ComentarioRes);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD_COMMENT_WEB, params);
                return res;
            }
        }

        AddComment ae = new AddComment();
        ae.execute();

    }


    public void loadRecyclerViewDataCommentsUser() {

        /*URL_DATA = "http://10.0.2.2:81/dbproject/get_platillos.php?IdRestaurante=" + IdRestaurante;*/
        final String URL_DATA = "https://knotfoldbase.000webhostapp.com/get_comments_user.php?IdRestaurante=" + IdRestaurante + "&IdCliente=" + IdCliente;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("result");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                ListItemCommentsUser item = new ListItemCommentsUser(
                                        o.getString("IdComentario"),
                                        o.getString("ComentarioRes"),
                                        o.getString("NombreCliente")


                                );
                                listItemCommentsUser.add(item);
                            }
                            adapterCommentsUser = new MyAdapterCommentsUser(listItemCommentsUser, getApplicationContext()
                            );
                            recyclerViewCommentsUser.setAdapter(adapterCommentsUser);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}


