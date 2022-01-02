package com.example.mvvmpatternproject.data

object ApiUrls {
    private const val API_KEY="0010c85623e80b32b2ed08dec64afa7c"
    const val BASE_URL="https://api.themoviedb.org/3/movie/"
    const val LATEST_MOVIE="now_playing?api_key=${API_KEY}&language=en-US"
    const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w500/"

}