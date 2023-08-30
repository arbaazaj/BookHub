package com.ajf.bookhub.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajf.bookhub.R
import com.ajf.bookhub.activity.DescriptionActivity
import com.ajf.bookhub.model.Book
import com.squareup.picasso.Picasso

class DashboardRecyclerAdapter(val context: Context, private val itemList: ArrayList<Book>) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtBookTitle: TextView = view.findViewById(R.id.tvBookTitleID)
        val txtBookAuthor: TextView = view.findViewById(R.id.tvAuthorID)
        val txtBookPrice: TextView = view.findViewById(R.id.tvPriceID)
        val txtBookRating: TextView = view.findViewById(R.id.tvRatingID)
        val imgBookCover: ImageView = view.findViewById(R.id.imgBookCover)
        val rlContent: RelativeLayout = view.findViewById(R.id.rlContent)

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
        holder.txtBookPrice.text = book.bookPrice
        holder.txtBookRating.text = book.bookRating
        //holder.imgBookCover.setImageResource(book.bookCover)
        Picasso.get()
            .load(book.bookCover)
            .error(R.drawable.default_book_cover)
            .into(holder.imgBookCover);

        holder.rlContent.setOnClickListener {
            val intent = Intent(context, DescriptionActivity::class.java)
            intent.putExtra("book_id", book.bookId)
            context.startActivity(intent)
        }

    }
}