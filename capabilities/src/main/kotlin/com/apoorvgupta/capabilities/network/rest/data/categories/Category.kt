package com.apoorvgupta.capabilities.network.rest.data.categories

import com.apoorvgupta.core.utils.EMPTY_STRING
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("_id")
    val id: String,

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("updatedAt")
    val updatedAt: String,
) {
    companion object {
        val emptyValue: Category
            get() = Category(
                id = EMPTY_STRING,
                createdAt = EMPTY_STRING,
                name = EMPTY_STRING,
                updatedAt = EMPTY_STRING,
            )
    }
}
