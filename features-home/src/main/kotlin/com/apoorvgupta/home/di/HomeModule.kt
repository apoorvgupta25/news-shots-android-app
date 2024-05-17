package com.apoorvgupta.home.di

import com.apoorvgupta.capabilities.util.Constants
import com.apoorvgupta.home.data.network.HomeApiService
import com.apoorvgupta.home.data.remote.HomeDataRepository
import com.apoorvgupta.home.data.remote.HomeDataRepositoryImpl
import com.apoorvgupta.home.usecase.HomeUseCase
import com.apoorvgupta.home.usecase.HomeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Apoorv Gupta
 */

@InstallIn(SingletonComponent::class)
@Module
interface HomeModule {

    /**
     * Dagger Provides abstract method that binds the implementation of a [HomeDataRepository]
     *
     * @param refreshDataRepoImpl instance of Refresh Data Repo implementation
     * @return An instance of [HomeDataRepositoryImpl]
     */
    @Binds
    fun providesRefreshDataRepo(refreshDataRepoImpl: HomeDataRepositoryImpl): HomeDataRepository

    @Binds
    fun providesHomeUseCase(homeUseCaseImpl: HomeUseCaseImpl): HomeUseCase

    companion object {
        /**
         * Dagger Provider method for creating a singleton instance of [HomeApiService].
         *
         * @param retrofit The Retrofit instance configured with necessary network settings.
         * @return An instance of [HomeApiService] for making API calls on home screen
         */
        @Singleton
        @Provides
        fun provideSearchApiService(
            @Named(Constants.NETWORK_NAMED_ARGUMENTS) retrofit: Retrofit,
        ): HomeApiService = retrofit.create(HomeApiService::class.java)
    }
}
