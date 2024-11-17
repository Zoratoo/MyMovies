package com.example.alonavigationdrawer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalhesFragment extends Fragment {

    private static final String ARG_FILME = "filme";

    private Filme filme;

    public DetalhesFragment() {
        // Required empty public constructor
    }

    public static DetalhesFragment newInstance(Filme filme) {
        DetalhesFragment fragment = new DetalhesFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_FILME, filme); // Filme deve implementar Serializable
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            filme = (Filme) getArguments().getSerializable(ARG_FILME);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalhes, container, false);

        // Vincular os elementos de UI
        ImageView posterImageView = view.findViewById(R.id.posterImageView);
        TextView tituloFilme = view.findViewById(R.id.tituloFilme);
        TextView anoFilme = view.findViewById(R.id.anoFilme);
        TextView genresFilme = view.findViewById(R.id.genresFilme);
        TextView castFilme = view.findViewById(R.id.castFilme);
        TextView descricaoFilme = view.findViewById(R.id.descricaoFilme);
        TextView hrefFilme = view.findViewById(R.id.hrefFilme);

        if (filme != null) {
            // Carregar o pôster do filme
            Picasso.get().load(filme.getThumbnail()).into(posterImageView);

            // Definir os detalhes do filme
            tituloFilme.setText(filme.getTitle());
            anoFilme.setText("Ano: " + filme.getYear());
            genresFilme.setText("Gêneros: " + String.join(", ", filme.getGenres()));
            castFilme.setText("Elenco: " + String.join(", ", filme.getCast()));
            descricaoFilme.setText(filme.getExtract());
            hrefFilme.setText("Saiba mais");

            // Abrir link ao clicar em "Saiba mais"
            hrefFilme.setOnClickListener(v -> {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(filme.getHref()));
                startActivity(browserIntent);
            });
        }

        return view;
    }
}
