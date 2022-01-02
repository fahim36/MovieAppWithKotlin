package com.example.mvvmpatternproject.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.mvvmpatternproject.data.MovieRepository
import com.example.mvvmpatternproject.data.model.BaseMovie
import com.example.mvvmpatternproject.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repo: MovieRepository) : ViewModel() {

    val movies = repo.movieList().cachedIn(viewModelScope)

//    private val _movies = MutableLiveData<DataState<BaseMovie>>()
//    val movie: LiveData<DataState<BaseMovie>> get() = _movies
//        viewModelScope.launch {
//            repo.movieList().onEach { movieData ->
//                _movies.value = movieData
//            }.launchIn(viewModelScope)
//        }

}