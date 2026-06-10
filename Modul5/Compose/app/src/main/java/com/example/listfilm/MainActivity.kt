package com.example.listfilm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.listfilm.repository.MovieRepository
import com.example.listfilm.ui.screen.AppNavGraph
import com.example.listfilm.viewmodel.MovieViewModel
import com.example.listfilm.viewmodel.MovieViewModelFactory
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("MainActivity onCreate() called")

        setContent {
            val navController = rememberNavController()
            val context = applicationContext
            val repository = MovieRepository(context)
            val viewModel: MovieViewModel = viewModel(
                factory = MovieViewModelFactory(repository)
            )
            AppNavGraph(navController = navController, viewModel = viewModel)
        }
    }
}

