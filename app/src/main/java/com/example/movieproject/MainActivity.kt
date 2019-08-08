package com.example.movieproject

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.movieproject.api.models.Movie
import com.example.movieproject.loaders.MovieLoader
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieLoadListener, MovieClickListener {

    private val loader by lazy { MovieLoader(this) }
    private val moviesAdapter by lazy { MoviesAdapter() }
    private val firebaseAuth by lazy { FirebaseAuth.getInstance() }


    companion object {
        fun start(context: Context) {
            context.startActivity(
                Intent(context,
                    MainActivity::class.java)
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = firebaseAuth.currentUser

        if (user == null) {
            LoginActivity.start(this)
            finish()
        }

        initUI()
        loader.loadTopRatedMovies()
        loader.loadPopularMovies()

    }

    private fun initUI() {
        moviesAdapter.setListener(this)

        with(movies_list) {
            layoutManager = LinearLayoutManager(context)
            adapter = moviesAdapter
        }
    }

    override fun onMoviesLoaded(movies: List<Movie>) {
        moviesAdapter.setMovies(movies)
    }

    override fun onMoviesLoadError(throwable: Throwable) {
        Toast.makeText(this, throwable.message,
            Toast.LENGTH_LONG).show()
    }

    override fun onMovieClicked(movie: Movie) {
        Toast.makeText(this, movie.toString(), Toast.LENGTH_LONG).show()
    }
}
