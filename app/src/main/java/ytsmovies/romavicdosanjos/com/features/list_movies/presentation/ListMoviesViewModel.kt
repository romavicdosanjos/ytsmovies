package ytsmovies.romavicdosanjos.com.features.list_movies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import ytsmovies.romavicdosanjos.com.core.services.helpers.DataUiState
import ytsmovies.romavicdosanjos.com.features.list_movies.data.dto.request.ListMoviesRequest
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.entity.MoviesEntity
import ytsmovies.romavicdosanjos.com.features.list_movies.domain.repository.ListMoviesRepository
import kotlin.uuid.ExperimentalUuidApi

@OptIn(ExperimentalUuidApi::class)
class ListMoviesViewModel(
    private val listMoviesRepository: ListMoviesRepository
) : ViewModel() {

    private val _moviesState = MutableStateFlow<DataUiState<List<MoviesEntity>>>(
        DataUiState.Loading
    )
    val moviesState: StateFlow<DataUiState<List<MoviesEntity>>> get() = _moviesState

    init {
        fetchPlanetaryApod(request = ListMoviesRequest())
    }

    public fun fetchPlanetaryApod(
        request: ListMoviesRequest
    ) {
        viewModelScope.launch {
            listMoviesRepository.listMovies(request)
                .onStart {
                    _moviesState.value = DataUiState.Loading
                }
                .catch { error ->
                    _moviesState.value = DataUiState.Error(error)
                }
                .collect { entity ->
                    _moviesState.value = DataUiState.Success(entity)
                }
        }
    }
}


