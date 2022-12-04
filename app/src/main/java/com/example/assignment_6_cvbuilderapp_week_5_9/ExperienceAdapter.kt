package com.example.assignment_6_cvbuilderapp_week_5_9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExperienceAdapter(private val mList: List<ExperienceViewModel>) : RecyclerView.Adapter<ExperienceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_experience, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewModel = mList[position]
        holder.imageView.setImageResource(viewModel.image)
        holder.title.text = viewModel.title
        holder.position.text = viewModel.position
        holder.duration.text = viewModel.duration
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_experience_imageView)
        val title: TextView = itemView.findViewById(R.id.item_experience_title)
        val position: TextView = itemView.findViewById(R.id.item_experience_position)
        val duration: TextView = itemView.findViewById(R.id.item_experience_duration)
    }
}