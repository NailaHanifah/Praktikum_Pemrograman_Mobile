package com.example.listfilm.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.listfilm.model.Movie
import com.example.listfilm.util.Constants
import com.example.listfilm.viewmodel.MovieViewModel

@Composable
fun FilmListScreen(navController: NavHostController, viewModel: MovieViewModel) {
    val context = LocalContext.current
    val movies = viewModel.movies.collectAsState().value

    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(movies) { movie: Movie ->
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            ) {
                Column(Modifier.padding(16.dp)) {
                    // 🔄 Gambar online dari TMDB pakai Coil
                    Image(
                        painter = rememberAsyncImagePainter("${Constants.IMAGE_BASE_URL}${movie.posterPath}"),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(Modifier.height(8.dp))
                    Text(text = movie.title, fontWeight = FontWeight.Bold)
                    Text(text = movie.overview, maxLines = 3)

                    Spacer(Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(onClick = {
                            viewModel.logOpenSiteClicked(movie)
                            val intent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://www.themoviedb.org/movie/${movie.id}")
                            )
                            context.startActivity(intent)
                        }) {
                            Text("Open Site")
                        }

                        Button(onClick = {
                            viewModel.logDetailClicked(movie)
                            navController.navigate("detail/${movie.id}")
                        }) {
                            Text("Detail")
                        }
                    }
                }
            }
        }
    }
}
