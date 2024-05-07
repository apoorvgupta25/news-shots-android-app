/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.reusableComponents.web

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsCallback
import androidx.browser.customtabs.CustomTabsClient
import androidx.browser.customtabs.CustomTabsIntent
import androidx.browser.customtabs.CustomTabsIntent.SHARE_STATE_OFF
import androidx.browser.customtabs.CustomTabsServiceConnection
import androidx.browser.customtabs.CustomTabsSession
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import com.apoorvgupta.capabilities.presentation.reusableComponents.loader.CircularProgressBarComponent
import com.apoorvgupta.capabilities.presentation.theme.primary
import com.apoorvgupta.core.logger.AppLogger
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

// Constants
var mClient: CustomTabsClient? = null
var mCustomTabsSession: CustomTabsSession? = null
var chromePackageName = "com.android.chrome"

const val PDF_EXTENSION = ".pdf"
const val GOOGLE_DOCS_URL = "https://docs.google.com/gview?embedded=true&url="

/**
 * Composable function that opens a URL in a Chrome Custom Tab.
 *
 * @author Apoorv Gupta
 */
@Composable
fun ChromeCustomTabWebView(url: String, onUrlLaunchedEvent: () -> Unit) {
    var showProgress by remember {
        mutableStateOf(true)
    }
    CircularProgressBarComponent(showProgress)
    val context = LocalContext.current
    val mCustomTabsServiceConnection: CustomTabsServiceConnection?
    mCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
        override fun onCustomTabsServiceConnected(
            componentName: ComponentName,
            customTabsClient: CustomTabsClient,
        ) {
            mClient = customTabsClient
            mClient!!.warmup(0)
            val callback = callback {
                showProgress = false
            }
            mCustomTabsSession = mClient!!.newSession(callback)
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mClient = null
        }
    }
    CustomTabsClient.bindCustomTabsService(
        context,
        chromePackageName,
        mCustomTabsServiceConnection,
    )

    val colorInt: Int = primary.toArgb()
    val defaultColors = CustomTabColorSchemeParams.Builder()
        .setToolbarColor(colorInt)
        .build()

    val customTabsIntent = CustomTabsIntent.Builder(mCustomTabsSession)
        .setShowTitle(true)
        .setDefaultColorSchemeParams(defaultColors)
        .setShareState(SHARE_STATE_OFF)
        .build()
    customTabsIntent.intent.setAction(Intent.ACTION_VIEW)
    customTabsIntent.intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    customTabsIntent.intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

    val decodedUrl = URLDecoder.decode(
        url,
        StandardCharsets.UTF_8.toString(),
    )
    if (decodedUrl.contains(PDF_EXTENSION)) {
        LaunchedEffect(Unit) {
            customTabsIntent.launchUrl(context, Uri.parse("$GOOGLE_DOCS_URL$url"))
            onUrlLaunchedEvent.invoke()
        }
    } else {
        LaunchedEffect(Unit) {
            customTabsIntent.launchUrl(context, Uri.parse(url))
            onUrlLaunchedEvent.invoke()
        }
    }
}

fun callback(onPageFinished: () -> Unit): CustomTabsCallback {
    val mCustomTabsCallback: CustomTabsCallback?
    mCustomTabsCallback = object : CustomTabsCallback() {
        override fun onNavigationEvent(navigationEvent: Int, extras: Bundle?) {
            super.onNavigationEvent(navigationEvent, extras)
            when (navigationEvent) {
                NAVIGATION_STARTED -> {
                    AppLogger.d("pageStarted", "starting...")
                }
                NAVIGATION_FINISHED -> {
                    onPageFinished()
                }
            }
        }
    }
    return mCustomTabsCallback
}
