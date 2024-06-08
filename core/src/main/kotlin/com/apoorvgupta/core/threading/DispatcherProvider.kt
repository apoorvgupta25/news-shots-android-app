package com.apoorvgupta.core.threading

import kotlin.coroutines.CoroutineContext

/**
 * Dispatcher provider
 *
 * @constructor Create empty Dispatcher provider
 *
 * @author Apoorv Gupta
 */
interface DispatcherProvider {
    val main: CoroutineContext
    val io: CoroutineContext
    val default: CoroutineContext
}
