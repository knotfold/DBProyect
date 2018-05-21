package com.cool2bgoodgav.warcr.dbproyect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class AddRestaurante extends AppCompatActivity {

    EditText editTextNombreRes;
    EditText editTextUbicacionRes;
    EditText editTextHorarioRes;
    EditText editTextAforoRes;
    EditText editTextTipoRes;
    EditText editTextContactoRes;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurante);

        Intent intent = getIntent();



        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editTextNombreRes = (EditText) findViewById(R.id.editTextNombreRes);
        editTextUbicacionRes = (EditText) findViewById(R.id.editTextUbicacionRes);
        editTextHorarioRes = (EditText) findViewById(R.id.editTextHorarioRes);
        editTextAforoRes = (EditText) findViewById(R.id.editTextAforoRes);
        editTextTipoRes = (EditText) findViewById(R.id.editTextTipoRes);
        editTextContactoRes = (EditText) findViewById(R.id.editTextContactoRes);

        //Setting listeners to button

    }



    //Adding an employee
    public void addRes(View view){

        final String NombreRes = editTextNombreRes.getText().toString().trim();
        final String UbicacionRes = editTextUbicacionRes.getText().toString().trim();
        final String HorarioRes = editTextHorarioRes.getText().toString().trim();
        final String AforoRes = editTextAforoRes.getText().toString().trim();
        final String TipoRes = editTextTipoRes.getText().toString().trim();
        final String ContactoRes = editTextContactoRes.getText().toString().trim();


        class AddRes extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(AddRestaurante.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(AddRestaurante.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NombreRes,NombreRes);
                params.put(Config.KEY_EMP_UbicacionRes,UbicacionRes);
                params.put(Config.KEY_EMP_HorarioRes,HorarioRes);
                params.put(Config.KEY_EMP_AforoRes,AforoRes);
                params.put(Config.KEY_EMP_TipoRes,TipoRes);
                params.put(Config.KEY_EMP_ContactoRes,ContactoRes);



                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD_RES_WEB, params);
                return res;
            }
        }

        AddRes ae = new AddRes();
        ae.execute();

    }
}
