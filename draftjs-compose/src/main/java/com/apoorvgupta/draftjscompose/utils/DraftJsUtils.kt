package com.apoorvgupta.draftjscompose.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import com.apoorvgupta.draftjscompose.data.DraftJS

/**
 * @author Apoorv Gupta
 */

object DraftJsUtils {
    const val EMPTY_STRING = ""

    fun String.Companion.emptyValue() = EMPTY_STRING

    fun Int.Companion.emptyValue() = 0

    fun parseDraftJsContent(draftJSContent: DraftJS, linkTextColor: Color): AnnotatedString {
        val builder = AnnotatedString.Builder()

        draftJSContent.blocks.forEach { block ->
            val text = block.text
            val styles = block.inlineStyleRanges
            val entityRanges = block.entityRanges

            val styleSpans = mutableListOf<Triple<IntRange, String, String>>()

            styles.forEach {
                val start = it.offset
                val end = start + it.length
                val style = it.style
                styleSpans.add(
                    Triple(
                        first = start until (end + 1),
                        second = style,
                        third = String.emptyValue(),
                    ),
                )
            }

            entityRanges.forEach {
                val start = it.offset
                val end = start + it.length
                val entity = draftJSContent.entityMap[it.key.toString()]

                if (entity != null) {
                    styleSpans.add(
                        Triple(
                            first = start until (end + 1),
                            second = entity.type,
                            third = entity.data.url,
                        ),
                    )
                }
            }

            builder.append(buildAnnotatedSegment(text, styleSpans, linkTextColor))
            builder.append("\n")
        }

        return builder.toAnnotatedString()
    }

    private fun buildAnnotatedSegment(
        text: String,
        styles: List<Triple<IntRange, String, String>>,
        linkTextColor: Color,
    ): AnnotatedString {
        val builder = AnnotatedString.Builder(text)
        styles.forEach { (range, style, url) ->

            when (style) {
                // InLine Styles
                DraftJsConstants.BOLD ->
                    builder.addStyle(
                        style = StyleUtils.boldStyle,
                        start = range.first,
                        end = range.last,
                    )

                DraftJsConstants.ITALIC ->
                    builder.addStyle(
                        style = StyleUtils.italicStyle,
                        start = range.first,
                        end = range.last,
                    )

                DraftJsConstants.UNDERLINE ->
                    builder.addStyle(
                        style = StyleUtils.underlineStyle,
                        start = range.first,
                        end = range.last,
                    )

                DraftJsConstants.STRIKETHROUGH ->
                    builder.addStyle(
                        style = StyleUtils.strikeThroughStyle,
                        start = range.first,
                        end = range.last,
                    )

                DraftJsConstants.SUBSCRIPT ->
                    builder.addStyle(
                        style = StyleUtils.subscriptStyle,
                        start = range.first,
                        end = range.last,
                    )

                DraftJsConstants.SUPERSCRIPT ->
                    builder.addStyle(
                        style = StyleUtils.superscriptStyle,
                        start = range.first,
                        end = range.last,
                    )

                DraftJsConstants.MONOSPACE ->
                    builder.addStyle(
                        style = StyleUtils.monospaceStyle,
                        start = range.first,
                        end = range.last,
                    )

                // Entity Styles
                DraftJsConstants.LINK ->
                    builder.addLink(
                        url = StyleUtils.getLinkAnnotation(url, linkTextColor),
                        start = range.first,
                        end = range.last,
                    )

                DraftJsConstants.EMBEDDED_LINK ->
                    builder.addLink(
                        url = StyleUtils.getEmbeddedLinkAnnotation(url, linkTextColor),
                        start = range.first,
                        end = range.last,
                    )

                else -> {
                    when {
                        style.startsWith(DraftJsConstants.COLOR_RGB) -> {
                            builder.addStyle(
                                style = StyleUtils.getFontColorStyle(style),
                                start = range.first,
                                end = range.last,
                            )
                        }

                        /*
                        style.startsWith(DraftJsConstants.BGCOLOR_RGB) -> {
                            builder.addStyle(
                                style = StyleUtils.getBackgroundColorStyle(style),
                                start = range.first,
                                end = range.last
                            )
                        }

                        style.startsWith(DraftJsConstants.FONT_SIZE) -> {
                            builder.addStyle(
                                style = StyleUtils.getFontSizeStyle(style),
                                start = range.first,
                                end = range.last,
                            )
                        }

                        style.startsWith(DraftJsConstants.FONT_FAMILY) -> {
                            builder.addStyle(
                                style = StyleUtils.getFontFamilyStyle(style),
                                start = range.first,
                                end = range.last
                            )
                        }
                         */
                    }
                }
            }
        }

        return builder.toAnnotatedString()
    }
}
