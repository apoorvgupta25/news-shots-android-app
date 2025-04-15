package com.apoorvgupta.di

import com.apoorvgupta.home.usecase.HomeScreenUseCase
import com.apoorvgupta.home.usecase.HomeScreenUseCaseImpl
import com.apoorvgupta.newsdetails.usecase.NewsDetailsScreenUseCase
import com.apoorvgupta.newsdetails.usecase.NewsDetailsScreenUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Apoorv Gupta
 */
@Module
@InstallIn(SingletonComponent::class)
interface HomeModule {
    @Binds
    fun providesHomeScreenUseCase(impl: HomeScreenUseCaseImpl): HomeScreenUseCase

    @Binds
    fun providesNewsDetailScreenUseCase(impl: NewsDetailsScreenUseCaseImpl): NewsDetailsScreenUseCase
}
