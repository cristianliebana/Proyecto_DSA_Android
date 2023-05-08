package com.example.juegodsarest3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.juegodsarest3.R;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        configureTiendaButton();
    }

    private void configureTiendaButton(){
        Button tienda_button = (Button) findViewById(R.id.tienda);
        tienda_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuPrincipal.this, tiendaActivity.class));
            }
        });
    }
}