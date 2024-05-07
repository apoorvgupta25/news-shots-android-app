package com.apoorvgupta.capabilities.presentation.reusableComponents.web

import android.annotation.SuppressLint
import android.content.Intent
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.apoorvgupta.capabilities.presentation.theme.m_surrounding_spacing
import com.apoorvgupta.capabilities.presentation.theme.whiteColor
import com.apoorvgupta.capabilities.presentation.theme.xl_surrounding_spacing
import com.apoorvgupta.core.utils.EMPTY_STRING
import com.google.accompanist.web.AccompanistWebChromeClient
import com.google.accompanist.web.AccompanistWebViewClient
import com.google.accompanist.web.LoadingState
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun NativeWebView(
    url: String,
    onClose: () -> Unit,
) {
    var webUrl = url
    var pageTitle by remember {
        mutableStateOf(EMPTY_STRING)
    }
    var webViewInitialLoadingIndicator by remember {
        mutableStateOf(true)
    }

    if (webUrl.contains(PDF_EXTENSION)) {
        webUrl = "$GOOGLE_DOCS_URL$webUrl"
    }

    val state = rememberWebViewState(
        url = webUrl,
    )

    val loadingState = state.loadingState
    if (loadingState is LoadingState.Finished) {
        webViewInitialLoadingIndicator = false
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Column {
            WebTopAppBar(text = pageTitle) {
                onClose()
            }
            val webClient = remember {
                object : AccompanistWebChromeClient() {
                    override fun onReceivedTitle(view: WebView?, title: String?) {
                        if (title != null) {
                            pageTitle = title
                        }
                        super.onReceivedTitle(view, title)
                    }
                }
            }
            val context = LocalContext.current
            WebView(
                modifier = Modifier.weight(1f),
                state = state,
                client = object : AccompanistWebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?,
                    ): Boolean {
                        val url = request?.url ?: return false
                        if (url.toString().startsWith("mailto")
                                .or(url.toString().startsWith("sms"))
                                .or(url.toString().startsWith("whatsapp"))
                                .or(url.toString().startsWith("fb-messenger"))
                        ) {
                            url.let {
                                val intent = Intent(Intent.ACTION_VIEW, request.url)
                                // Check if there is an app that can handle the intent
                                if (intent.resolveActivity(context.packageManager) != null) {
                                    context.startActivity(intent)
                                    return true
                                } else {
                                    // Show alert
                                    if (url.toString().startsWith("whatsapp").not()) {
                                        Toast.makeText(
                                            context,
                                            "App not found. Please install to share, or use an alternate share method.",
                                            Toast.LENGTH_LONG,
                                        ).show()
                                    }
                                    return true
                                }
                            }
                        }
                        return false
                    }
                },
                onCreated = { webView ->
                    webView.settings.javaScriptEnabled = true
                    webView.settings.domStorageEnabled = true
                    webView.settings.javaScriptCanOpenWindowsAutomatically = true
                },
                chromeClient = webClient,
            ).apply {
            }
        }
    }
    AnimatedVisibility(
        visible = webViewInitialLoadingIndicator,
        enter = fadeIn(animationSpec = tween()),
        exit = fadeOut(
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 2000,
                easing = FastOutLinearInEasing,
            ),
        ),
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .background(Color.Gray),
        ) {
            Column {
                WebTopAppBar(text = pageTitle) {
                    onClose()
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .pointerInput(Unit) {},
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    CircularProgressIndicator(
                        color = Color.White,
                    )
                }
            }
        }
    }
}

@Composable
private fun WebTopAppBar(
    text: String,
    onCloseWebView: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        BackButton {
            onCloseWebView.invoke()
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            maxLines = 2,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.whiteColor,
    onClickListener: () -> Unit,
) {
    IconButton(
        onClick = {
            onClickListener.invoke()
        },
        modifier = Modifier.size(xl_surrounding_spacing),
    ) {
        Box(
            modifier = modifier
                .background(color = backgroundColor)
                .size(xl_surrounding_spacing)
                .clip(RoundedCornerShape(m_surrounding_spacing)),
        ) {
        }
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier.size(m_surrounding_spacing),
        )
    }
}
