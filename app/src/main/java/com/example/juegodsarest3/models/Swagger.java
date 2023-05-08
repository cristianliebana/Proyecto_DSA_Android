package com.example.juegodsarest3.models;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.*;

public interface Swagger {

    String URL = "http://10.0.2.2:8080/dsaApp/";

    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @POST("game/login")
    Call<Usuario> Login(@Body CredencialTO ul);

    @POST("game/registrarUsuario")
    Call<Usuario> Register(@Body Usuario ur);

    @GET("game/addObjeto")
    Call<List<Objeto>> Objetos();

    @GET("game/listaObjetos")
    Call<List<Objeto>> getlistaObjetos();

}