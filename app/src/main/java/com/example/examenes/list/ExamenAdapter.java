package com.example.examenes.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenes.R;

import java.util.List;

public class ExamenAdapter extends RecyclerView.Adapter<ExamenViewHolder>{
    List<Examen> examenes;
    OnItemClickListener onItemClickListener;
    public ExamenAdapter(List<Examen> examenes, OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
        this.examenes = examenes;
    }
    @NonNull
    @Override
    public ExamenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater
               .from(parent.getContext())
               .inflate(R.layout.item_examen, parent, false);
       return new ExamenViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamenViewHolder holder, int position) {
        holder.txtMateria.setText(examenes.get(position).materia);
        holder.txtFecha.setText(examenes.get(position).fecha);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(examenes.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return examenes.size();
    }
    public interface OnItemClickListener{
        void onItemClick(Examen examen);
    }
}


