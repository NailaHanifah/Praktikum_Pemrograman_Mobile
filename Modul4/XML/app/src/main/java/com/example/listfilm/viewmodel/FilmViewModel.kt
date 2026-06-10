package com.example.listfilm.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.listfilm.data.Film
import com.example.listfilm.data.filmList as staticFilmList // alias biar aman
import timber.log.Timber

class FilmViewModel(private val username: String) : ViewModel() {

    private val _filmList = MutableStateFlow<List<Film>>(emptyList())
    val films: StateFlow<List<Film>> = _filmList

    private val _selectedFilm = MutableStateFlow<Film?>(null)
    val selectedFilm: StateFlow<Film?> = _selectedFilm

    init {
        Timber.i("[$username] FilmViewModel initialized.")
        loadFilms()
    }

    private fun loadFilms() {
        _filmList.value = staticFilmList // ini refer ke file data
        Timber.i("[$username] Film list loaded with ${staticFilmList.size} items.")
    }

    fun selectFilm(film: Film) {
        _selectedFilm.value = film
        Timber.i("[$username] Film selected: ${film.title}")
    }
}

