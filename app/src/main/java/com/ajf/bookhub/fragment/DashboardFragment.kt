package com.ajf.bookhub.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajf.bookhub.R
import com.ajf.bookhub.adapter.DashboardRecyclerAdapter
import com.ajf.bookhub.model.bookInfoList
import com.ajf.bookhub.util.ConnectionManager

class DashboardFragment : Fragment() {

    private lateinit var rvDashboard: RecyclerView
    private lateinit var btnCheckInternet: Button
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var recyclerAdapter: DashboardRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        rvDashboard = view.findViewById(R.id.rvDashboard)
        btnCheckInternet = view.findViewById(R.id.btnCheckInternet)

        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

        rvDashboard.adapter = recyclerAdapter
        rvDashboard.layoutManager = layoutManager

        btnCheckInternet.setOnClickListener {
            if (ConnectionManager().checkConnectivity(activity as Context)) {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Connected to Internet!")
                dialog.setPositiveButton("Ok") { text, listener -> }
                dialog.setNegativeButton("Close") { text, listener -> }

                dialog.create()
                dialog.show()
            } else {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Error")
                dialog.setMessage("Can't connect to the Internet!")
                dialog.setPositiveButton("Ok") { text, listener -> }
                dialog.setNegativeButton("Close") { text, listener -> }

                dialog.create()
                dialog.show()
            }
        }

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