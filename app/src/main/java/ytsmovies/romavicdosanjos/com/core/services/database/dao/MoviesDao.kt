package ytsmovies.romavicdosanjos.com.core.services.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity.MoviesEntity

@Dao
interface MoviesDao {

    @Query("SELECT * FROM MoviesEntity")
    suspend fun getMovies(): List<MoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addMovies(data: List<MoviesEntity>)
}