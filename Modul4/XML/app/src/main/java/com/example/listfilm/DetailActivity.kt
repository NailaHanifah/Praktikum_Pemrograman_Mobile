package com.example.listfilm

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.listfilm.data.filmList

class DetailActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("film")
        if (title == null) {
            Toast.makeText(this, "Data film tidak diterima", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        val film = filmList.find { it.title == title }
        if (film == null) {
            Toast.makeText(this, "Film tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        findViewById<ImageView>(R.id.imgDetail).setImageResource(film.imageResId)
        findViewById<TextView>(R.id.tvDetailTitle).text = film.title
        findViewById<TextView>(R.id.tvDetailGenre).text = "${film.genre} • ${film.year}"
        findViewById<TextView>(R.id.tvDetailDescription).text = film.description
    }
}
