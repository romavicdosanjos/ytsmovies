package ytsmovies.romavicdosanjos.com.features.list_movies.data.data_source

import retrofit2.Response
import ytsmovies.romavicdosanjos.com.core.services.api.ListMoviesApi
import ytsmovies.romavicdosanjos.com.core.services.helpers.extensions.toHashMap
import ytsmovies.romavicdosanjos.com.core.services.helpers.extensions.toQueryMap
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.request.ListMoviesRequest
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.response.ListMoviesResponse

class ListMoviesDataSourceImpl(
    private val listMoviesApi: ListMoviesApi
) : ListMoviesDataSource {

    override suspend fun getListMovies(
        request: ListMoviesRequest
    ): Response<ListMoviesResponse> {
        try {
            val response: Response<ListMoviesResponse> = listMoviesApi.getListMovies(
                query = request.toQueryMap()
            )

            return response
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}