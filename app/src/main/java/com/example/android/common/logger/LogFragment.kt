
package com.example.android.common.logger

import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.TextViewCompat
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView

class LogFragment : Fragment() {

    lateinit var logView: LogView
        private set

    private lateinit var scrollView: ScrollView

    private fun inflateViews(): View {
        scrollView = ScrollView(activity)
        val scrollParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        scrollView.layoutParams = scrollParams

        logView = LogView(activity as Context)
        val logParams = ViewGroup.LayoutParams(scrollParams)
        logParams.height = ViewGroup.LayoutParams.WRAP_CONTENT

        with(logView) {
            layoutParams = logParams
            isClickable = true
            isFocusable = true
            typeface = Typeface.MONOSPACE
        }

        // Want to set padding as 16 dips, setPadding takes pixels.  Hooray math!
        val paddingDips = 16
        val scale = resources.displayMetrics.density.toDouble()
        val paddingPixels = (paddingDips * scale + .5).toInt()
        logView.setPadding(paddingPixels, paddingPixels, paddingPixels, paddingPixels)
        logView.compoundDrawablePadding = paddingPixels

        logView.gravity = Gravity.BOTTOM
        TextViewCompat.setTextAppearance(logView, android.R.style.TextAppearance_Holo_Medium)

        scrollView.addView(logView)
        return scrollView
    }

     override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val result = inflateViews()

        logView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }
        })
        return result
    }
}