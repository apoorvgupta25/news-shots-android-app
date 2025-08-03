package com.apoorvgupta.core.interactions

import android.content.Context
import androidx.datastore.dataStore
import com.apoorvgupta.core.datastore.DataStoreSerializer
import com.apoorvgupta.core.datastore.PreferenceFileNames.USER_PREFERENCES_FILE_NAME
import com.apoorvgupta.core.datastore.model.UserPreferences
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * @author Apoorv Gupta
 */
class UserStorageContractImpl @Inject constructor(
    val context: Context,
) : UserStorageContract {

    private val Context.dataStorePref by dataStore(
        fileName = USER_PREFERENCES_FILE_NAME,
        serializer = DataStoreSerializer.createNormalSerializer(
            serializer = UserPreferences.serializer(),
            default = UserPreferences.emptyValue
        )
    )

    override suspend fun saveUserPreferences(age: Int) {
        context.dataStorePref.updateData {
            UserPreferences(
                age = age
            )
        }
    }

    override suspend fun getUserPreferences(): Int? {
        return context.dataStorePref.data.first().age
    }

    override suspend fun removeUserPreferences() {
        context.dataStorePref.updateData {
            UserPreferences(
                age = null
            )
        }
    }
}