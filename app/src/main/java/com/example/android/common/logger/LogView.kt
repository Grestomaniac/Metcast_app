package com.example.android.common.logger

import android.app.Activity
import android.content.Context
import android.util.*
import android.widget.TextView


class LogView : TextView, LogNode {

    private var next: LogNode? = null

    @JvmOverloads
    constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
            super(context, attrs, defStyle)

    override fun println(priority: Int, tag: String?, msg: String?, tr: Throwable?) {

        val priorityStr = when (priority) {
            android.util.Log.VERBOSE -> "VERBOSE"
            android.util.Log.DEBUG -> "DEBUG"
            android.util.Log.INFO -> "INFO"
            android.util.Log.WARN -> "WARN"
            android.util.Log.ERROR -> "ERROR"
            android.util.Log.ASSERT -> "ASSERT"
            else -> null
        }

        val exceptionStr = tr?.let{ android.util.Log.getStackTraceString(it) }

        val outputBuilder = StringBuilder()

        val delimiter = "\t"
        appendIfNotNull(outputBuilder, priorityStr, delimiter)
        appendIfNotNull(outputBuilder, tag, delimiter)
        appendIfNotNull(outputBuilder, msg, delimiter)
        appendIfNotNull(outputBuilder, exceptionStr, delimiter)

        (context as Activity).runOnUiThread( {
            appendToLog(outputBuilder.toString())
        })


        next?.println(priority, tag, msg, tr)

    }

    private fun appendIfNotNull(source: StringBuilder, addStr: String?, delimiter: String): StringBuilder {

        if (addStr != null && !addStr.isEmpty()) {
            return source.append(addStr).append(delimiter)
        }

        return source

    }

    private fun appendToLog(s: String) {
        append("\n" + s)
    }


}
