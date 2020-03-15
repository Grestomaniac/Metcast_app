package com.example.android.common.activities

import android.os.Bundle
import android.support.v4.app.FragmentActivity

import com.example.android.common.logger.Log
import com.example.android.common.logger.LogWrapper

open class SampleActivityBase : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        initializeLogging()
    }

    open fun initializeLogging() {
        val logWrapper = LogWrapper()
        Log.logNode = logWrapper

        Log.i(TAG, "Ready")
    }

    companion object {
        val TAG = "SampleActivityBase"
    }
}
