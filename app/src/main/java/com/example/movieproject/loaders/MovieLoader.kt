package com.example.movieproject.loaders

import com.example.movieproject.MovieLoadListener
import com.example.movieproject.api.MovieService
import com.example.movieproject.api.models.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieLoader(val listener: MovieLoadListener) : Callback<Result> {

    fun loadPopularMovies() {
        MovieService.movieApi.getPopularMovies().enqueue(this)
    }

    fun loadTopRatedMovies() {
        MovieService.movieApi.getTopRatedMovies().enqueue(this)
    }

    override fun onFailure(call: Call<Result>, t: Throwable) {
        listener.onMoviesLoadError(t)
    }

    override fun onResponse(call: Call<Result>, response: Response<Result>) {
        listener.onMoviesLoaded(response.body()?.results!!)
    }

}