package com.apoorvgupta.capabilities.util

import com.apoorvgupta.core.utils.EMPTY_STRING
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Locale

object DateUtils {
    private const val API_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    private const val DATE_FORMAT = "MMM d, yyyy"
    private const val API_TIME_FORMAT = "HH:mm:ss"
    private const val HOUR_MIN_FORMAT = "hh:mm a"

    /**
     * Get date formatted
     *
     * @param date in format of "2024-03-23T00:00:00"
     * @param inputFormat Input Date Format
     * @param outputFormat Output Date Format
     * @return date in format of Mar 30, 2024
     */
    fun getDateFormatted(
        date: String,
        inputFormat: String = API_DATE_FORMAT,
        outputFormat: String = DATE_FORMAT,
    ): String {
        val simpleDateFormat = SimpleDateFormat(inputFormat, Locale.getDefault())
        return try {
            val newDate = simpleDateFormat.parse(date)
            if (newDate != null) {
                SimpleDateFormat(outputFormat, Locale.getDefault()).format(newDate)
            } else {
                EMPTY_STRING
            }
        } catch (e: Exception) {
            EMPTY_STRING
        }
    }

    /**
     * Get time formatted
     *
     * @param timeString in format of "22:00:00"
     * @param inputFormat Input time format
     * @param outputFormat Output time format
     * @return time in format of "10:00 PM"
     */
    fun getTimeFormatted(
        timeString: String,
        inputFormat: String = API_TIME_FORMAT,
        outputFormat: String = HOUR_MIN_FORMAT,
    ): String {
        val dateFormatter = DateTimeFormatter.ofPattern(inputFormat)
        return try {
            val formattedDate = LocalTime.parse(timeString, dateFormatter)
            formattedDate.format(DateTimeFormatter.ofPattern(outputFormat)).uppercase()
        } catch (e: Exception) {
            EMPTY_STRING
        }
    }
}
