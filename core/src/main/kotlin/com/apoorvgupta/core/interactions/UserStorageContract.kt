package com.apoorvgupta.core.interactions

/**
 * @author Apoorv Gupta
 */
interface UserStorageContract {
    suspend fun saveUserPreferences(age: Int)

    suspend fun getUserPreferences(): Int?

    suspend fun removeUserPreferences()
}
