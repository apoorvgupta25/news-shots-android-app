/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

/**
 * Shapes for defining corner shapes
 *
 * @author Apoorv Gupta
 */

val Shapes =
    Shapes(
        // Small rounded corner shape with 4.dp radius
        small = RoundedCornerShape(4.dp),
        // Medium rounded corner shape with 4.dp radius
        medium = RoundedCornerShape(4.dp),
        // Large rounded corner shape with 0.dp radius (no rounding)
        large = RoundedCornerShape(0.dp),
    )
