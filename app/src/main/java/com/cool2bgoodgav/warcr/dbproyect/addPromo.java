package com.cool2bgoodgav.warcr.dbproyect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class addPromo extends AppCompatActivity {

    EditText editTextURLPromo;
    EditText editTextIdRes;

    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promo);

        Intent intent = getIntent();



        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editTextURLPromo = (EditText) findViewById(R.id.editTextURLPromo);
        editTextIdRes = (EditText) findViewById(R.id.editTextRestauranteID);



        //Setting listeners to button

    }



    //Adding an employee
    public void addProm(View view){

        final String UrlPromo = editTextURLPromo.getText().toString().trim();
        final String IdRestaurante = editTextIdRes.getText().toString().trim();



        class AddProm extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(addPromo.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(addPromo.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_URLPromo, UrlPromo);
                params.put(Config.KEY_EMP_Restaurante_IdRestaurante,IdRestaurante);






                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD_PROM_WEB, params);
                return res;
            }
        }

        AddProm ae = new AddProm();
        ae.execute();

    }
}
