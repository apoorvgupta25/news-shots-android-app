/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * This is the interface for the view state.
 */
interface ViewState

/**
 * This is the interface for the user intent.
 */
interface UserIntent

/**
 * This is the interface for the navigation effect.
 */
interface NavEffect

/**
 * This is the Base view model implementing the MVI (Model-View-Intent) architecture.
 * @param Intent: The user intent that triggers changes in the view model.
 * @param State: The view state representing the current state of the UI.
 * @param Effect: The navigation effect representing UI-related side effects.
 *
 * @author Apoorv Gupta
 */
abstract class BaseViewModel<Intent : UserIntent, State : ViewState, Effect : NavEffect> :
    ViewModel() {
    // Create the initial state of the view.
    private val initialState: State by lazy { createInitialState() }

    abstract fun createInitialState(): State

    // Get the current state.
    val currentState: State
        get() = viewState.value

    // MutableStateFlow to hold the current view state.
    private val _viewState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val viewState
        get() = _viewState.asStateFlow()

    // MutableSharedFlow to handle user intents.
    private val _intent: MutableSharedFlow<Intent> = MutableSharedFlow()
    val intent
        get() = _intent.asSharedFlow()

    // Channel to handle navigation effects.
    private val _effect: Channel<Effect> = Channel()
    val effect
        get() = _effect.receiveAsFlow()

    init {
        // Start listening to the user intents.
        subscribeIntent()
    }

    /**
     * Start listening to the user intent flow.
     */
    private fun subscribeIntent() {
        viewModelScope.launch {
            intent.collect {
                handleIntent(it)
            }
        }
    }

    /**
     * Handle each user intent.
     * @param intent: The user's intent that triggers changes in the view model.
     */
    abstract fun handleIntent(intent: Intent)

    /**
     * Set a new user intent to trigger a change in the view model.
     * @param intent: The user's intent.
     */
    fun performAction(intent: Intent) {
        val newUserIntent = intent
        viewModelScope.launch { _intent.emit(newUserIntent) }
    }

    /**
     * Emit a new view state by applying a reduction function to the current state.
     * @param reduce: The reduction function that defines how to derive the new state.
     */
    protected fun emitViewState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _viewState.value = newState
    }

    /**
     * Set a new navigation effect to trigger UI-related side effects.
     * @param builder: A lambda function that constructs the navigation effect.
     */
    protected fun sendNavEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch { _effect.send(effectValue) }
    }
}
