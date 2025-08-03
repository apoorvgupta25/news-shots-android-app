package com.apoorvgupta.core.interactions

import android.content.Context
import androidx.datastore.dataStore
import com.apoorvgupta.core.datastore.DataStoreSerializer
import com.apoorvgupta.core.datastore.PreferenceFileNames.ACCESS_TOKEN_PREFERENCES_FILE_NAME
import com.apoorvgupta.core.datastore.model.AccessTokenPreferences
import kotlinx.coroutines.flow.first
import javax.inject.Inject


/**
 * @author Apoorv Gupta
 */

class AccessTokenStorageContractImpl @Inject constructor(
    val context: Context,
) : AccessTokenStorageContract {

    private val Context.dataStorePref by dataStore(
        fileName = ACCESS_TOKEN_PREFERENCES_FILE_NAME,
        serializer = DataStoreSerializer.createSecuredSerializer(
            serializer = AccessTokenPreferences.serializer(),
            default = AccessTokenPreferences.emptyValue
        )
    )

    override suspend fun saveAccessToken(accessToken: String) {
        context.dataStorePref.updateData {
            AccessTokenPreferences(
                token = accessToken
            )
        }
    }

    override suspend fun getAccessToken(): String? {
        return context.dataStorePref.data.first().token
    }

    override suspend fun removeAccessToken() {
        context.dataStorePref.updateData {
            AccessTokenPreferences(
                token = null
            )
        }
    }
}
