package com.apoorvgupta.core.interactions.activityProvider

import android.app.Activity

/**
 * Interface defining method for getting activity instance.
 *
 * @author Apoorv Gupta
 */
interface ActivityProvider {

    fun getActivity(): Activity
}
