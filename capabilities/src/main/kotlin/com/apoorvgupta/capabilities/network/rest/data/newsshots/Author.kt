package com.apoorvgupta.capabilities.network.rest.data.newsshots

import com.apoorvgupta.core.utils.EMPTY_STRING
import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("name")
    val name: String,
) {
    companion object {
        val emptyValue: Author
            get() = Author(
                name = EMPTY_STRING,
            )
    }
}
