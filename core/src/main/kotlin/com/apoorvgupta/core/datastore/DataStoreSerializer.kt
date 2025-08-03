package com.apoorvgupta.core.datastore

import androidx.datastore.core.Serializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import java.util.Base64

/**
 * @author Apoorv Gupta
 */

object DataStoreSerializer {
    fun <T> createNormalSerializer(
        serializer: KSerializer<T>,
        default: T,
    ): Serializer<T> = object : Serializer<T> {
        override val defaultValue: T = default

        override suspend fun readFrom(input: InputStream): T {
            val bytes = withContext(Dispatchers.IO) {
                input.use { it.readBytes() }
            }
            return Json.decodeFromString(deserializer = serializer, string = bytes.decodeToString())
        }

        override suspend fun writeTo(t: T, output: OutputStream) {
            withContext(Dispatchers.IO) {
                output.write(Json.encodeToString(serializer = serializer, value = t).encodeToByteArray())
            }
        }
    }

    fun <T> createSecuredSerializer(
        serializer: KSerializer<T>,
        default: T,
    ): Serializer<T> = object : Serializer<T> {
        override val defaultValue: T = default

        override suspend fun readFrom(input: InputStream): T {
            val encryptedBytes = withContext(Dispatchers.IO) {
                input.use { it.readBytes() }
            }
            val encryptedBytesDecoded = Base64.getDecoder().decode(encryptedBytes)
            val decryptedBytes = Crypto.decrypt(encryptedBytesDecoded)
            val decodedJsonString = decryptedBytes.decodeToString()
            return Json.decodeFromString(deserializer = serializer, string = decodedJsonString)
        }

        override suspend fun writeTo(t: T, output: OutputStream) {
            val json = Json.encodeToString(serializer = serializer, value = t)
            val bytes = json.toByteArray()
            val encryptedBytes = Crypto.encrypt(bytes)
            val encryptedBytesBase64 = Base64.getEncoder().encode(encryptedBytes)
            withContext(Dispatchers.IO) {
                output.use {
                    it.write(encryptedBytesBase64)
                }
            }
        }
    }

    /*
object UserPreferencesSerializer : Serializer<UserPreferences> {
    override val defaultValue: UserPreferences = UserPreferences()

    override suspend fun readFrom(input: InputStream): UserPreferences {
        val bytes = withContext(Dispatchers.IO) {
            input.use { it.readBytes() }
        }
        return Json.decodeFromString(
            string = bytes.decodeToString()
        )
    }

    override suspend fun writeTo(t: UserPreferences, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(Json.encodeToString(value = t).encodeToByteArray())
        }
    }
}
*/

    /*
    object AccessTokenSerializer: Serializer<AccessTokenPreferences> {
        override val defaultValue: AccessTokenPreferences
            get() = AccessTokenPreferences()

        override suspend fun readFrom(input: InputStream): AccessTokenPreferences {
            val encryptedBytes = withContext(Dispatchers.IO) {
                input.use { it.readBytes() }
            }
            val encryptedBytesDecoded = Base64.getDecoder().decode(encryptedBytes)
            val decryptedBytes = Crypto.decrypt(encryptedBytesDecoded)
            val decodedJsonString = decryptedBytes.decodeToString()
            return Json.decodeFromString(decodedJsonString)
        }

        override suspend fun writeTo(t: AccessTokenPreferences, output: OutputStream) {
            val json = Json.encodeToString(t)
            val bytes = json.toByteArray()
            val encryptedBytes = Crypto.encrypt(bytes)
            val encryptedBytesBase64 = Base64.getEncoder().encode(encryptedBytes)
            withContext(Dispatchers.IO) {
                output.use {
                    it.write(encryptedBytesBase64)
                }
            }
        }
    }
     */
}
