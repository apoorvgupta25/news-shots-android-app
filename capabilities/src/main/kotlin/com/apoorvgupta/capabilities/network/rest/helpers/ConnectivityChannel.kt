package com.apoorvgupta.capabilities.network.rest.helpers

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Object responsible for managing No internet states and publishing internet connection lost updates.
 *
 * @author Apoorv Gupta
 */
object ConnectivityChannel {

    private val connectionLost: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val isConnectionLost: StateFlow<Boolean> get() = connectionLost

    fun observer(): StateFlow<Boolean> = isConnectionLost

    fun publish(
        connectionLoss: Boolean,
    ) {
        connectionLost.value = connectionLoss
    }
}
