package com.example.movieproject

import com.example.movieproject.api.models.Movie

interface MovieClickListener {

    fun onMovieClicked(movie: Movie)
}