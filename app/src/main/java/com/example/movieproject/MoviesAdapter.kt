package com.example.movieproject

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movieproject.api.models.Movie
import kotlinx.android.synthetic.main.layout_item_movie.view.*

class MoviesAdapter(private val movies: ArrayList<Movie> = ArrayList())
    : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private lateinit var movieClickListener: MovieClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_item_movie, parent, false))

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindQuote(movies[position])
    }

    fun setMovies(data: List<Movie>) {
        //movies.clear()
        movies.addAll(data)

        notifyDataSetChanged()
    }

    fun setListener(listener: MovieClickListener) {
        movieClickListener = listener
    }

    inner class MovieViewHolder(val root: View) : RecyclerView.ViewHolder(root) {

        fun bindQuote(movie: Movie) {
            with(root) {
                title_view.text = movie.title

                setOnClickListener {
                    movieClickListener.onMovieClicked(movie)
                }
            }
        }

    }
}