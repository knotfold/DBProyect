package com.cool2bgoodgav.warcr.dbproyect;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Login_screen extends AppCompatActivity {

    EditText editTextUser;
    EditText editTextPass;
    Button buttonLogin;
    Button buttonRegister;
    ImageView LoginBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        editTextPass = (EditText) findViewById(R.id.autoTextPass);
        editTextUser = (EditText) findViewById(R.id.autoTextUser);
        buttonLogin = (Button)  findViewById(R.id.buttonLogin);
        LoginBack = (ImageView) findViewById(R.id.LoginBack);




    }
    String NameCliente;
    String ContrasenaCliiente;

    public void Login(View view)
    {
         NameCliente = editTextUser.getText().toString();
         ContrasenaCliiente = editTextPass.getText().toString();
        loginCredentials();


    }

    public void Register(View view)
    {
        startActivity(new Intent(this,addCliente.class));

    }

    public boolean result = false;

    public void loginCredentials(){

        final String NombreClientee = editTextUser.getText().toString().trim();


        class GetUserCredentials extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Login_screen.this,"Fetching...","Wait...",false,false);
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                resultLogin(s,NameCliente,ContrasenaCliiente);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_LOGIN_USER_RESULT_WEB,NombreClientee);
                return s;
            }
        }
        GetUserCredentials ge = new GetUserCredentials();
        ge.execute();

    }

    public String r;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void resultLogin(String json, String NC, String CC){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY_LOGIN_USER);
            JSONObject c = result.getJSONObject(0);
            String IdCliente = c.getString(Config.TAG_ID_CLIENTE);
            String NombreCliente = c.getString(Config.TAG_NOMBRE_CLIENTE);

            String ContrasenaCliente = c.getString(Config.TAG_CONTRASENA_CLIENTE);



            if(Objects.equals(NombreCliente, NC) && Objects.equals(ContrasenaCliente, CC))
            {
                Intent intent = new Intent(this,TrueMain.class);

                intent.putExtra(Config.EMP_IDC,IdCliente);
                startActivity(intent);
            }
            else
            {
                Toast("Los datos ingresados no coinciden");
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Toast(String toastText)
    {
        Context context = getApplicationContext();
        CharSequence text = toastText;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
