package com.apoorvgupta.core.interactions.buildConfigProvider

/**
 * Interface for accessing BuildConfig constants such as base URL, application version, and application ID.
 */
interface BuildConfigContract {
    /**
     * Retrieves the base URL for network requests.
     *
     * @return The base URL as a string.
     */
    fun getBaseUrl(): String

    /**
     * Retrieves the version name of the application.
     *
     * @return The version name as a string.
     */
    fun getAppVersion(): String

    /**
     * Retrieves the application ID.
     *
     * @return The application ID as a string.
     */
    fun getApplicationId(): String
}
