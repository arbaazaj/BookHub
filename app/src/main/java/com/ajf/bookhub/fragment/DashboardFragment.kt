package com.ajf.bookhub.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajf.bookhub.R

class DashboardFragment : Fragment() {

    private lateinit var rvDashboard: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        rvDashboard = view.findViewById(R.id.rvDashboard)
        layoutManager = LinearLayoutManager(activity)

        return view
    }
}