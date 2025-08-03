package com.apoorvgupta.core.datastore.model

import android.annotation.SuppressLint
import com.apoorvgupta.core.utils.emptyValue
import kotlinx.serialization.Serializable

/**
 * @author Apoorv Gupta
 */

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class UserPreferences(
    val age: Int? = null
) {
    companion object {
        val emptyValue: UserPreferences
            get() = UserPreferences(
                age = Int.emptyValue(),
            )
    }
}