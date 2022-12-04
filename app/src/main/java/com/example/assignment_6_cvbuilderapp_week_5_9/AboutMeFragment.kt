package com.example.assignment_6_cvbuilderapp_week_5_9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_6_cvbuilderapp_week_5_9.databinding.FragmentAboutmeBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class AboutMeFragment : Fragment() {

    private var _binding: FragmentAboutmeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutmeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.educationRecyclerView)

        recyclerview?.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<ExperienceViewModel>()
        data.add(ExperienceViewModel(R.drawable.miu, "Maharishi International University", "Master of Science - MS, Computer Science", "Feb 2022 - Oct 2023"))
        data.add(ExperienceViewModel(R.drawable.rutgersu, "Rutgers University", "Bachelor of Art", "2016 - 2018"))
        data.add(ExperienceViewModel(R.drawable.shoreline, "Shoreline Community College", "Associate of Art", "2014 - 2016"))

        val adapter = ExperienceAdapter(data)
        recyclerview?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}