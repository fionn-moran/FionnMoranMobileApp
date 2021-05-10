package com.example.fionnmoranmobileapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fionnmoranmobileapp.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val dublin = LatLng(53.3498091, -6.2602548)
        mMap.addMarker(MarkerOptions().position(dublin).title("Mountain Bike in Dublin"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dublin))

        val waterford = LatLng(52.2461, -7.1387)
        mMap.addMarker(MarkerOptions().position(waterford).title("Racing Bike in Waterford"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(waterford))

        val carlow = LatLng(52.8337418, -6.9234074)
        mMap.addMarker(MarkerOptions().position(carlow).title("Hybrid in Carlow"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(carlow))
    }
}