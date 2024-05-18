package com.apoorvgupta.home.models.refreshdata

import com.google.gson.annotations.SerializedName

/**
 * @author Apoorv Gupta
 */
data class RefreshDataResponse(

    @SerializedName("Code")
    val code: String? = null,

    @SerializedName("Message")
    val message: String? = null,

    @SerializedName("Data")
    val data: RefreshData? = null,
)
