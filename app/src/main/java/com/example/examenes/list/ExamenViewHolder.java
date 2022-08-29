package com.example.examenes.list;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenes.R;

public class ExamenViewHolder extends RecyclerView.ViewHolder {
    TextView txtMateria;
    TextView txtFecha;
    ExamenViewHolder(@NonNull View itemView){
        super(itemView);
        txtMateria = itemView.findViewById(R.id.txtMateria);
        txtFecha = itemView.findViewById(R.id.txtFecha);
    }
}
