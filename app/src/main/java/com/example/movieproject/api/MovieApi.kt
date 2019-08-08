package com.example.movieproject.api

import com.example.movieproject.api.models.Result
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    @GET("movie/popular?api_key=71eb7fc9baa53fdc5920a373c657c65e&language=en-US&page=1")
    fun getPopularMovies(): Call<Result>

    @GET("movie/top_rated?api_key=71eb7fc9baa53fdc5920a373c657c65e&language=en-US&page=1")
    fun getTopRatedMovies(): Call<Result>
}