package com.example.alonavigationdrawer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8080/api/movies/").
                addConverterFactory(GsonConverterFactory.create()).build();
    }

    public FilmeService getFilmes() {
        return this.retrofit.create(FilmeService.class);
    }
}

