package com.example.mvvmpatternproject.data.model


import com.google.gson.annotations.SerializedName

data class BaseMovie(
    @SerializedName("dates")
    val dates: Dates,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movieLists: List<MovieList>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)