package com.example.listfilm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listfilm.data.filmList

class MainActivity : AppCompatActivity() {

    private lateinit var rvFilm: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilm = findViewById(R.id.rvFilm)
        rvFilm.layoutManager = LinearLayoutManager(this)

        val adapter = FilmAdapter(this, filmList) { film ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("film", film.title) // pakai title sebagai ID
            }
            startActivity(intent)
        }

        rvFilm.adapter = adapter
    }
}
