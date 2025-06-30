package ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.request

import com.google.gson.annotations.SerializedName

data class ListMoviesRequest(
    @SerializedName("limit")
    val limit: Int? = null,

    @SerializedName("page")
    val page: Int? = null,

    @SerializedName("quality")
    val quality: String? = null,

    @SerializedName("minimum_rating")
    val minimumRating: Int? = null,

    @SerializedName("query_term")
    val queryTerm: String? = null,

    @SerializedName("genre")
    val genre: String? = null,

    @SerializedName("sort_by")
    val sortBy: String? = null,

    @SerializedName("order_by")
    val orderBy: String? = null,

    @SerializedName("with_rt_ratings")
    val withRtRatings: Boolean? = null
)
