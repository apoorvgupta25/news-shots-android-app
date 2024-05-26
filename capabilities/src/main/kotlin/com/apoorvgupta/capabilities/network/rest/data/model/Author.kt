package com.apoorvgupta.capabilities.network.rest.data.model

import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("name")
    val name: String
)