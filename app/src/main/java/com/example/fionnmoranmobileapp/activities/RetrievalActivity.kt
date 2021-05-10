package com.example.fionnmoranmobileapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RatingBar
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import com.example.fionnmoranmobileapp.BookingModel
import com.example.fionnmoranmobileapp.BookingAdapter
import com.example.fionnmoranmobileapp.R
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.activity_retrieval.*
import kotlinx.android.synthetic.main.bookings_layout.*
import kotlinx.android.synthetic.main.bookings_layout.tVbike
import kotlinx.android.synthetic.main.bookings_layout.tVhour
import kotlinx.android.synthetic.main.bookings_layout.textViewDate
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivityForResult


class RetrievalActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieval)

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Bookings")
        getBookings()

    //    deleteBtn.setOnClickListener {
     //       deleteBooking()
    //    }
    }




    //searchview
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu!!.findItem(R.id.search)


        if(menuItem!=null) {
            val searchView = menuItem.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {
                        getBookings()
                    }

                    else {
                        getBookings()
                    }
                    return true
                }

            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

                private fun getBookings() {
                    reference.addValueEventListener(object : ValueEventListener {
                        override fun onCancelled(error: DatabaseError) {
                            Log.e("cancel", error.toString())
                        }

            override fun onDataChange(snapshot: DataSnapshot) {
                var list = ArrayList<BookingModel>()
                for (data in snapshot.children) {
                    var model = data.getValue(BookingModel::class.java)
                    list.add(model as BookingModel)
                }
                if(list.isNotEmpty()) {

                    var adapter = BookingAdapter(list)
                    recyclerview.adapter=adapter
                }
            }

        })
    }
}

