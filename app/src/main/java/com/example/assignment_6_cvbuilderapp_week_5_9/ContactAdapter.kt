package com.example.assignment_6_cvbuilderapp_week_5_9

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class ContactAdapter(private val mList: List<ContactViewModel>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    var activity: Activity? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_experience, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewModel = mList[position]
        holder.imageView.setImageResource(viewModel.image)
        holder.topEditText.text = viewModel.contactType
        holder.midEditText.text = viewModel.contactInfo
        holder.bottomEditText.text = ""

        val handler = View.OnClickListener {
            when(viewModel.contactType) {
                "Phone" -> {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + viewModel.contactInfo))
                    activity?.startActivity(intent)
                }
                "Email" -> {
                    val email = Intent(Intent.ACTION_SEND)
                    email.putExtra(Intent.EXTRA_EMAIL, arrayOf(viewModel.contactInfo))
                    email.putExtra(Intent.EXTRA_SUBJECT, "Let's connect!")
                    email.putExtra(Intent.EXTRA_TEXT, "I'm a recruiter and want to connect")
                    email.data = Uri.parse("mailto:$viewModel.contactInfo")
                    email.type = "text/plain"

                    activity?.startActivity(Intent.createChooser(email, "Send email using"))
                }
                else -> {
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.contactInfo))
                    activity?.startActivity(browserIntent)
                }
            }
        }
        holder.imageView.setOnClickListener(handler)
        holder.topEditText.setOnClickListener(handler)
        holder.midEditText.setOnClickListener(handler)
        holder.bottomEditText.setOnClickListener(handler)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.item_experience_imageView)
        val topEditText: TextView = itemView.findViewById(R.id.item_experience_title)
        val midEditText: TextView = itemView.findViewById(R.id.item_experience_position)
        val bottomEditText: TextView = itemView.findViewById(R.id.item_experience_duration)
    }
}