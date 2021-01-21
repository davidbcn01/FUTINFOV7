package com.example.futinfov2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futinfov2.databinding.FragmentJugadoresValiososBinding;
import com.example.futinfov2.databinding.ViewholderJugadorBinding;

import java.util.List;


public class JugadoresValiososFragment extends Fragment {



    private FragmentJugadoresValiososBinding binding;
    private JugadoresViewModel jugadoresViewModel;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentJugadoresValiososBinding.inflate(inflater, container, false)).getRoot();
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         jugadoresViewModel = new ViewModelProvider(this).get(JugadoresViewModel.class);


        JugadoresAdapter jugadoresAdapter = new JugadoresAdapter();
        binding.recyclerView.setAdapter(jugadoresAdapter);

        jugadoresViewModel.obtener().observe(getViewLifecycleOwner(), new Observer<List<Jugador>>() {
            @Override
            public void onChanged(List<Jugador> jugadores) {
                jugadoresAdapter.establecerLista(jugadores);
            }
        });




    }

    static class JugadorViewHolder extends RecyclerView.ViewHolder{
        private final ViewholderJugadorBinding binding;
        public JugadorViewHolder(ViewholderJugadorBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    class JugadoresAdapter extends RecyclerView.Adapter<JugadorViewHolder> {

        List<Jugador> jugadores;

        @NonNull
        @Override
        public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new JugadorViewHolder(ViewholderJugadorBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {

            Jugador jugador = jugadores.get(position);

            holder.binding.nombre.setText(jugador.nombre);
            holder.binding.media.setText(String.valueOf(jugador.media));
            holder.binding.posicion.setText(jugador.posicion);
            Glide.with(holder.itemView).load(jugador.pais).into(holder.binding.pais);
            Glide.with(holder.itemView).load(jugador.tipo).into(holder.binding.fondo);
            Glide.with(holder.itemView).load(jugador.cara).into(holder.binding.cara);
            Glide.with(holder.itemView).load(jugador.equipo).into(holder.binding.equipo);
            // holder.binding.pais.set(jugador.pais);
            // holder.binding.equipo.set(jugador.equipo);
            // holder.binding.cara.set(jugador.cara);
            //holder.binding.fondo.set(jugador.tipo);

        }

        @Override
        public int getItemCount() {
            return jugadores != null ? jugadores.size() : 0;
        }

        public void establecerLista(List<Jugador> jugadores){
            this.jugadores = jugadores;
            notifyDataSetChanged();
        }
    }
}


