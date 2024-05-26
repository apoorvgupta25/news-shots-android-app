package com.apoorvgupta.newsshots.di

import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import com.apoorvgupta.newsshots.buildConfigProvider.BuildConfigContractImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Dagger module responsible for providing dependencies for the application.
 *
 * @author Apoorv Gupta
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    /**
     * Provides the implementation of the [BuildConfigContract] interface.
     *
     * @return An instance of [BuildConfigContractImpl].
     */
    @Provides
    @Singleton
    fun provideBuildConfigContract(): BuildConfigContract {
        return BuildConfigContractImpl()
    }
}
