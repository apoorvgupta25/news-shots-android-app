package com.apoorvgupta.core.datastore.model

import android.annotation.SuppressLint
import com.apoorvgupta.core.utils.emptyValue
import kotlinx.serialization.Serializable

/**
 * @author Apoorv Gupta
 */
@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class AccessTokenPreferences(
    val token: String? = null
) {
    companion object {
        val emptyValue: AccessTokenPreferences
            get() = AccessTokenPreferences(
                token = String.emptyValue(),
            )
    }
}
