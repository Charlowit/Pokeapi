package com.cescristorey.pokeapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;



public class MainAdapter extends RecyclerView.Adapter<MainAdapter.PokemonViewHolder> {
    private List<Result> result;

    public MainAdapter(List<Result> result){
        this.result = result;
    }
    @NonNull
    @Override
    public MainAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*Crea la vista de un item y la "pinta"*/
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_pokemon, parent, false);
        /* Crea un objeto de la clase PokemonViewHolder, pasándole la vista anteriormente creada*/
        PokemonViewHolder pokemonVH = new PokemonViewHolder(itemView);
        /* devuelve el viewHolder */
        return pokemonVH;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.PokemonViewHolder holder, int position) {
        Result resultado = result.get(position);
        holder.bindHolder(resultado);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        private TextView tvname;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tv_name);
        }

        public void bindHolder (Result result) {
            tvname.setText(result.getName());
        }
    }
}