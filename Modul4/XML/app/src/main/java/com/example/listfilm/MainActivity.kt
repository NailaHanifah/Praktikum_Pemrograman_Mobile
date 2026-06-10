package com.example.listfilm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.listfilm.viewmodel.FilmViewModel
import com.example.listfilm.viewmodel.FilmViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var rvFilm: RecyclerView
    private lateinit var viewModel: FilmViewModel
    private lateinit var adapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.plant(Timber.DebugTree())

        setContentView(R.layout.activity_main)

        // Setup RecyclerView
        rvFilm = findViewById(R.id.rvFilm)
        rvFilm.layoutManager = LinearLayoutManager(this)

        // Setup ViewModel dengan factory
        val factory = FilmViewModelFactory("Devi")
        viewModel = ViewModelProvider(this, factory)[FilmViewModel::class.java]

        // Setup Adapter dengan callback onClick
        adapter = FilmAdapter(this, emptyList()) { film ->
            Timber.i("Button Detail clicked for: ${film.title}")
            viewModel.selectFilm(film)
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("film", film.title)
            }
            startActivity(intent)
        }
        rvFilm.adapter = adapter

        lifecycleScope.launch {
            viewModel.films.collectLatest { films ->
                adapter.updateData(films)
            }
        }
    }
}
