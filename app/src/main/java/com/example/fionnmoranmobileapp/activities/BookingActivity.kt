package com.example.fionnmoranmobileapp.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fionnmoranmobileapp.Booking
import com.example.fionnmoranmobileapp.BookingModel
import com.example.fionnmoranmobileapp.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_booking.*
import kotlinx.android.synthetic.main.activity_booking.spinner1
import kotlinx.android.synthetic.main.activity_booking.textViewDate
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class BookingActivity : AppCompatActivity() {

    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        btnConfirm.setOnClickListener {
            makeBooking()
        }

        getBtn.setOnClickListener {
            startActivity(Intent(applicationContext,RetrievalActivity::class.java))
        }

        btnReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Bookings")

        // DATE PICKER
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        dateBtn.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
                textViewDate.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
            }, year, month, day)

            dpd.show()
        }

        // HOURS SPINNER
        val dropDownList = arrayOf("One Hour", "Two Hours", "Three Hours", "Four Hours", "Five Hours")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropDownList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner1.adapter = adapter
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val text: String = parent?.getItemAtPosition(position).toString()
                tVhour.text = text
                if (spinner1.selectedItemPosition == 0) {
                    condition1()
                }
                if (spinner1.selectedItemPosition == 1) {
                    condition2()
                }
                if (spinner1.selectedItemPosition == 2) {
                    condition3()
                }
            }

        }

        //BIKES SPINNER
       val dropDownList2 = arrayOf("Mountain Bike - Dublin", "Racing Bike - Waterford", "Hybrid - Carlow")
       val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropDownList2)
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
       spinner2.adapter = adapter2
       spinner2.onItemSelectedListener =
               object : AdapterView.OnItemSelectedListener {
                   override fun onNothingSelected(parent: AdapterView<*>?) {
                   }

                   override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                       val text: String = parent?.getItemAtPosition(position).toString()
                       tVbike.text = text
                       if (spinner2.selectedItemPosition == 0) {
                           condition11()
                       }
                       if (spinner2.selectedItemPosition == 1) {
                           condition12()
                       }
                       if (spinner2.selectedItemPosition == 2) {
                           condition13()
                       }
                   }

               }

   }
    //Adding booking to database/booking view
    private fun makeBooking() {
        var bike = tVbike.text.toString()
        var hours = tVhour.text.toString()
        var date = textViewDate.text.toString()
        if (bike.isNotEmpty() && hours.isNotEmpty() && date.isNotEmpty()) {
            var model = BookingModel(bike, hours, date)
            var id = reference.push().key
            reference.child(id!!).setValue(model)
            tVbike.setText("")
            tVhour.setText("")
            textViewDate.setText("")
            Toast.makeText(applicationContext, "Success, check your booking on the next page!",Toast.LENGTH_SHORT).show()

        }
        else {
            Toast.makeText(applicationContext, "Please enter all booking details!",Toast.LENGTH_LONG).show()
        }
    }
//spinners
    private fun condition1() {
        Toast.makeText(this, "selected Item " + spinner1.selectedItem, Toast.LENGTH_LONG).show()
    }

    private fun condition2() {
        Toast.makeText(this, "selected Item " + spinner1.selectedItem, Toast.LENGTH_LONG).show()
    }

    private fun condition3() {
        Toast.makeText(this, "checked Item ", Toast.LENGTH_LONG).show()
    }

    private fun condition11(){
        Toast.makeText(this, "selected Item " + spinner2.selectedItem, Toast.LENGTH_LONG).show()
    }

    private fun condition12(){
        Toast.makeText(this, "selected Item " + spinner2.selectedItem, Toast.LENGTH_LONG).show()
    }
    private fun condition13(){
        Toast.makeText(this, "checked Item ", Toast.LENGTH_LONG).show()
    }
}

