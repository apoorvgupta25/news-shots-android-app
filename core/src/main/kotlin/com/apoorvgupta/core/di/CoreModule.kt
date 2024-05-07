/**
 * Copyright (c) 2024 Apoorv Gupta
 * All rights reserved.
 */

package com.apoorvgupta.core.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Dagger Hilt module for providing dependencies related to the core module.
 *
 * @author Apoorv Gupta
 */
@Module
@InstallIn(SingletonComponent::class)
class CoreModule
