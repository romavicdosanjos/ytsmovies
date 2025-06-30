package ytsmovies.romavicdosanjos.com.features.list_movies.domain.repository

import kotlinx.coroutines.flow.Flow
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.request.ListMoviesRequest
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity.MoviesEntity

interface ListMoviesRepository {
    suspend fun listMovies(
        request: ListMoviesRequest
    ): Flow<List<MoviesEntity>>
}