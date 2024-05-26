/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.core.logger

import android.util.Log.ASSERT
import android.util.Log.DEBUG
import android.util.Log.ERROR
import android.util.Log.INFO
import android.util.Log.VERBOSE
import android.util.Log.WARN
import timber.log.Timber

/**
 * Logger provides a simple logging mechanism for tracking events
 * and debugging information in the application.
 *
 * @author Apoorv Gupta
 */
object AppLogger {
    private val loggerClassName = this::class.java.name
    private const val MAX_TAG_LENGTH = 23

    /**
     * Enable logs for build variant
     * Do not use Logger in release variant
     */
    fun enableLogging() {
        Timber.plant(DebugTree())
        // Logging a message to display that logging is enabled
        d { "Logger is enabled" }
    }

    /**
     * Clears all debugging trees previously planted
     * and disables logs
     */
    fun disableLogging() {
        // Logging a message to display that logging is enabled
        d { "Logger is disabled" }
        Timber.uprootAll()
    }

    /**
     * Executes a log message block if trees planted in the timber forest
     * @param block() a logging function/lambda to invoke
     */
    private fun log(block: () -> Unit) {
        if (Timber.treeCount > 0) block()
    }

    /**
     * Creates a tag if found from the callers class name
     * obtained from the stacktrace
     * Tree should be planted to get tag created
     * otherwise it will return the input param as default
     * @param tag default tag name
     * @return tag created from the stackTrace
     */
    private fun getTagName(tag: String = ""): String {
        if (Timber.treeCount > 0) {
            return Throwable().stackTrace
                .first { isNotLoggerClass(it.className) }
                .let(AppLogger::getTagFromElement)
        }
        return tag
    }

    /**
     * Checks if the @param className and logger class are same
     * @param className to check
     * @return true if both are different false otherwise
     */
    private fun isNotLoggerClass(className: String): Boolean {
        return when {
            className.length == loggerClassName.length -> {
                className != loggerClassName
            }

            className.length >= loggerClassName.length -> {
                className.subSequence(loggerClassName.indices) != loggerClassName
            }

            else -> true
        }
    }

    /**
     * Get the tag from the StackTraceElement
     * Limit the tag length as per android API level
     * @param element StackTraceElement with details about the callers class
     * @return tag created from the input param with appropriate length
     * For below API 26 there is a length limit for tags
     */
    internal fun getTagFromElement(element: StackTraceElement): String {
        val tag = "(${element.fileName}:${element.lineNumber}) :${element.methodName}"
        // Tag length limit was removed in API 26.
        return if (tag.length <= MAX_TAG_LENGTH) {
            tag
        } else {
            tag.substring(0, MAX_TAG_LENGTH)
        }
    }

    /**
     * Logs a debug message using a lambda function.
     */
    fun d(message: () -> String) {
        log { Timber.tag(getTagName()).d(message()) }
    }

    /**
     * Logs a debug message using Timber with optional tag, message, and throwable.
     */
    fun d(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        log { Timber.tag(tag).d(throwable, message()) }
    }

    /**
     * Logs a error message using Timber with optional tag, message, and throwable.
     */
    fun e(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        log { Timber.tag(tag).e(throwable, message()) }
    }

    /**
     * Logs a info message using Timber with optional tag, message, and throwable.
     */
    fun i(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        log { Timber.tag(tag).i(throwable, message()) }
    }

    /**
     * Logs a verbose message using Timber with optional tag, message, and throwable.
     */
    fun v(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        log { Timber.tag(tag).v(throwable, message()) }
    }

    /**
     * Logs a warn message using Timber with optional tag, message, and throwable.
     */
    fun w(
        tag: String = getTagName(),
        message: () -> String,
        throwable: Throwable? = null,
    ) {
        log { Timber.tag(tag).w(throwable, message()) }
    }

    /**
     * Triggers Timber logging based on the specified priority, tag, and message with optional arguments.
     */
    private fun triggerLogger(
        priority: Int,
        tag: String,
        message: String,
        vararg args: Any,
    ) {
        when (priority) {
            ASSERT -> {
                log { Timber.tag(tag).wtf(message = message, args = args) }
            }

            DEBUG -> {
                log { Timber.tag(tag).d(message = message, args = args) }
            }

            ERROR -> {
                log { Timber.tag(tag).e(message = message, args = args) }
            }

            INFO -> {
                log { Timber.tag(tag).i(message = message, args = args) }
            }

            VERBOSE -> {
                log { Timber.tag(tag).v(message = message, args = args) }
            }

            WARN -> {
                log { Timber.tag(tag).w(message = message, args = args) }
            }
        }
    }

    /** Log an verbose message with optional format args.  */
    fun v(
        tag: String,
        message: String,
        vararg args: Any,
    ) {
        triggerLogger(VERBOSE, tag, message, *args)
    }

    /** Log an debug message with optional format args.  */
    fun d(
        tag: String,
        message: String,
        vararg args: Any,
    ) {
        triggerLogger(DEBUG, tag, message, *args)
    }

    /** Log an warn message with optional format args.  */
    fun w(
        tag: String,
        message: String,
        vararg args: Any,
    ) {
        triggerLogger(WARN, tag, message, *args)
    }

    /** Log an error message with optional format args.  */
    fun e(
        tag: String,
        message: String,
        vararg args: Any,
    ) {
        triggerLogger(ERROR, tag, message, *args)
    }

    /** Log an info message with optional format args.  */
    fun i(
        tag: String,
        message: String,
        vararg args: Any,
    ) {
        triggerLogger(INFO, tag, message, *args)
    }

    /** Log an wtf message with optional format args.  */
    fun wtf(
        tag: String,
        message: String,
        vararg args: Any,
    ) {
        triggerLogger(ASSERT, tag, message, *args)
    }
}
