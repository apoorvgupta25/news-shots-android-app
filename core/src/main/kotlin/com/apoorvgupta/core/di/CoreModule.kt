/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.core.di

import com.apoorvgupta.core.threading.AppDispatcherProvider
import com.apoorvgupta.core.threading.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

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
}