package com.apoorvgupta.core.interactions

/**
 * @author Apoorv Gupta
 */
interface AccessTokenStorageContract {

    suspend fun saveAccessToken(accessToken: String)

    suspend fun getAccessToken(): String?

    suspend fun removeAccessToken()
}
