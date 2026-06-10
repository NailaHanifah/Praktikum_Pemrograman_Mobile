package com.example.listfilm.repository

import android.content.Context
import com.example.listfilm.data.local.MovieDatabase
import com.example.listfilm.data.local.MovieEntity
import com.example.listfilm.model.Movie
import com.example.listfilm.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class MovieRepository(context: Context) {
    private val movieDao = MovieDatabase.getDatabase(context).movieDao()

    fun getPopularMovies(apiKey: String): Flow<List<Movie>> = flow {
        try {
            val response = RetrofitInstance.api.getPopularMovies(apiKey)
            Timber.d("Ambil dari API berhasil: ${response.results.size}")
            val movieEntities = response.results.map {
                MovieEntity(it.id, it.title, it.posterPath, it.overview)
            }
            movieDao.insertAll(movieEntities)
            emit(response.results) // from API
        } catch (e: Exception) {
            Timber.e("Gagal ambil dari API: ${e.message}")
            val cached = movieDao.getAllMovies().map {
                Movie(it.id, it.title, it.posterPath, it.overview)
            }
            emit(cached) // fallback to local Room
        }
    }
}

