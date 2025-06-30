package ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.response

import com.google.gson.annotations.SerializedName

data class ListMoviesResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("status_message")
    val statusMessage: String,
    @SerializedName("data")
    val `data`: DataResponse,
    @SerializedName("@meta")
    val meta: MetaResponse
)

data class DataResponse(
    @SerializedName("movie_count")
    val movieCount: Int,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page_number")
    val pageNumber: Int,
    @SerializedName("movies")
    val movies: List<MovyResponse>
)

data class MetaResponse(
    @SerializedName("server_time")
    val serverTime: Int,
    @SerializedName("server_timezone")
    val serverTimezone: String,
    @SerializedName("api_version")
    val apiVersion: Int,
    @SerializedName("execution_time")
    val executionTime: String
)

data class MovyResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("imdb_code")
    val imdbCode: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("title_english")
    val titleEnglish: String,
    @SerializedName("title_long")
    val titleLong: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("genres")
    val genres: List<String>,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("description_full")
    val descriptionFull: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("yt_trailer_code")
    val ytTrailerCode: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("mpa_rating")
    val mpaRating: String,
    @SerializedName("background_image")
    val backgroundImage: String,
    @SerializedName("background_image_original")
    val backgroundImageOriginal: String,
    @SerializedName("small_cover_image")
    val smallCoverImage: String,
    @SerializedName("medium_cover_image")
    val mediumCoverImage: String,
    @SerializedName("large_cover_image")
    val largeCoverImage: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("torrents")
    val torrents: List<TorrentResponse>,
    @SerializedName("date_uploaded")
    val dateUploaded: String,
    @SerializedName("date_uploaded_unix")
    val dateUploadedUnix: Int
)

data class TorrentResponse(
    @SerializedName("url")
    val url: String,
    @SerializedName("hash")
    val hash: String,
    @SerializedName("quality")
    val quality: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("is_repack")
    val isRepack: String,
    @SerializedName("video_codec")
    val videoCodec: String,
    @SerializedName("bit_depth")
    val bitDepth: String,
    @SerializedName("audio_channels")
    val audioChannels: String,
    @SerializedName("seeds")
    val seeds: Int,
    @SerializedName("peers")
    val peers: Int,
    @SerializedName("size")
    val size: String,
    @SerializedName("size_bytes")
    val sizeBytes: Long,
    @SerializedName("date_uploaded")
    val dateUploaded: String,
    @SerializedName("date_uploaded_unix")
    val dateUploadedUnix: Int
)