package com.example.android.recyclerview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import com.example.android.data.weather.Forecast

class RecyclerViewFragment : Fragment() {

    private lateinit var currentLayoutManagerType: LayoutManagerType
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var dataset: Array<String>

    enum class LayoutManagerType { GRID_LAYOUT_MANAGER, LINEAR_LAYOUT_MANAGER }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDataset()
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.recycler_view_frag,
                container, false).apply { tag = TAG}

        recyclerView = rootView.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(activity)

        currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER

        if (savedInstanceState != null) {
            currentLayoutManagerType = savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER) as LayoutManagerType
        }
        setRecyclerViewLayoutManager(currentLayoutManagerType)

        recyclerView.adapter = CustomAdapter(dataset)

        rootView.findViewById<RadioButton>(R.id.linear_layout_rb).setOnClickListener{
            setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER)
        }

        rootView.findViewById<RadioButton>(R.id.grid_layout_rb).setOnClickListener{
            setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER)
        }

        return rootView
    }

    private fun setRecyclerViewLayoutManager(layoutManagerType: LayoutManagerType) {
        var scrollPosition = 0

        if (recyclerView.layoutManager != null) {
            scrollPosition = (recyclerView.layoutManager as LinearLayoutManager)
                    .findFirstCompletelyVisibleItemPosition()
        }

        when (layoutManagerType) {
            RecyclerViewFragment.LayoutManagerType.GRID_LAYOUT_MANAGER -> {
                layoutManager = GridLayoutManager(activity, SPAN_COUNT)
                currentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER
            }
            RecyclerViewFragment.LayoutManagerType.LINEAR_LAYOUT_MANAGER -> {
                layoutManager = LinearLayoutManager(activity)
                currentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER
            }
        }

        with(recyclerView) {
            layoutManager = this@RecyclerViewFragment.layoutManager
            scrollToPosition(scrollPosition)
        }

    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {

        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, currentLayoutManagerType)
        super.onSaveInstanceState(savedInstanceState)
    }

    private fun initDataset() {
        dataset = Array(DATASET_COUNT, {i -> "This is element # $"})
    }

    companion object {
        private val TAG = "RecyclerViewFragment"
        private val KEY_LAYOUT_MANAGER = "layoutManager"
        private val SPAN_COUNT = 2
        private val DATASET_COUNT = 60
    }
}
