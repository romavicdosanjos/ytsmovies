package ytsmovies.romavicdosanjos.com.features.list_movies.presentation

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import org.koin.compose.viewmodel.koinViewModel
import ytsmovies.romavicdosanjos.com.core.services.helpers.DataUiState
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity.MoviesEntity

@Composable
fun ListMoviesScreen() {
    val viewModel: ListMoviesViewModel = koinViewModel()
    val state by viewModel.moviesState.collectAsState()

    when (state) {
        is DataUiState.Loading -> LoadingView()
        is DataUiState.Error -> ErrorView((state as DataUiState.Error).exception.message)
        is DataUiState.Success -> MoviesListView((state as DataUiState.Success<List<MoviesEntity>>).data)
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(message: String?) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = message ?: "Unknown error", color = MaterialTheme.colorScheme.error)

        Log.e("Romavic", "$message")

    }
}

@Composable
fun MoviesListView(movies: List<MoviesEntity>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(movies.size) { index ->
            val movie = movies[index]
            MovieItem(movie)
        }
    }
}

@Composable
fun MovieItem(movie: MoviesEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(model = movie.largeCoverImage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = movie.titleEnglish,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text("Year: ${movie.year}", style = MaterialTheme.typography.bodyMedium)
            Text("Rating: ${movie.rating}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}