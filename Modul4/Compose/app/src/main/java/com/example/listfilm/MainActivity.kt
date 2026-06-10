package com.example.listfilm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.listfilm.ui.screen.AppNavGraph
import com.example.listfilm.viewmodel.FilmViewModel
import com.example.listfilm.viewmodel.FilmViewModelFactory
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("MainActivity onCreate() called")

        setContent {
            val navController = rememberNavController()
            val viewModel: FilmViewModel = viewModel(
                factory = FilmViewModelFactory("Local Data")
            )
            AppNavGraph(navController = navController, viewModel = viewModel)
        }
    }
}