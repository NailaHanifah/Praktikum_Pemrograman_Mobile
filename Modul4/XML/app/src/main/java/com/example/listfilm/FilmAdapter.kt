package com.example.listfilm

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.listfilm.data.Film
import com.example.listfilm.data.filmList

class FilmAdapter(
    private val context: Context,
    private var listFilm: List<Film>,
    private val onDetailClick: (Film) -> Unit
) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    inner class FilmViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFilm: ImageView = view.findViewById(R.id.imgFilm)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvInfo: TextView = view.findViewById(R.id.tvInfo)
        val btnOpenSite: Button = view.findViewById(R.id.btnOpenSite)
        val btnDetail: Button = view.findViewById(R.id.btnDetail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int = listFilm.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newFilmList: List<Film>) {
        listFilm = newFilmList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listFilm[position]
        holder.imgFilm.setImageResource(film.imageResId)
        holder.tvTitle.text = film.title
        holder.tvInfo.text = "${film.genre} • ${film.year}"

        holder.btnOpenSite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(film.url))
            context.startActivity(intent)
        }

        holder.btnDetail.setOnClickListener {
            onDetailClick(film)
        }
    }
}
