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

public class AddAdmin extends AppCompatActivity {

    EditText editTextNombreAdmin;
    EditText editTextContrasenaAmin;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);

        Intent intent = getIntent();



        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editTextNombreAdmin = (EditText) findViewById(R.id.editTextNombreAdmin);
        editTextContrasenaAmin = (EditText) findViewById(R.id.editTextContrasenaAdmin);

        //Setting listeners to button

    }



    //Adding an employee
    public void addAdmin(View view){

        final String NombreAdmin = editTextNombreAdmin.getText().toString().trim();
        final String ContrasenaAdmin = editTextContrasenaAmin.getText().toString().trim();


        class AddAmin extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(AddAdmin.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(AddAdmin.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NombreAdmin,NombreAdmin);
                params.put(Config.KEY_EMP_ContrasenaAdmin,ContrasenaAdmin);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD_ADMIN, params);
                return res;
            }
        }

        AddAmin ae = new AddAmin();
        ae.execute();

    }

}
