package com.example.juegodsarest3.activities;

import java.util.ArrayList;
import java.util.List;

//import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.juegodsarest3.R;
import com.example.juegodsarest3.models.Objeto;
import com.squareup.picasso.Picasso;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<Objeto> values;


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public TextView txtFooter2;

        public ImageView icon;
        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            txtFooter2 = (TextView) v.findViewById(R.id.thirdLine);
            icon = (ImageView) v.findViewById(R.id.icon);

        }
    }

    public void setData(List<Objeto> myDataset) {
        values = myDataset;
        notifyDataSetChanged();
    }

    public void add(int position, Objeto item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    public Adaptador(){values = new ArrayList<>();}

    public Adaptador(List<Objeto> myDataset) {
        values = myDataset;
    }


    @Override
    public Adaptador.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.activity_row_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Objeto o = values.get(position);
        final String name = o.getNombre();
        holder.txtHeader.setText(name);

        holder.txtHeader.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                remove (holder.getAdapterPosition());
            }
        });

        holder.txtFooter.setText(o.getDescripcion());
        holder.txtFooter2.setText(String.valueOf(o.getPrecio()));

        Picasso.get().load(o.getFotoImagen()).into(holder.icon);

    }


    @Override
    public int getItemCount() {
        return values.size();
    }


}