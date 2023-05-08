package com.example.juegodsarest3.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.juegodsarest3.models.Swagger;
import com.example.juegodsarest3.models.CredencialTO;
import com.example.juegodsarest3.models.Usuario;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import com.example.juegodsarest3.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        configureLoginButton();
    }

    private void configureLoginButton(){
        Button BotonLogin = (Button) findViewById(R.id.entrarBtn);
        EditText correo = (EditText) findViewById(R.id.mailAdd);
        EditText password = (EditText) findViewById(R.id.passwordAdd);

        BotonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Swagger swagger = Swagger.retrofit.create(Swagger.class);

                CredencialTO ul = new CredencialTO(correo.getText().toString(),password.getText().toString());
                Call<Usuario> call = swagger.Login(ul);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Log.d("ERRORCRISTIAN",call.toString());
                        Log.d("ERRORCRISTIAN",response.toString());
                        if (response.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this, MenuPrincipal.class));
                        }
                        else {
                            Snackbar mySnackbar = Snackbar.make(view, "Correo o Password incorrectos", BaseTransientBottomBar.LENGTH_SHORT);
                            mySnackbar.show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Snackbar mySnackbar = Snackbar.make(view, "No se ha podido establecer conexión", BaseTransientBottomBar.LENGTH_SHORT);
                        Log.d("ERRORCRISTIAN",t.toString());
                        mySnackbar.show();
                    }
                });
            }
        });
    }
}