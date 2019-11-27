package com.balamuvesh.smoothrecyclerview.utils

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CustomLinearLayoutManager(_context: Context, val _orientation: Int = RecyclerView.VERTICAL, _reverseLayout: Boolean = false):LinearLayoutManager(_context, _orientation, _reverseLayout) {
    override fun canScrollHorizontally(): Boolean {
        return _orientation == RecyclerView.HORIZONTAL
    }

    override fun canScrollVertically(): Boolean {
        return _orientation == RecyclerView.VERTICAL
    }
}