package com.example.listfilm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listfilm.model.Movie
import com.example.listfilm.repository.MovieRepository
import com.example.listfilm.util.Constants
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import timber.log.Timber

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    val movies: StateFlow<List<Movie>> = repository.getPopularMovies(Constants.API_KEY)
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun logDetailClicked(movie: Movie) {
        Timber.d("Detail clicked: ${movie.title}")
    }

    fun logOpenSiteClicked(movie: Movie) {
        Timber.d("Open site clicked: https://www.themoviedb.org/movie/${movie.id}")
    }
}

