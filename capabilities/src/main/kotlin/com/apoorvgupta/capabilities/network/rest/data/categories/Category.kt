package com.apoorvgupta.capabilities.network.rest.data.categories

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
)
