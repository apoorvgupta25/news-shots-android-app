/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.network.rest.di

import android.content.Context
import com.apoorvgupta.capabilities.network.rest.api.AuthInterceptor
import com.apoorvgupta.capabilities.network.rest.api.MainApiService
import com.apoorvgupta.capabilities.network.rest.interceptor.CacheInterceptor
import com.apoorvgupta.capabilities.util.Constants.NETWORK_NAMED_ARGUMENTS
import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import com.apoorvgupta.core.logger.AppLogger
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
import javax.inject.Named
import javax.inject.Singleton

// Constants
// TODO Revert timeout to 30 L
private const val READ_TIMEOUT = 40L
private const val CONNECT_TIMEOUT = 40L

/**
 * Dagger Hilt module for providing network-related dependencies.
 *
 * @author Apoorv Gupta
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @Named(NETWORK_NAMED_ARGUMENTS)
    fun providesCachingInterceptor(): CacheInterceptor = CacheInterceptor()

    @Provides
    @Named(NETWORK_NAMED_ARGUMENTS)
    fun provideCache(
        @ApplicationContext context: Context,
    ) = Cache(File(context.cacheDir, "somos_cache_file"), ((10 * 1024 * 1024)).toLong())

    /**
     * Provides the [OkHttpClient] for creating a Retrofit instance.
     */
    @Singleton
    @Provides
    @Named(NETWORK_NAMED_ARGUMENTS)
    fun provideOkHttp(
        @Named(NETWORK_NAMED_ARGUMENTS) authInterceptor: AuthInterceptor,
        @Named(NETWORK_NAMED_ARGUMENTS) cache: Cache,
        @Named(NETWORK_NAMED_ARGUMENTS) cacheInterceptor: CacheInterceptor,
    ): OkHttpClient {
        val loggingInterceptor =
            HttpLoggingInterceptor { message ->
                AppLogger.d("OkHttp", message)
            }
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .addNetworkInterceptor(cacheInterceptor)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Provides the [Gson] object for creating a Retrofit instance.
     */
    @Singleton
    @Provides
    @Named(NETWORK_NAMED_ARGUMENTS)
    fun providesGson(): Gson = GsonBuilder().setLenient().create()

    /**
     * Provides the [Retrofit] object based on [OkHttpClient] and [Gson] configuration.
     */
    @Singleton
    @Provides
    @Named(NETWORK_NAMED_ARGUMENTS)
    fun provideRetrofit(
        buildConfigContract: BuildConfigContract,
        @Named(NETWORK_NAMED_ARGUMENTS) okHttpClient: OkHttpClient,
        @Named(NETWORK_NAMED_ARGUMENTS) gson: Gson,
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(buildConfigContract.getBaseUrl())
            .client(okHttpClient)
            .build()

    /**
     * Dagger Provider method for creating a singleton instance of [MainApiService].
     *
     * @param retrofit The Retrofit instance configured with necessary network settings.
     * @return An instance of [MainApiService] for making API calls related to main screen functionality.
     */
    @Singleton
    @Provides
    fun provideMainRetrofitApi(
        @Named(NETWORK_NAMED_ARGUMENTS) retrofit: Retrofit,
    ): MainApiService = retrofit.create(MainApiService::class.java)
}
