package com.example.listfilm.ui.screen

import android.net.Uri
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.listfilm.data.filmList

@Composable
fun AppNavGraph(navController: NavHostController) {
    val films = filmList
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            FilmListScreen(navController)
        }
        composable("detail/{title}") { backStackEntry ->
            val rawTitle = backStackEntry.arguments?.getString("title")
            val decodedTitle = rawTitle?.let { Uri.decode(it) }
            val film = films.find { it.title == decodedTitle }
            if (film != null) {
                FilmDetailScreen(film = film)
            } else {
                Text("Film not found", modifier = Modifier.fillMaxSize())
            }
        }
    }
}