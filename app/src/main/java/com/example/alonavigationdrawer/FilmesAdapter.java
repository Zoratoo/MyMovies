package com.example.alonavigationdrawer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class FilmesAdapter extends ArrayAdapter<Filme> {
    public FilmesAdapter(Context context, List<Filme> filmes) {
        super(context, 0, filmes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        Filme filme = getItem(position);
        TextView titulo = convertView.findViewById(R.id.tituloFilme);

        titulo.setText(filme.getTitle());

        return convertView;
    }
}
