package com.example.mvvmpatternproject.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.mvvmpatternproject.data.model.MovieList
import com.example.mvvmpatternproject.data.remotedata.ApiService
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE_INDEX = 1

class PagingSource(
    private val apiService: ApiService
) : PagingSource<Int, MovieList>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieList> {
        val position = params.key ?: STARTING_PAGE_INDEX

        return try {
            val baseMovie =   apiService.movieList(position)
            val movies = baseMovie.movieLists
            LoadResult.Page(
                data = movies,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (movies.isEmpty()) null else position + 1
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieList>): Int? {
        TODO("Not yet implemented")
    }


}