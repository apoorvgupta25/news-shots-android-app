package com.apoorvgupta.capabilities.presentation.shimmer

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

/**
 * A provider for generating shimmer effects in Jetpack Compose.
 *
 * @author Apoorv Gupta
 */
object ShimmerProvider {
    const val ANIM_DURATION = 1200
    private val colorShimmer = Color(0xFFE1E0E0)
    private val shimmerColorShade = listOf(
        colorShimmer.copy(0.9f),
        colorShimmer.copy(0.2f),
        colorShimmer.copy(0.9f),
    )

    /**
     * Get a rectangular shimmer effect.
     *
     * @param modifier The modifier for the rectangular shimmer.
     * @param colors The list of colors for the shimmer effect.
     */
    @Composable
    fun GetRectangularShimmer(
        modifier: Modifier = Modifier,
        colors: List<Color> = shimmerColorShade,
    ) {
        RenderShimmer(modifier, RectangleShape, colors)
    }

    /**
     * Get a circular shimmer effect.
     *
     * @param modifier The modifier for the circular shimmer.
     * @param colors The list of colors for the shimmer effect.
     */
    @Composable
    fun GetCircularShimmer(modifier: Modifier = Modifier, colors: List<Color> = shimmerColorShade) {
        RenderShimmer(modifier, CircleShape, colors)
    }

    /**
     * Get a rounded corner shimmer effect.
     *
     * @param modifier The modifier for the rounded corner shimmer.
     * @param colors The list of colors for the shimmer effect.
     * @param cornerRadius The corner radius for the rounded corners.
     */
    @Composable
    fun GetRoundedCornerShimmer(
        modifier: Modifier = Modifier,
        colors: List<Color> = shimmerColorShade,
        cornerRadius: Int,
    ) {
        RenderShimmer(modifier, RoundedCornerShape(cornerRadius.dp), colors)
    }
}

/**
 * Render a shimmer effect.
 *
 * @param modifier The modifier for the shimmer.
 * @param shape The shape of the shimmer.
 * @param colors The list of colors for the shimmer effect.
 * @param repeatMode The repeat mode for the animation.
 */
@Composable
fun RenderShimmer(
    modifier: Modifier,
    shape: Shape,
    colors: List<Color>,
    repeatMode: RepeatMode = RepeatMode.Reverse,
) {
    val transition = rememberInfiniteTransition(label = "")
    val translateAnim by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f, // Adjust the target value to cover the entire width or height of the Box
        animationSpec = infiniteRepeatable(
            tween(durationMillis = ShimmerProvider.ANIM_DURATION, easing = FastOutSlowInEasing),
            repeatMode,
        ),
        label = "",
    )

    val brush = Brush.linearGradient(
        colors = colors,
        start = Offset(10f, 10f),
        end = Offset(translateAnim * 1000f, translateAnim * 1000f), // Use *1000 or any value that suits your design
    )
    Box(
        modifier = modifier
            .clip(shape)
            .background(brush),
    )
}
