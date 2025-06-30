package ytsmovies.romavicdosanjos.com.features.list_movies.data.data_source

import retrofit2.Response
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.request.ListMoviesRequest
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.response.ListMoviesResponse

interface ListMoviesDataSource {
    suspend fun getListMovies(
        request: ListMoviesRequest
    ): Response<ListMoviesResponse>
}