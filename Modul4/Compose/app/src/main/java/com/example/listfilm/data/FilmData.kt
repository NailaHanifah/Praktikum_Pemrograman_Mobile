package com.example.listfilm.data

import com.example.listfilm.R

val filmList = listOf(
    Film(
        title = "Crash Landing on You",
        description = "Romansa tak terduga antara pewaris Korea Selatan dan tentara Korea Utara.",
        imageResId = R.drawable.crashlandingonyou,
        url = "https://youtu.be/GVQGWgeVc4k?feature=shared",
        genre = "Romance, Drama",
        year = 2019
    ),
    Film(
        title = "Descendants of the Sun",
        description = "Cinta antara dokter dan tentara di zona perang.",
        imageResId = R.drawable.dots,
        url = "https://youtu.be/wTGwjDqtfzQ?feature=shared",
        genre = "Romance, Action",
        year = 2016
    ),
    Film(
        title = "Goblin",
        description = "Kisah makhluk abadi yang mencari pengantinnya untuk mengakhiri kutukan.",
        imageResId = R.drawable.goblin, // Hapus ekstensi .jpg karena di res sudah tanpa ekstensi
        url = "https://youtu.be/S94ukM8C17A?feature=shared",
        genre = "Fantasy, Romance",
        year = 2016
    ),
    Film(
        title = "Resident Playbook",
        description = "Kehidupan para dokter muda di rumah sakit penuh tantangan.",
        imageResId = R.drawable.residentplaybook,
        url = "https://youtu.be/VTjfJ5kWxUE?feature=shared",
        genre = "Medical, Drama",
        year = 2020
    ),
    Film(
        title = "Twenty Five Twenty One",
        description = "Cinta dan mimpi yang tumbuh di tengah krisis tahun 1998.",
        imageResId = R.drawable.twentyfivetwentyone,
        url = "https://youtu.be/PBCXHOskDQ4?feature=shared",
        genre = "Romance, Drama",
        year = 2022
    )
)
