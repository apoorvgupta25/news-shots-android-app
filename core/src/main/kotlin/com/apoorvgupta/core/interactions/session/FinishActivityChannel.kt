package com.apoorvgupta.core.interactions.session

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object FinishActivityChannel {

    private val finishActivityWhenTrue: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val finishActivityWithTrue: StateFlow<Boolean> get() = finishActivityWhenTrue

    fun observer(): StateFlow<Boolean> = finishActivityWithTrue

    fun publish(finishActivity: Boolean) {
        finishActivityWhenTrue.value = finishActivity
    }
}
