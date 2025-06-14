package com.apoorvgupta.capabilities.network.rest.data.newsshots

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.util.DateUtils.getDateFormatted
import com.apoorvgupta.core.utils.EMPTY_STRING
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.google.gson.annotations.SerializedName

data class NewsShots(
    @SerializedName("_id")
    val id: String,

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
    val updatedAt: String? = null,
) {
    val formattedDate: String
        get() = getDateFormatted(createdAt.getValueOrEmpty())

    companion object {
        val emptyValue: NewsShots
            get() = NewsShots(
                id = EMPTY_STRING,
                author = Author.emptyValue,
                category = Category.emptyValue,
                content = EMPTY_STRING,
                createdAt = EMPTY_STRING,
                description = EMPTY_STRING,
                title = EMPTY_STRING,
                link = EMPTY_STRING,
            )
    }
}
