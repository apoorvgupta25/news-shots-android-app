/**
 * Copyright (c) 2025 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.capabilities.presentation.theme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Use density pixel values across the app using below defined spacing constants
 *
 * @author Apoorv Gupta
 */
object Dimensions {
    private val zero_internal_spacing = 0.dp
    private val quarter_internal_spacing = 2.dp
    private val half_internal_spacing = 4.dp
    private val monuple_internal_spacing = 8.dp
    private val monuple_medium_internal_spacing = 10.dp
    private val monuple_large_internal_spacing = 12.dp
    private val couple_internal_spacing = 16.dp
    private val couple_large_internal_spacing = 20.dp
    private val triple_internal_spacing = 24.dp
    private val triple_large_internal_spacing = 28.dp
    private val quadruple_internal_spacing = 32.dp
    private val quadruple_medium_internal_spacing = 36.dp
    private val quintuple_internal_spacing = 40.dp
    private val sextuple_internal_spacing = 48.dp
    private val quinquagintuple_internal_spacing = 52.dp
    private val septuple_internal_spacing = 56.dp
    private val octuple_internal_spacing = 64.dp
    private val nonuple_internal_spacing = 72.dp
    private val decuple_internal_spacing = 80.dp
    private val undecuple_internal_spacing = 88.dp
    private val duodecuple_internal_spacing = 96.dp
    private val tredecuple_internal_spacing = 104.dp
    private val quattuordecuple_internal_spacing = 112.dp
    private val quindecuple_internal_spacing = 120.dp
    private val sexdecuple_internal_spacing = 128.dp
    private val septendecuple_internal_spacing = 136.dp
    private val octodecuple_internal_spacing = 144.dp
    private val novemdecuple_internal_spacing = 152.dp
    private val vigintuple_internal_spacing = 160.dp
    private val unvigintuple_internal_spacing = 168.dp
    private val duovigintuple_internal_spacing = 176.dp
    private val trevigintuple_internal_spacing = 184.dp
    private val quattuorvigintuple_internal_spacing = 192.dp
    private val quinvigintuple_internal_spacing = 200.dp
    private val trigintuple_internal_spacing = 232.dp
    private val xquinvigintuple_internal_spacing = 240.dp
    private val ruinvigintuple_internal_spacing = 250.dp
    private val xruinvigintuple_internal_spacing = 284.dp
    private val yruinvigintuple_internal_spacing = 343.dp

    // Horizontal spacing
    // Units of measurements to be used for marginStart, marginLeft, marginEnd, marginRight,
    // paddingStart, paddingLeft, paddingEnd, paddingRight only.
    object HorizonalDimensions {
        val zero_horizontal_spacing = zero_internal_spacing
        val xxs_horizontal_spacing = quarter_internal_spacing
        val xs_horizontal_spacing = half_internal_spacing
        val s_horizontal_spacing = monuple_internal_spacing
        val sm_horizontal_spacing = monuple_medium_internal_spacing
        val sl_horizontal_spacing = monuple_large_internal_spacing
        val m_horizontal_spacing = couple_internal_spacing
        val ml_horizontal_spacing = couple_large_internal_spacing
        val l_horizontal_spacing = triple_internal_spacing
        val ll_horizontal_spacing = triple_large_internal_spacing
        val xl_horizontal_spacing = quadruple_internal_spacing
        val xml_horizontal_spacing = quadruple_medium_internal_spacing
        val xxl_horizontal_spacing = quintuple_internal_spacing
        val xxxl_horizontal_spacing = sextuple_internal_spacing
        val xl4_horizontal_spacing = septuple_internal_spacing
        val xl5_horizontal_spacing = octuple_internal_spacing
        val xl6_horizontal_spacing = nonuple_internal_spacing
        val xl7_horizontal_spacing = decuple_internal_spacing
        val xl8_horizontal_spacing = undecuple_internal_spacing
        val xl9_horizontal_spacing = duodecuple_internal_spacing
        val xl10_horizontal_spacing = tredecuple_internal_spacing
        val xl11_horizontal_spacing = quattuordecuple_internal_spacing
        val xl12_horizontal_spacing = quindecuple_internal_spacing
        val xl13_horizontal_spacing = sexdecuple_internal_spacing
        val xl14_horizontal_spacing = septendecuple_internal_spacing
        val xl15_horizontal_spacing = octodecuple_internal_spacing
        val xl17_horizontal_spacing = vigintuple_internal_spacing
        val xl18_horizontal_spacing = unvigintuple_internal_spacing
        val xl19_horizontal_spacing = duovigintuple_internal_spacing
        val xl20_horizontal_spacing = xruinvigintuple_internal_spacing
        val xl21_horizontal_spacing = quattuorvigintuple_internal_spacing
        val xl50_horizontal_spacing = quinquagintuple_internal_spacing
    }

