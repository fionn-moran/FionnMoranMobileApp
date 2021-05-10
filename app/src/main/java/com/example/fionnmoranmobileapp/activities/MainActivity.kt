package com.example.fionnmoranmobileapp.activities

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fionnmoranmobileapp.Booking
import com.example.fionnmoranmobileapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor
import java.util.*


class MainActivity : AppCompatActivity(), AnkoLogger {

    var fbAuth = FirebaseAuth.getInstance()
    val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentValue = intent.getStringExtra("Data")
        findViewById<TextView>(R.id.textView23).apply{
            text = intentValue.toString()
        }
/*
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        dateBtn11.setOnClickListener {
            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker, mYear: Int, mMonth: Int, mDay: Int ->
                textViewDate.setText("" + mDay + "/" + (mMonth + 1) + "/" + mYear)
            }, year, month, day)

            dpd.show()
        }

 */

        btnAdd.setOnClickListener {
            startActivity(intentFor<MapsActivity>())
        }

        //manage booking

        val editBtn = findViewById<Button>(R.id.editBtn)
        editBtn.setOnClickListener{
            val intent = Intent(this, BookingActivity::class.java)
            startActivity(intent)
        }



//logout
        var logoutBtn = findViewById<Button>(R.id.logoutBtn)

        logoutBtn.setOnClickListener {
            signOut()
            val intent = Intent(this, LoginActivity::class.java) /// DOUBLE CHECK THIS LATER!!!!
            startActivity(intent)   //////INCLUDING
        }

        fbAuth.addAuthStateListener {
            if (fbAuth.currentUser == null) {
                this.finish()
            }
        }

//save

        //spinners
/*
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
                editTextHour.text = text
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


        val dropDownList2 = arrayOf("Mountain Bike - Dublin", "Racing Bike - Waterford", "Hybrid - Carlow")
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, dropDownList2)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner2.adapter = adapter2
        spinner2.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                    }

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
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
  */

        if (user != null) {
            // User is signed in.
        } else {
            // No user is signed in.
        }

        user?.let {
            // Name, email address, and profile photo Url
            val email = user.email
        }

        val profileBtn = findViewById<Button>(R.id.aboutBtn)
        profileBtn.setOnClickListener{
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

    }




/*
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
*/

    fun signOut(){
        fbAuth.signOut()

    }
}

