package com.apoorvgupta.capabilities.network.rest.data.categories

import com.apoorvgupta.core.utils.emptyValue
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
                id = String.emptyValue(),
                createdAt = String.emptyValue(),
                name = String.emptyValue(),
                updatedAt = String.emptyValue(),
            )
    }
}
