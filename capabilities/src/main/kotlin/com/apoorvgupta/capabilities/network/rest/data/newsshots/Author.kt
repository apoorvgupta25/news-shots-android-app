package com.apoorvgupta.capabilities.network.rest.data.newsshots

import com.apoorvgupta.core.utils.emptyValue
import com.google.gson.annotations.SerializedName

data class Author(
    @SerializedName("name")
    val name: String,
) {
    companion object {
        val emptyValue: Author
            get() = Author(
                name = String.emptyValue(),
            )
    }
}
