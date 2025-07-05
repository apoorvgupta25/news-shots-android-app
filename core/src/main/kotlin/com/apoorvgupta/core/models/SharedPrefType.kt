/*
 * Copyright (c) 2025 Apoorv Gupta.
 *  All rights reserved.
 */
package com.apoorvgupta.core.models

/**
 * Enum class representing different types of shared preferences.
 * This enum is designed to categorize shared preferences based on their security level.
 *
 * @property SecuredSharedPref Represents a secured/shared preferences with enhanced security features.
 * @property NormalSharedPref Represents a normal/shared preferences without additional security measures.
 *
 * @see com.apoorvgupta.core.sharedpref.SharedPref
 * @see SecuredSharedPref
 * @see NormalSharedPref
 *
 * @author Apoorv Gupta
 */
enum class SharedPrefType {
    SecuredSharedPref,
    NormalSharedPref,
}
