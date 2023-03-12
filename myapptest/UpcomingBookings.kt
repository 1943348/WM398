package com.example.myapptest

import android.annotation.SuppressLint

// Define data class for Upcoming Bookings RecyclerView
@SuppressLint("UseSwitchCompatOrMaterialCode")
data class UpcomingBookings @SuppressLint("UseSwitchCompatOrMaterialCode")
constructor(var heading: String, var bookingTime: String, var bookingDetails: String
, var visibility: Boolean = false)

