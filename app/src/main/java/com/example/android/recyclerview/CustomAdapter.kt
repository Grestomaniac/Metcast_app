package com.example.android.recyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.android.common.logger.Log

class CustomAdapter(private val dataSet: Array<String>) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val textView: TextView

        init {
            v.setOnClickListener { Log.d(TAG, "Element $adapterPosition clicked.") }
            textView = v.findViewById(R.id.textView)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        Log.d(TAG, "Element $position set.")
        viewHolder.textView.text = dataSet[position]
    }

    override fun getItemCount() = dataSet.size

    companion object {
        private val TAG = "CustomAdapter"
    }
}
