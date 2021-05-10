package com.example.fionnmoranmobileapp

import org.joda.time.Hours
import java.util.*

class Booking{

    var id : Int = 0
    var bike : String = ""
    var hours : String = ""
    var date : String = ""

    constructor(bike:String, hours:String, date:String){
        this.bike = bike
        this.hours = hours
        this.date = date
    }

    constructor(){
    }
}