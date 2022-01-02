package com.example.mvvmpatternproject.data.remotedata

import com.example.mvvmpatternproject.data.ApiUrls
import com.example.mvvmpatternproject.data.model.BaseMovie
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(ApiUrls.LATEST_MOVIE)
    suspend fun movieList(@Query("page") pageNumber:Int):BaseMovie
}