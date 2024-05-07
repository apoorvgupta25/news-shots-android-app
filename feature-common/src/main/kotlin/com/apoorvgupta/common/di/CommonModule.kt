package com.apoorvgupta.common.di

import android.content.Context
import com.apoorvgupta.capabilities.util.Constants
import com.apoorvgupta.common.data.network.CommonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to the common feature.
 *
 * @author Apoorv Gupta
 */
@Module
@InstallIn(SingletonComponent::class)
interface CommonModule {

    companion object {
        /**
         * Dagger Provider method for creating a singleton instance of [CommonApiService].
         *
         * @param retrofit The Retrofit instance configured with necessary network settings.
         * @return An instance of [CommonApiService] for making API calls on home screen
         */
        @Singleton
        @Provides
        fun provideCommonApiService(
            @Named(Constants.NETWORK_NAMED_ARGUMENTS) retrofit: Retrofit,
        ): CommonApiService = retrofit.create(CommonApiService::class.java)

        /**
         * Provider method for getting instance of Coroutine IO Dispatcher
         *
         * @return IO Dispatcher used for launching /switching coroutine on background thread
         */
        @Singleton
        @Provides
        fun provideIOCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

        /**
         * Provides context
         *
         * @param context application Context
         * @return
         */
        @Singleton
        @Provides
        fun provideContext(@ApplicationContext context: Context): Context = context
    }
}
