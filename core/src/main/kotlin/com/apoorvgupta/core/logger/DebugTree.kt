/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */
package com.apoorvgupta.core.logger

import timber.log.Timber

/**
 * Internal implementation of Timber's DebugTree for logging debug messages.
 *
 * This class extends Timber's DebugTree and overrides the method to create a custom stack element tag.
 * The custom tag is generated using the Logger utility class.
 *
 * @see Timber.DebugTree
 * @see AppLogger.getTagFromElement
 *
 * @author Apoorv Gupta
 */
internal class DebugTree : Timber.DebugTree() {
    /**
     * Overrides the method to create a custom stack element tag using the Logger utility class.
     *
     * @param element The stack trace element for which the tag is generated.
     * @return The custom tag for the log message.
     */
    override fun createStackElementTag(element: StackTraceElement): String {
        return AppLogger.getTagFromElement(element)
    }
}
