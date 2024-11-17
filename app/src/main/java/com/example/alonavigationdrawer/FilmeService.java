package com.example.alonavigationdrawer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FilmeService {
    @GET("search")
    Call<List<Filme>> buscarFilmesTitle(@Query("title") String title);

    @GET("all")
    Call<List<Filme>> buscarFilmes();
}
