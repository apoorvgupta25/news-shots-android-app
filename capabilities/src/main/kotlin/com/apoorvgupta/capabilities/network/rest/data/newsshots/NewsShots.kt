package com.apoorvgupta.capabilities.network.rest.data.newsshots

import com.apoorvgupta.capabilities.network.rest.data.categories.Category
import com.apoorvgupta.capabilities.util.DateUtils.getDateFormatted
import com.apoorvgupta.core.utils.emptyValue
import com.apoorvgupta.core.utils.getValueOrEmpty
import com.apoorvgupta.draftjscompose.data.DraftJS
import com.google.gson.Gson
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

    val draftJSContent: DraftJS
        get() = Gson().fromJson(content, DraftJS::class.java)

    companion object {
        val emptyValue: NewsShots
            get() = NewsShots(
                id = String.emptyValue(),
                author = Author.emptyValue,
                category = Category.emptyValue,
                content = String.emptyValue(),
                createdAt = String.emptyValue(),
                description = String.emptyValue(),
                title = String.emptyValue(),
                link = String.emptyValue(),
            )
    }
}
