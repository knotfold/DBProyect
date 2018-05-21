package com.cool2bgoodgav.warcr.dbproyect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonAA;
    Button buttonAU;
    Button buttonAR;
    Button buttonAP;
    Button buttonAC;
    Button buttonTA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void addAdmin(View view)
    {
        startActivity(new Intent(this,AddAdmin.class));
    }

    public void addCliente(View view)
    {
        startActivity(new Intent(this,addCliente.class));
    }

    public void addRes(View view)
    {
        startActivity(new Intent(this,AddRestaurante.class));
    }

    public void addProm(View view)
    {
        startActivity(new Intent(this,addPromo.class));
    }

    public void addComment(View view)
    {
        startActivity(new Intent(this,addComent.class));
    }
    public void testApp(View view)
    {
        startActivity(new Intent(this,Login_screen.class));
    }
}
