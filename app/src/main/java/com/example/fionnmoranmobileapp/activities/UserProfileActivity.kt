package com.example.fionnmoranmobileapp.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fionnmoranmobileapp.R
import com.google.android.gms.common.wrappers.Wrappers.packageManager
import kotlinx.android.synthetic.main.activity_userprofile.*

class UserProfileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userprofile)

    }

}