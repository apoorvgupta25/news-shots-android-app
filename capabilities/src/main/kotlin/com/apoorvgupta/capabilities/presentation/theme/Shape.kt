/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes

/**
 * Shapes for defining corner shapes
 *
 * @author Apoorv Gupta
 */

val Shapes =
    Shapes(
        // Small rounded corner shape with 4.dp radius
        small = RoundedCornerShape(Dimensions.CornerRadius.xs_corner_radius),
        // Medium rounded corner shape with 4.dp radius
        medium = RoundedCornerShape(Dimensions.CornerRadius.xs_corner_radius),
        // Large rounded corner shape with 0.dp radius (no rounding)
        large = RoundedCornerShape(Dimensions.CornerRadius.zero_corner_radius),
    )
