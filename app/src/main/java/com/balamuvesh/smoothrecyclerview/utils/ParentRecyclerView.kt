package com.balamuvesh.smoothrecyclerview.utils

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs
import kotlin.math.atan

class ParentRecyclerView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attributeSet, defStyleAttr) {
    private val mDetector = GestureDetectorCompat(context, XScrollDetector())

    override fun onInterceptTouchEvent(e: MotionEvent?): Boolean {
        return super.onInterceptTouchEvent(e) && mDetector.onTouchEvent(e)
    }
}

class XScrollDetector : GestureDetector.SimpleOnGestureListener() {
    private val TAG = "XSCROLL_DETECTOR"

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        Log.d(TAG, "Angle = ${atan((distanceY/distanceX))*57.2958}")
        return abs(distanceY) > abs(distanceX)
    }

}
