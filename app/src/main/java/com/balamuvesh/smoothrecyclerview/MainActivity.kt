package com.balamuvesh.smoothrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.balamuvesh.smoothrecyclerview.adapters.ParentAdapter
import com.balamuvesh.smoothrecyclerview.model.ParentModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.parent_recycler.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerviewInit()
    }

    private fun recyclerviewInit() {
        rv_parent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ParentAdapter(ParentModel())
        }
    }
}
