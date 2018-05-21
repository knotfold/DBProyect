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

public class addComent extends AppCompatActivity {

    EditText editTextComment;
    Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_coment);

        Intent intent = getIntent();


        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editTextComment = (EditText) findViewById(R.id.editTextComment);


        //Setting listeners to button

    }


    //Adding an employee
    public void addComment(View view) {

        final String ComentarioRes = editTextComment.getText().toString().trim();


        class AddComment extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(addComent.this, "Adding...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(addComent.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_EMP_ComentarioRes, ComentarioRes);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD_COMMENT, params);
                return res;
            }
        }

        AddComment ae = new AddComment();
        ae.execute();

    }
}
