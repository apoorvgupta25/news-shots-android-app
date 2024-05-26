package com.apoorvgupta.capabilities.network.rest.data.model

import com.google.gson.annotations.SerializedName

data class NewsShots(
    @SerializedName("author")
    val author: Author,

    @SerializedName("category")
    val category: Category,

    @SerializedName("content")
    val content: String,

    @SerializedName("createdAt")
    val createdAt: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("link")
    val link: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("updatedAt")
    val updatedAt: String,
)
