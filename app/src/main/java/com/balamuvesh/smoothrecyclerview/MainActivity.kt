package com.balamuvesh.smoothrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.balamuvesh.smoothrecyclerview.adapters.ParentAdapter
import com.balamuvesh.smoothrecyclerview.model.ParentModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewInit()
    }

    private fun recyclerViewInit() {
        rv_parent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ParentAdapter(ParentModel())
        }
    }
}

