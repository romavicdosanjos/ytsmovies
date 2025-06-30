package ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class MoviesEntity(
    @PrimaryKey var id: Int,
    val titleEnglish: String,
    val year: Int,
    val rating: Double,
    val largeCoverImage: String,
)