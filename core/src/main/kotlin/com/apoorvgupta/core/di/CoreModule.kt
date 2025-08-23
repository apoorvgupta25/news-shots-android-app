/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.core.di

import android.content.Context
import com.apoorvgupta.core.interactions.AccessTokenStorageContract
import com.apoorvgupta.core.interactions.AccessTokenStorageContractImpl
import com.apoorvgupta.core.interactions.UserStorageContract
import com.apoorvgupta.core.interactions.UserStorageContractImpl
import com.apoorvgupta.core.threading.AppDispatcherProvider
import com.apoorvgupta.core.threading.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger Hilt module for providing dependencies related to the core module.
 *
 * @author Apoorv Gupta
 */
@Module
@InstallIn(SingletonComponent::class)
interface CoreModule {
    @Binds
    fun dispatchersProvider(impl: AppDispatcherProvider): DispatcherProvider

    companion object {

        @Singleton
        @Provides
        fun accessTokenContractProvider(
            @ApplicationContext appContext: Context,
        ): AccessTokenStorageContract = AccessTokenStorageContractImpl(
            context = appContext,
        )

        @Singleton
        @Provides
        fun userStorageContractProvider(
            @ApplicationContext appContext: Context,
        ): UserStorageContract = UserStorageContractImpl(
            context = appContext,
        )
    }
}
