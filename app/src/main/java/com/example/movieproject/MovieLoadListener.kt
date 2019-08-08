package com.example.movieproject

import com.example.movieproject.api.models.Movie

interface MovieLoadListener {

    fun onMoviesLoaded(movies: List<Movie>)
    fun onMoviesLoadError(throwable: Throwable)
}