package com.example.fionnmoranmobileapp


class BookingModel() {

    lateinit var bike: String
    lateinit var hours: String
    lateinit var date: String

    constructor(bike:String,hours: String,date: String):this(){
        this.bike =bike
        this.hours = hours
        this.date = date
    }

}