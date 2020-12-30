package com.egesoftware.newsappnayla.utils


import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.text.format.DateUtils
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*


class Utils {
}

/**
 * Conversion functions that convert to/from a Date/Long
 */
object RoomConverters {
    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: Long?): Date? = value?.let { Date(it) }

    @TypeConverter
    @JvmStatic
    fun dateToTimestamp(date: Date?): Long? = date?.time

}

/**
 * Extension function that formats dates to a relative time (E.g. "4 hours ago" or "Yesterday")
 */
fun Date.toFormattedString(): String =
    DateUtils.getRelativeTimeSpanString(
        this.time,
        System.currentTimeMillis(),
        DateUtils.MINUTE_IN_MILLIS
    ).toString()


@SuppressLint("SimpleDateFormat")
fun getDateFormat(originDate: String) :String  {
    val formatIn = SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'")
    val formatOut = SimpleDateFormat("MMM dd , yyyy   hh:mm")
    val calendar = Calendar.getInstance()
    calendar.time = formatIn.parse(originDate)

    return formatOut.format(calendar.time)

}




fun networkIsAvailable(context: Context): Boolean {
    val conManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = conManager.activeNetworkInfo
    return netInfo != null && netInfo.isConnected
}