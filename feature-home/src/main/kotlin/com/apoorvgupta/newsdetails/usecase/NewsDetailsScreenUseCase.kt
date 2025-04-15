package com.apoorvgupta.newsdetails.usecase

import com.apoorvgupta.newsdetails.models.NewsDetailsDataModel
import kotlinx.coroutines.flow.Flow

/**
 * @author Apoorv Gupta
 */

fun interface NewsDetailsScreenUseCase {
    fun getNewsDetailsContentData(postLink: String): Flow<NewsDetailsDataModel>
}