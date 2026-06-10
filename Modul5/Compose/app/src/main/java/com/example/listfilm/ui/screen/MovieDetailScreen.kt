package com.example.listfilm.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.listfilm.model.Movie

@Composable
fun MovieDetailScreen(movie: Movie, navController: NavHostController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        Text(text = movie.title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = movie.overview)
        Spacer(modifier = Modifier.height(16.dp))

        androidx.compose.material3.Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}
