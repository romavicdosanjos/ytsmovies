package ytsmovies.romavicdosanjos.com.core.services.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.response.ListMoviesResponse

interface ListMoviesApi {
    @GET("list_movies.json")
    suspend fun getListMovies(
        @QueryMap query: Map<String, String>
    ): Response<ListMoviesResponse>
}