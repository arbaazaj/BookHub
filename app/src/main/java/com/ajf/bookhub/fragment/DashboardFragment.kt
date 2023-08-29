package com.ajf.bookhub.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajf.bookhub.R
import com.ajf.bookhub.adapter.DashboardRecyclerAdapter

class DashboardFragment : Fragment() {

    private lateinit var rvDashboard: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private val bookList = arrayListOf(
        "Hello Kitty",
        "My Dreams",
        "Lock n Love",
        "The Spirits Call me",
        "Legends Of Tomorrow",
        "Night Sky",
        "Rainbow Rides",
        "Lucrative Decision",
        "Harry Potter",
        "Twilight"
    )

    private lateinit var recyclerAdapter: DashboardRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        rvDashboard = view.findViewById(R.id.rvDashboard)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookList)

        rvDashboard.adapter = recyclerAdapter
        rvDashboard.layoutManager = layoutManager

        // Adding a divider between each list item
//        rvDashboard.addItemDecoration(
//            DividerItemDecoration(
//                rvDashboard.context,
//                (layoutManager as LinearLayoutManager).orientation
//            )
//        )

        return view
    }
}