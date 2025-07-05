/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.network.rest.di

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.api.ApiService
import com.apoorvgupta.capabilities.network.rest.api.AuthInterceptor
import com.apoorvgupta.capabilities.network.rest.api.RemoteDataSource
import com.apoorvgupta.capabilities.network.rest.domain.categories.repo.CategoriesRepo
import com.apoorvgupta.capabilities.network.rest.domain.categories.repo.CategoriesRepoImpl
import com.apoorvgupta.capabilities.network.rest.domain.categories.usecase.GetAllCategoriesUseCase
import com.apoorvgupta.capabilities.network.rest.domain.categories.usecase.GetAllCategoriesUseCaseImpl
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepo
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.repo.NewsShotsRepoImpl
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetAllNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetAllNewsShotsUseCaseImpl
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetIndividualNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetIndividualNewsShotsUseCaseImpl
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetNewsShotsByCategoryUseCase
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetNewsShotsByCategoryUseCaseImpl
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetRecentNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetRecentNewsShotsUseCaseImpl
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetSearchedNewsShotsUseCase
import com.apoorvgupta.capabilities.network.rest.domain.newsshots.usecase.GetSearchedNewsShotsUseCaseImpl
import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import com.apoorvgupta.core.logger.AppLogger
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// Constants
private const val READ_TIMEOUT = 15L
private const val CONNECT_TIMEOUT = 15L

/**
 * Dagger Hilt module for providing network-related dependencies.
 *
 * @author Apoorv Gupta
 */
@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun providesRecentNewsShotsUseCase(impl: GetRecentNewsShotsUseCaseImpl): GetRecentNewsShotsUseCase

    @Binds
    fun providesNewsShotsByCategoryUseCase(impl: GetNewsShotsByCategoryUseCaseImpl): GetNewsShotsByCategoryUseCase

    @Binds
    fun providesIndividualNewsShotsUseCase(impl: GetIndividualNewsShotsUseCaseImpl): GetIndividualNewsShotsUseCase

    @Binds
    fun providesSearchedNewsShotsUseCase(impl: GetSearchedNewsShotsUseCaseImpl): GetSearchedNewsShotsUseCase

    @Binds
    fun providesAllNewsShotsUseCase(impl: GetAllNewsShotsUseCaseImpl): GetAllNewsShotsUseCase

    @Binds
    fun providesCategoriesUseCase(impl: GetAllCategoriesUseCaseImpl): GetAllCategoriesUseCase

    companion object {

        @Provides
        fun provideCache(
            @ApplicationContext context: Context,
        ) = Cache(File(context.cacheDir, "somos_cache_file"), (10 * 1024 * 1024).toLong())

        /**
         * Provides the [OkHttpClient] for creating a Retrofit instance.
         */
        @Singleton
        @Provides
        fun provideOkHttp(
            authInterceptor: AuthInterceptor,
        ): OkHttpClient {
            val loggingInterceptor =
                HttpLoggingInterceptor { message ->
                    AppLogger.d("OkHttp", message)
                }
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build()
        }

        /**
         * Provides the [Gson] object for creating a Retrofit instance.
         */
        @Singleton
        @Provides
        fun providesGson(): Gson = GsonBuilder().create()

        /**
         * Provides the [Retrofit] object based on [OkHttpClient] and [Gson] configuration.
         */
        @Singleton
        @Provides
        fun providesRetrofit(
            buildConfigContract: BuildConfigContract,
            okHttpClient: OkHttpClient,
            gson: Gson,
        ): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(buildConfigContract.getBaseUrl())
            .client(okHttpClient)
            .build()

        /**
         * Dagger Provider method for creating a singleton instance of [ApiService].
         *
         * @param retrofit The Retrofit instance configured with necessary network settings.
         * @return An instance of [ApiService] for making API calls related to main screen functionality.
         */
        @Singleton
        @Provides
        fun provideRetrofitApiService(
            retrofit: Retrofit,
        ): ApiService = retrofit.create(ApiService::class.java)

        @Singleton
        @Provides
        fun providesCategoriesRepo(
            @ApplicationContext appContext: Context,
            remoteDataSource: RemoteDataSource,
        ): CategoriesRepo = CategoriesRepoImpl(
            context = appContext,
            remoteDataSource = remoteDataSource,
        )

        @Singleton
        @Provides
        fun providesNewsShotsRepo(
            @ApplicationContext appContext: Context,
            remoteDataSource: RemoteDataSource,
        ): NewsShotsRepo = NewsShotsRepoImpl(
            context = appContext,
            remoteDataSource = remoteDataSource,
        )
    }
}