    // Vertical spacing
    // Units of measurements to be used for marginTop, marginBottom, paddingTop, paddingBottom only.
    object VerticalDimensions {
        val zero_vertical_spacing = zero_internal_spacing
        val xxs_vertical_spacing = quarter_internal_spacing
        val xs_vertical_spacing = half_internal_spacing
        val s_vertical_spacing = monuple_internal_spacing
        val sm_vertical_spacing = monuple_medium_internal_spacing
        val sl_vertical_spacing = monuple_large_internal_spacing
        val m_vertical_spacing = couple_internal_spacing
        val ml_vertical_spacing = couple_large_internal_spacing
        val l_vertical_spacing = triple_internal_spacing
        val ll_vertical_spacing = triple_large_internal_spacing
        val xl_vertical_spacing = quadruple_internal_spacing
        val xml_vertical_spacing = quadruple_medium_internal_spacing
        val xxl_vertical_spacing = quintuple_internal_spacing
        val xxxl_vertical_spacing = sextuple_internal_spacing
        val xl4_vertical_spacing = septuple_internal_spacing
        val xl5_vertical_spacing = octuple_internal_spacing
        val xl6_vertical_spacing = nonuple_internal_spacing
        val xl7_vertical_spacing = decuple_internal_spacing
        val xl8_vertical_spacing = undecuple_internal_spacing
        val xl9_vertical_spacing = duodecuple_internal_spacing
        val xl10_vertical_spacing = tredecuple_internal_spacing
        val xl11_vertical_spacing = quattuordecuple_internal_spacing
        val xl12_vertical_spacing = quindecuple_internal_spacing
        val xl13_vertical_spacing = sexdecuple_internal_spacing
        val xl14_vertical_spacing = septendecuple_internal_spacing
        val xl15_vertical_spacing = octodecuple_internal_spacing
        val xl16_vertical_spacing = novemdecuple_internal_spacing
        val xl17_vertical_spacing = vigintuple_internal_spacing
        val xl18_vertical_spacing = unvigintuple_internal_spacing
        val xl19_vertical_spacing = duovigintuple_internal_spacing
        val xl20_vertical_spacing = trevigintuple_internal_spacing
        val xl21_vertical_spacing = quattuorvigintuple_internal_spacing
        val xl22_vertical_spacing = ruinvigintuple_internal_spacing
        val xl23_vertical_spacing = trigintuple_internal_spacing
        val xl24_vertical_spacing = xquinvigintuple_internal_spacing
        val xl25_vertical_spacing = quinvigintuple_internal_spacing
        val xl26_vertical_spacing = yruinvigintuple_internal_spacing
        val xl50_vertical_spacing = quinquagintuple_internal_spacing
    }

    // Surrounding Spacings:
    // Units of measurements to be used for padding and margin attributes only.
    object SurroundingDimensions {
        val zero_surrounding_spacing = zero_internal_spacing
        val xxs_surrounding_spacing = quarter_internal_spacing
        val xs_surrounding_spacing = half_internal_spacing
        val s_surrounding_spacing = monuple_internal_spacing
        val sm_surrounding_spacing = monuple_medium_internal_spacing
        val sl_surrounding_spacing = monuple_large_internal_spacing
        val m_surrounding_spacing = couple_internal_spacing
        val ml_surrounding_spacing = couple_large_internal_spacing
        val l_surrounding_spacing = triple_internal_spacing
        val ll_surrounding_spacing = triple_large_internal_spacing
        val xl_surrounding_spacing = quadruple_internal_spacing
        val xxl_surrounding_spacing = quintuple_internal_spacing
        val xxxl_surrounding_spacing = sextuple_internal_spacing
        val xl4_surrounding_spacing = septuple_internal_spacing
        val xl5_surrounding_spacing = octuple_internal_spacing
        val xl15_surrounding_spacing = octodecuple_internal_spacing
        val xl16_surrounding_spacing = novemdecuple_internal_spacing
    }

    // Text size
    object TextSize {
        val text_size_title_medium = 18.sp
    }

    object LineHeight {
        val line_height_body = 20.sp
    }

    object LetterSpacing {
        val letter_spacing_xxxs = 0.4.sp
    }

    // Corner radius
    object CornerRadius {
        val zero_corner_radius = zero_internal_spacing
        val xxs_corner_radius = quarter_internal_spacing
        val xs_corner_radius = half_internal_spacing
        val s_corner_radius = monuple_internal_spacing
        val sm_corner_radius = monuple_medium_internal_spacing
        val sl_corner_radius = monuple_large_internal_spacing
        val m_corner_radius = couple_internal_spacing
        val ml_corner_radius = couple_large_internal_spacing
        val l_corner_radius = triple_internal_spacing
        val ll_corner_radius = triple_large_internal_spacing
        val xl_corner_radius = quadruple_internal_spacing
        val xml_corner_radius = quadruple_medium_internal_spacing
        val xxl_corner_radius = quintuple_internal_spacing
    }

    // Stroke width
    object StrokeWidth {
        val xxxs_stroke_width = 1.dp // quarter_internal_spacing
        val xxs_stroke_width = quarter_internal_spacing
        val xs_stroke_width = half_internal_spacing
        val s_stroke_width = monuple_internal_spacing
        val sm_stroke_width = monuple_medium_internal_spacing
        val sl_stroke_width = monuple_large_internal_spacing
        val m_stroke_width = couple_internal_spacing
        val ml_stroke_width = couple_large_internal_spacing
        val l_stroke_width = triple_internal_spacing
        val ll_stroke_width = triple_large_internal_spacing
        val xl_stroke_width = quadruple_internal_spacing
        val xml_stroke_width = quadruple_medium_internal_spacing
        val xxl_stroke_width = quintuple_internal_spacing
    }

    // Icon size

    object IconSize {
        val xxs_icon_size = quarter_internal_spacing
        val xs_icon_size = half_internal_spacing
        val s_icon_size = monuple_internal_spacing
        val sm_icon_size = monuple_medium_internal_spacing
        val sl_icon_size = monuple_large_internal_spacing
        val m_icon_size = couple_internal_spacing
        val ml_icon_size = couple_large_internal_spacing
        val l_icon_size = triple_internal_spacing
        val ll_icon_size = triple_large_internal_spacing
        val xl_icon_size = quadruple_internal_spacing
        val xml_icon_size = quadruple_medium_internal_spacing
        val xxl_icon_size = quintuple_internal_spacing
        val xxxl_icon_size = sextuple_internal_spacing
    }
}