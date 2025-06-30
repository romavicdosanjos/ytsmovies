package ytsmovies.romavicdosanjos.com.core.services.helpers

sealed class DataUiState<out T> {
    data class Success<out T>(val data: T) : DataUiState<T>()
    data class Error(val exception: Throwable) : DataUiState<Nothing>()
    data object Loading : DataUiState<Nothing>()
}
