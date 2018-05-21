package com.cool2bgoodgav.warcr.dbproyect;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainScreen extends AppCompatActivity {

    private RecyclerView recyclerViewRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container) {
        View layout = inflater.inflate(R.layout.activity_main_screen,container,false);
        return layout;

    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }
}
