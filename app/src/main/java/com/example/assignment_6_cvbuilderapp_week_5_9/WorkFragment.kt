package com.example.assignment_6_cvbuilderapp_week_5_9

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class WorkFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_work, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.workRecyclerView)
        recyclerview?.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<ExperienceViewModel>()
        data.add(ExperienceViewModel(R.drawable.creditkarma, "Credit Karma", "Software Engineer", "Nov 2022"))
        data.add(ExperienceViewModel(R.drawable.iheartradio, "iHeartRadio", "iOS Engineer", "Apr 2020 - Jan 2022"))
        data.add(ExperienceViewModel(R.drawable.geniusplaza, "Genius Plaza", "iOS Developer", "Aug 2019 - Mar 2020"))
        data.add(ExperienceViewModel(R.drawable.rutgers, "Rutgers Graduate School of Education", "Mobile Developer", "Oct 2018 - Aug 2019"))
        data.add(ExperienceViewModel(R.drawable.aic, "Amerilink International Corp", "iOS Engineer Intern", "Jun 2018 - Aug 2018"))

        val adapter = ExperienceAdapter(data)
        recyclerview?.adapter = adapter

        val fab = getView()?.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab?.setOnClickListener { view ->
            val layout = LinearLayout(context)
            layout.orientation = LinearLayout.VERTICAL

            val titleBox = EditText(context)
            titleBox.hint = "Title"
            layout.addView(titleBox)

            val positionBox = EditText(context)
            positionBox.hint = "Position"
            layout.addView(positionBox)

            val durationBox = EditText(context)
            durationBox.hint = "Duration"
            layout.addView(durationBox)

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Add New Job")
            builder.setMessage("New Job Infos")
            builder.setView(layout)

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                if (titleBox.text.toString().isNotEmpty() && positionBox.text.toString().isNotEmpty() && durationBox.text.toString().isNotEmpty()) {
                    data.add(ExperienceViewModel(R.drawable.question, titleBox.text.toString(), positionBox.text.toString(), durationBox.text.toString()))
                    recyclerview?.refreshDrawableState()
                }
            }

            builder.setNegativeButton(android.R.string.no) { dialog, which ->

            }
            builder.show()
        }
    }
}