package com.example.listfilm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listfilm.data.Film
import com.example.listfilm.data.filmList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class FilmViewModel(private val source: String) : ViewModel() {
    private val _films = MutableStateFlow<List<Film>>(emptyList())
    val films: StateFlow<List<Film>> = _films

    init {
        viewModelScope.launch {
            _films.value = filmList
            Timber.d("Film list loaded from $source with ${filmList.size} items")
        }
    }

    fun logDetailClicked(film: Film) {
        Timber.d("Detail clicked: ${film.title}")
    }

    fun logOpenSiteClicked(film: Film) {
        Timber.d("Open site clicked: ${film.url}")
    }
}

