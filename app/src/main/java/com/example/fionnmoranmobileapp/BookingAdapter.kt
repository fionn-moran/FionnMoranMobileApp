package com.example.fionnmoranmobileapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Filter
import android.widget.Filterable
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fionnmoranmobileapp.activities.RetrievalActivity
import kotlinx.android.synthetic.main.bookings_layout.view.*

class BookingAdapter(var list:ArrayList<BookingModel>): RecyclerView.Adapter<BookingAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var bike=itemView.tVbike
        var hours=itemView.tVhour
        var date=itemView.textViewDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.bookings_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bike.text=list[position].bike
        holder.hours.text=list[position].hours
        holder.date.text=list[position].date
    }


}