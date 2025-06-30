package ytsmovies.romavicdosanjos.com.di

import androidx.room.Room
import ytsmovies.romavicdosanjos.com.features.list_movies.di.listMoviesDI
import org.koin.android.ext.koin.androidApplication
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ytsmovies.romavicdosanjos.com.BuildConfig
import ytsmovies.romavicdosanjos.com.core.services.database.AppDatabase

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "yts_movies.db"
        ).build()
    }

    single {
        get<AppDatabase>().moviesDao()
    }

    loadKoinModules(listOf(listMoviesDI))
}
