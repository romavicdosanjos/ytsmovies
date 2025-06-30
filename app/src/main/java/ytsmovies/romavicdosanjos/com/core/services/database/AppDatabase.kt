package ytsmovies.romavicdosanjos.com.core.services.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ytsmovies.romavicdosanjos.com.core.services.database.dao.MoviesDao
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity.MoviesEntity
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
@Database(entities = [MoviesEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}