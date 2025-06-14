package com.apoorvgupta.draftjscompose.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * @author Apoorv Gupta
 */
object StyleUtils {

    val boldStyle: SpanStyle =
        SpanStyle(fontWeight = FontWeight.Bold)

    val italicStyle: SpanStyle =
        SpanStyle(fontStyle = FontStyle.Italic)

    val underlineStyle: SpanStyle =
        SpanStyle(textDecoration = TextDecoration.Underline)

    val strikeThroughStyle: SpanStyle =
        SpanStyle(textDecoration = TextDecoration.LineThrough)

    val superscriptStyle: SpanStyle =
        SpanStyle(baselineShift = BaselineShift.Superscript)

    val subscriptStyle: SpanStyle =
        SpanStyle(baselineShift = BaselineShift.Subscript)

    val monospaceStyle: SpanStyle = SpanStyle(
        fontFamily = FontFamily.Monospace,
    )

    fun getLinkAnnotation(url: String, linkTextColor: Color): LinkAnnotation.Url = LinkAnnotation.Url(
        url = url,
        styles = TextLinkStyles(style = SpanStyle(color = linkTextColor)),
    )

    fun getEmbeddedLinkAnnotation(url: String, linkTextColor: Color): LinkAnnotation.Url = LinkAnnotation.Url(
        url = url,
        styles = TextLinkStyles(
            style = SpanStyle(
                color = linkTextColor,
                textDecoration = TextDecoration.Underline,
            ),
        ),
    )

    fun getFontSizeStyle(style: String) = SpanStyle(
        fontSize = extractFontSize(style)?.sp ?: TextUnit.Unspecified,
    )

    fun getFontColorStyle(style: String): SpanStyle {
        val rgb = extractRgb(style) ?: return SpanStyle()

        return SpanStyle(
            color = Color(rgb.first, rgb.second, rgb.third),
        )
    }

    fun getBackgroundColorStyle(style: String): SpanStyle {
        val rgb = extractRgb(style) ?: return SpanStyle()

        return SpanStyle(
            background = Color(rgb.first, rgb.second, rgb.third),
        )
    }

    fun getFontFamilyStyle(style: String): SpanStyle {
        val fontFamily = extractFontFamily(style)

        return SpanStyle(
            fontFamily = when (fontFamily) {
                DraftJsConstants.FONT_FAMILY_SFUI -> FontFamily.SansSerif
                DraftJsConstants.FONT_FAMILY_GEORGIA -> FontFamily.Serif
                DraftJsConstants.FONT_FAMILY_INHERIT -> FontFamily.Cursive
                else -> FontFamily.Default
            },

        )
    }

    private fun extractFontSize(input: String): Int? {
        val regex = Regex("""${DraftJsConstants.FONT_SIZE}(\d+)""")
        return regex.find(input)?.groupValues?.get(1)?.toIntOrNull()
    }

    private fun extractRgb(input: String): Triple<Int, Int, Int>? {
        val regex = Regex("""${DraftJsConstants.RGB}\((\d+),\s*(\d+),\s*(\d+)\)""")
        val match = regex.find(input)
        return match?.groupValues?.let { groups ->
            val r = groups[1].toInt()
            val g = groups[2].toInt()
            val b = groups[3].toInt()
            Triple(r, g, b)
        }
    }

    private fun extractFontFamily(input: String): String? {
        val regex = Regex("""${DraftJsConstants.FONT_FAMILY}(\w+)""")
        return regex.find(input)?.groupValues?.get(1)
    }
}
