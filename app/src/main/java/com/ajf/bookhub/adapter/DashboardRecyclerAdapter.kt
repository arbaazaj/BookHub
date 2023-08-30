package com.ajf.bookhub.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajf.bookhub.R
import com.ajf.bookhub.model.Book

class DashboardRecyclerAdapter(val context: Context, private val itemList: ArrayList<Book>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtBookTitle: TextView = view.findViewById(R.id.tvBookTitleID)
        val txtBookAuthor: TextView = view.findViewById(R.id.tvAuthorID)
        val txtBookPrice: TextView = view.findViewById(R.id.tvPriceID)
        val txtBookRating: TextView = view.findViewById(R.id.tvRatingID)
        val imgBookCover: ImageView = view.findViewById(R.id.imgBookCover)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_dashboard_single_row, parent, false)
        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val book = itemList[position]
        holder.txtBookTitle.text = book.bookName
        holder.txtBookAuthor.text = book.bookAuthor
        holder.txtBookPrice.text = book.bookCost
        holder.txtBookRating.text = book.bookRating
        holder.imgBookCover.setImageResource(book.bookCover)

    }
}