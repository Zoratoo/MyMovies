package com.example.alonavigationdrawer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView listView;
    private TextInputEditText tiPesquisar;
    private Button btPesquisar;

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void atualizarListView(List<Filme> filmes) {
        FilmesAdapter adapter = new FilmesAdapter(getContext(), filmes);
        listView.setAdapter(adapter);

        // Configurar o clique no item para exibir detalhes
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Filme filmeSelecionado = filmes.get(position);
                abrirDetalhes(filmeSelecionado);
            }
        });
    }

    private void buscarFilmes() {
        Call<List<Filme>> call = new RetrofitConfig().getFilmes().buscarFilmes();
        call.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    atualizarListView(response.body());
                } else {
                    Toast.makeText(getContext(), "Nenhum resultado encontrado!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Toast.makeText(getContext(), "Erro ao buscar filmes!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void buscarFilmesByTitle(String title) {
        Call<List<Filme>> call = new RetrofitConfig().getFilmes().buscarFilmesTitle(title);
        call.enqueue(new Callback<List<Filme>>() {
            @Override
            public void onResponse(Call<List<Filme>> call, Response<List<Filme>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    atualizarListView(response.body());
                } else {
                    Toast.makeText(getContext(), "Nenhum resultado encontrado!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Filme>> call, Throwable t) {
                Toast.makeText(getContext(), "Erro ao buscar filmes!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        listView = view.findViewById(R.id.listView);
        tiPesquisar = view.findViewById(R.id.tiPesquisar);
        btPesquisar = view.findViewById(R.id.btPesquisar);
        buscarFilmes();
        btPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = tiPesquisar.getText().toString();
                if (!query.isEmpty()) {
                    buscarFilmesByTitle(query);
                }
            }
        });

        return view;
    }

    public void abrirDetalhes(Filme filme) {
        DetalhesFragment detalhesFragment = DetalhesFragment.newInstance(filme);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, detalhesFragment) // Certifique-se de usar o ID correto
                .addToBackStack(null)
                .commit();
    }
}