package com.apoorvgupta.capabilities.imageCaching

import android.content.Context
import com.bumptech.glide.Glide
import java.io.File
import javax.inject.Inject

class DiskCacheRepository @Inject constructor(
    private val context: Context,
) {

    fun clearDiskCache() {
        File(context.cacheDir, "code_cache").deleteRecursively()
        Glide.get(context).clearDiskCache()
    }
}
