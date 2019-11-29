package com.balamuvesh.smoothrecyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.balamuvesh.smoothrecyclerview.R
import com.balamuvesh.smoothrecyclerview.model.ChildModel
import com.balamuvesh.smoothrecyclerview.model.ParentModel
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.parent_recycler.*

class ParentAdapter(private val parent: ParentModel) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return parent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun bind(position: Int) {
            val title = "${parent.title} $position"
            parent_title.text = title
            child_recycler_view.apply {
                layoutManager =  LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL, false)
                adapter = ChildAdapter(ChildModel())

            }
        }
    }
}