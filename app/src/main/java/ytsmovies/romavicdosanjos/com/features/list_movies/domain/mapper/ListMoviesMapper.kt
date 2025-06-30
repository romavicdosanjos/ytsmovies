package ytsmovies.romavicdosanjos.com.features.list_movies.domain.mapper

import ytsmovies.romavicdosanjos.com.core.services.helpers.Mapper
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.response.ListMoviesResponse
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity.MoviesEntity

class ListMoviesMapper : Mapper<ListMoviesResponse, List<MoviesEntity>>() {

    override fun map(data: ListMoviesResponse): List<MoviesEntity> {
        return data.data.movies.map { movie ->
            MoviesEntity(
                id = movie.id,
                titleEnglish = movie.titleEnglish,
                year = movie.year,
                rating = movie.rating,
                largeCoverImage = movie.largeCoverImage
            )
        }
    }
}
