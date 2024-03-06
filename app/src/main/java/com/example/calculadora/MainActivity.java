package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();
        tbh.addTab(tbh.newTabSpec("Inicio").setIndicator("Inicio", null).setContent(R.id.Inicio));
        tbh.addTab(tbh.newTabSpec("Gestion").setIndicator("Gestion", null).setContent(R.id.Gestion));
    }
}