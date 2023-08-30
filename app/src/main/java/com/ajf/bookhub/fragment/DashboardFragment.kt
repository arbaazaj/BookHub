package com.ajf.bookhub.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajf.bookhub.R
import com.ajf.bookhub.adapter.DashboardRecyclerAdapter
import com.ajf.bookhub.model.Book

class DashboardFragment : Fragment() {

    private lateinit var rvDashboard: RecyclerView
    private lateinit var layoutManager: RecyclerView.LayoutManager

    private lateinit var recyclerAdapter: DashboardRecyclerAdapter

    private val bookInfoList = arrayListOf(
        Book("Hello Kitty", "Julian", "Rs. 699", "4.8", R.drawable.anna_kare),
        Book("My Dreams", "X", "Rs. 1099", "4.0", R.drawable.adventures_finn),
        Book("Lock n Love", "Robert R.J", "Rs. 300", "3.2", R.drawable.great_gatsby),
        Book("The Spirits Call me", "Betty", "Rs. 450", "4.8", R.drawable.lolita),
        Book("Legends Of Tomorrow", "J.R.R. Tolkien", "Rs. 2599", "4.5", R.drawable.lord_of_rings),
        Book("Night Sky", "Samuel LK", "Rs. 299", "2.8", R.drawable.madame),
        Book("Rainbow Rides", "Richard Rich", "Rs. 10000", "5.0", R.drawable.middlemarch),
        Book("Lucrative Decision", "Mr. Unknown", "Rs. 6969", "4.9", R.drawable.moby_dick),
        Book("Harry Potter", "J.K Rowling", "Rs. 699", "4.8", R.drawable.ps_ily),
        Book("Twilight", "Stephenie Meyer", "Rs. 699", "4.8", R.drawable.war_and_peace)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        rvDashboard = view.findViewById(R.id.rvDashboard)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = DashboardRecyclerAdapter(activity as Context, bookInfoList)

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