package com.example.mvvmpatternproject.di

import com.example.mvvmpatternproject.data.MovieRepository
import com.example.mvvmpatternproject.data.remotedata.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(apiService: ApiService):MovieRepository{
        return MovieRepository(apiService)
    }
}