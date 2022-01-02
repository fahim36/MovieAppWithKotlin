package com.example.mvvmpatternproject.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.mvvmpatternproject.data.model.BaseMovie
import com.example.mvvmpatternproject.data.remotedata.ApiService
import com.example.mvvmpatternproject.utils.DataState
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {

    fun movieList() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PagingSource(apiService) }
        ).liveData

}