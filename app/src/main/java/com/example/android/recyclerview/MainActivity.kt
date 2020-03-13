package com.example.android.recyclerview

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ViewAnimator
import com.example.android.network.service.ApiFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

import com.example.android.common.activities.SampleActivityBase
import com.example.android.common.logger.Log
import com.example.android.common.logger.LogFragment
import com.example.android.common.logger.LogWrapper
import com.example.android.common.logger.MessageOnlyLogFilter
import com.example.android.data.AppConstants.MoscowCity
import com.example.android.data.AppConstants.TemperatureUnit
import com.example.android.data.AppConstants.YakutskCity

class MainActivity : SampleActivityBase() {
    val weatherService = ApiFactory.weatherHolderApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().run {
                replace(R.id.sample_content_fragment, RecyclerViewFragment())
                commit()
            }
        }

        GlobalScope.launch(Dispatchers.Main) {
            val YakutskMetcastRequest = weatherService.getWeather(YakutskCity, TemperatureUnit)
            try {
                val response = YakutskMetcastRequest.await()
                if(response.isSuccessful){
                    val metcastResponse = response.body()
                    val Metcasts = metcastResponse
                    val messageCity = metcastResponse?.city?.id
                }else{
                    android.util.Log.d("MainActivity ",response.errorBody().toString())
                }
            }catch (e: Exception){

            }
        }
    }

    private var logShown = false

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        menu.findItem(R.id.menu_toggle_log).run {
            isVisible = findViewById<ViewAnimator>(R.id.sample_output) is ViewAnimator
            setTitle(if (logShown) R.string.sample_hide_log else R.string.sample_show_log)
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_toggle_log -> {
            logShown = !logShown
            val output = findViewById<ViewAnimator>(R.id.sample_output) as ViewAnimator

            output.displayedChild = if (logShown) 1 else 0

            invalidateOptionsMenu()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }



    override fun initializeLogging() {
        val logWrapper = LogWrapper()

        Log.logNode = logWrapper

        val msgFilter = MessageOnlyLogFilter()
        logWrapper.next = msgFilter

        val logFragment = supportFragmentManager.findFragmentById(R.id.log_fragment) as LogFragment
        msgFilter.next = logFragment.logView

        Log.i(TAG, "Ready")
    }

    companion object {
        val TAG = "MainActivity"
    }
}
