/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.core.utils

// Constants
const val EMPTY_STRING = ""

/**
 * Returns an empty string value.
 */
fun String.Companion.emptyValue() = EMPTY_STRING

/**
 * Returns 0 Int value.
 */
fun Int.Companion.emptyValue() = 0

/**
 * Returns 0 Long value.
 */
fun Long.Companion.emptyValue() = 0.toLong()

/**
 * Returns 0 Float value.
 */
fun Float.Companion.emptyValue() = 0f

/**
 * Returns 0 Double value.
 */
fun Double.Companion.emptyValue() = 0.0

/**
 * Returns false Boolean value.
 */
fun Boolean.Companion.emptyValue() = false

/**
 * Returns Empty String value if null else return same value.
 */
fun String?.getValueOrEmpty() = this ?: EMPTY_STRING

/**
 * Returns 0 Int value if null else return same value.
 */
fun Int?.getValueOrEmpty() = this ?: 0

fun <T> List<T>?.getValueOrEmpty() = this ?: emptyList()
