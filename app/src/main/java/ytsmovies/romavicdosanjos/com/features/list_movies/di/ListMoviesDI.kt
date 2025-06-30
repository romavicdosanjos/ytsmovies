package ytsmovies.romavicdosanjos.com.features.list_movies.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import ytsmovies.romavicdosanjos.com.core.services.api.ListMoviesApi
import ytsmovies.romavicdosanjos.com.features.list_movies.data.data_source.ListMoviesDataSource
import ytsmovies.romavicdosanjos.com.features.list_movies.data.data_source.ListMoviesDataSourceImpl
import ytsmovies.romavicdosanjos.com.features.list_movies.data.repository.ListMoviesRepositoryImpl
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.mapper.ListMoviesMapper
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.repository.ListMoviesRepository
import ytsmovies.romavicdosanjos.com.features.list_movies.presentation.ListMoviesViewModel

val listMoviesDI = module {
    single<ListMoviesApi> {
        get<Retrofit>().create(ListMoviesApi::class.java)
    }

    single<ListMoviesDataSource> {
        ListMoviesDataSourceImpl(listMoviesApi = get())
    }

    single {
        ListMoviesMapper()
    }

    single<ListMoviesRepository> {
        ListMoviesRepositoryImpl(
            listMoviesDataSource = get(),
            listMoviesMapper = get(),
            moviesDao = get()
        )
    }

    viewModel {
        ListMoviesViewModel(
            listMoviesRepository = get()
        )
    }
}
