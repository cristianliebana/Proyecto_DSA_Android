package com.example.juegodsarest3.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.juegodsarest3.models.Objeto;
import com.example.juegodsarest3.models.Swagger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.juegodsarest3.R;

public class tiendaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adaptador adapter;
    private RecyclerView.LayoutManager layoutManager;


    private final String TAG = InicialActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda);

        recyclerView = (RecyclerView) findViewById(R.id.my_new_recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adaptador();
        recyclerView.setAdapter(adapter);

        doApiCall();


        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        adapter.remove(viewHolder.getAdapterPosition());
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
    private void doApiCall() {
        Swagger swagger = Swagger.retrofit.create(Swagger.class);
        Call<List<Objeto>> call = swagger.getlistaObjetos();

        call.enqueue(new Callback<List<Objeto>>() {
            @Override
            public void onResponse(Call<List<Objeto>> call, Response<List<Objeto>> response) {

                adapter.setData(response.body());


            }
            @Override
            public void onFailure(Call<List<Objeto>> call, Throwable t) {


                String msg = "Error con el retrofit: "+t.toString();
                Log.d(TAG,msg);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
            }
        });
    }
}