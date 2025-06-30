package ytsmovies.romavicdosanjos.com.features.list_movies.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ytsmovies.romavicdosanjos.com.core.services.database.dao.MoviesDao
import ytsmovies.romavicdosanjos.com.features.list_movies.data.data_source.ListMoviesDataSource
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.request.ListMoviesRequest
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity.MoviesEntity
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.mapper.ListMoviesMapper
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.repository.ListMoviesRepository

class ListMoviesRepositoryImpl(
    private val listMoviesDataSource: ListMoviesDataSource,
    private val moviesDao: MoviesDao,
    private val listMoviesMapper: ListMoviesMapper
) : ListMoviesRepository {

    override suspend fun listMovies(request: ListMoviesRequest): Flow<List<MoviesEntity>> = flow {
        val response = listMoviesDataSource.getListMovies(request)
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                moviesDao.addMovies(listMoviesMapper.map(body))
                emit(moviesDao.getMovies())
            } else {
                throw Exception("The response is empty.")
            }
        } else {
            throw Exception("HTTP Error ${response.code()}: ${response.message()}")
        }
    }
}