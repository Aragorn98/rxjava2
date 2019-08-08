package com.example.movieproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieService {

    val ENDPOINT = "https://api.themoviedb.org/3/"

    val retrofit = Retrofit.Builder()
        .baseUrl(ENDPOINT)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieApi = retrofit.create(MovieApi::class.java)
}