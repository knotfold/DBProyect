package com.cool2bgoodgav.warcr.dbproyect;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab2Res extends Fragment {



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
  /* private static final String URL_DATA ="http://10.0.2.2:81/dbproject/get_res.php";*/
  private static final String URL_DATA="https://knotfoldbase.000webhostapp.com/get_res.php";
    public List<ListItemRes> listItems;

    public LinearLayout linearLayout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listItems = new ArrayList<>();
       loadRecyclerViewData();








    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.tab2res, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleViewRes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        return rootView;

    }





    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public void loadRecyclerViewData()
    {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("result");

                            for(int i = 0; i<array.length();i++)
                            {
                                JSONObject o = array.getJSONObject(i);
                                ListItemRes item = new ListItemRes(
                                        o.getString("IdRestaurante"),
                                        o.getString("NombreRes"),
                                        o.getString("UbicacionRes"),
                                        o.getString("HorarioRes"),
                                        o.getString("AforoRes"),
                                        o.getString("TipoRes"),
                                        o.getString("ContactoRes"),
                                        o.getString("image")

                                );
                                listItems.add(item);
                            }
                            adapter = new MyAdapter(listItems,getActivity());
                            recyclerView.setAdapter(adapter);

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

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }

}

