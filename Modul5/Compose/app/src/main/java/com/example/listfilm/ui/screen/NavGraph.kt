package com.example.listfilm.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.listfilm.viewmodel.MovieViewModel

@Composable
fun AppNavGraph(navController: NavHostController, viewModel: MovieViewModel) {
    val movies = viewModel.movies.collectAsState().value

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            FilmListScreen(navController = navController, viewModel = viewModel)
        }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val movie = movies.find { it.id == id }
            if (movie != null) {
                MovieDetailScreen(movie = movie, navController = navController)
            } else {
                Text("Movie not found", modifier = Modifier.fillMaxSize())
            }
        }
    }
}
