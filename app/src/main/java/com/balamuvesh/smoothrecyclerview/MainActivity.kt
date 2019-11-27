package com.balamuvesh.smoothrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import com.balamuvesh.smoothrecyclerview.adapters.ParentAdapter
import com.balamuvesh.smoothrecyclerview.model.ParentModel
import com.balamuvesh.smoothrecyclerview.utils.CustomLinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MAIN_ACTIVITY"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerviewInit()
    }

    private fun recyclerviewInit() {
        rv_parent.apply {
            layoutManager = CustomLinearLayoutManager(context)
            adapter = ParentAdapter(ParentModel())
        }
    }

}
