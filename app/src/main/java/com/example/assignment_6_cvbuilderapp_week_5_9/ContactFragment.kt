package com.example.assignment_6_cvbuilderapp_week_5_9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerview = getView()?.findViewById<RecyclerView>(R.id.contactRecyclerView)

        recyclerview?.layoutManager = LinearLayoutManager(context)
        val data = ArrayList<ContactViewModel>()
        data.add(ContactViewModel(R.drawable.phone, "18482528769", "Phone"))
        data.add(ContactViewModel(R.drawable.email, "andrewledev@gmail.com", "Email"))
        data.add(ContactViewModel(R.drawable.linkedin, "https://www.linkedin.com/in/anh-duy-le-633160117/", "Linkedin"))
        data.add(ContactViewModel(R.drawable.github, "https://github.com/leanhduy1998", "Github"))

        val adapter = ContactAdapter(data)
        adapter.activity = activity
        recyclerview?.adapter = adapter
    }
}