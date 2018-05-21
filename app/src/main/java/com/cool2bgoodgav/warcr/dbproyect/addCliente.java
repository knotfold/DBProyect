package com.cool2bgoodgav.warcr.dbproyect;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class addCliente extends AppCompatActivity {

    EditText editTextNombreCliente;
    EditText editTextContrasenaCliente;
    EditText editTextContrasenaConfirmar;
    Button buttonAdd;
    CheckBox checkBoxTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cliente);

        Intent intent = getIntent();



        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editTextNombreCliente = (EditText) findViewById(R.id.editTextNombreCliente);
        editTextContrasenaCliente = (EditText) findViewById(R.id.editTextContrasenaCliente);
        editTextContrasenaConfirmar = (EditText) findViewById(R.id.editTextContrasenaComprobar);
        checkBoxTerms = (CheckBox) findViewById(R.id.checkboxTerms);



    }

    public void confirmarCliente(View view)
    {
        String contrasena1 = editTextContrasenaCliente.getText().toString();
        String contrasena2 = editTextContrasenaConfirmar.getText().toString();
        String IdCliente = editTextNombreCliente.getText().toString();
        if(contrasena1.equals(contrasena2))
        {
           if(rbcheck)
           {
               addCliente();
               Intent intent = new Intent(this,TrueMain.class);

               intent.putExtra(Config.EMP_IDC,IdCliente);
               startActivity(intent);
           }
           else
           {
               Context context = getApplicationContext();
               CharSequence text = "No se han aceptado los terminos y condiciones";
               int duration = Toast.LENGTH_SHORT;
               Toast toast = Toast.makeText(context, text, duration);
               toast.show();
           }

        }
        else
        {
            Context context = getApplicationContext();
            CharSequence text = "Las contraseñas no coinciden, intete de nuevo";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    //Adding an employee
    public void addCliente(){

        final String NombreCliente = editTextNombreCliente.getText().toString().trim();
        final String ContrasenaCliente = editTextContrasenaCliente.getText().toString().trim();


        class AddCliente extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(addCliente.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(addCliente.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NombreCliente,NombreCliente);
                params.put(Config.KEY_EMP_ContrasenaCliente,ContrasenaCliente);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD_CLIENTE_WEB, params);
                return res;
            }
        }

        AddCliente ae = new AddCliente();
        ae.execute();

    }
    boolean rbcheck = false;

    public void rbclick(View view)
    {
        if(rbcheck==false)
        {
            rbcheck = true;
        }
        else
        {
            
            rbcheck = false;
        }

    }

}
