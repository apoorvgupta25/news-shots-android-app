package com.apoorvgupta.newsshots.buildConfigProvider

import com.apoorvgupta.core.interactions.buildConfigProvider.BuildConfigContract
import com.apoorvgupta.newsshots.BuildConfig

/**
 * Implementation of BuildConfigContract providing access to BuildConfig constants.
 *
 * @author Apoorv Gupta
 */
class BuildConfigContractImpl : BuildConfigContract {

    /**
     * Retrieves the base URL for network requests.
     */
    override fun getBaseUrl(): String = BuildConfig.BASE_URL

    /**
     * Retrieves the version name of the application.
     */
    override fun getAppVersion(): String = BuildConfig.VERSION_NAME

    /**
     * Retrieves the application ID.
     */
    override fun getApplicationId(): String = BuildConfig.APPLICATION_ID
}
