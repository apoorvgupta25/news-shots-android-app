package com.apoorvgupta.capabilities.network.rest.data.model

import com.google.gson.annotations.SerializedName

data class Category(

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("updatedAt")
    val updatedAt: String
)