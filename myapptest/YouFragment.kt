package com.example.myapptest

import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class YouFragment : Fragment(R.layout.fragment_you){

    // declare variable for upcoming bookings
    private lateinit var bookingsAdapter: BookingsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var bookingsArrayList: ArrayList<UpcomingBookings>

    private lateinit var heading: Array<String>
    private lateinit var bookingTime: Array<String>
    private lateinit var bookingInfo : Array<String>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Upcoming Bookings
        bookingDataInitialize()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.upcoming_bkgs_cards)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        bookingsAdapter = BookingsAdapter(bookingsArrayList)
        recyclerView.adapter = bookingsAdapter


    }

    // Method for getting the booking data
    private fun bookingDataInitialize(){
        bookingsArrayList = arrayListOf()

        heading = arrayOf(
            getString(R.string.wagamamas),
            getString(R.string.nandos),
            getString(R.string.bebas_greek),
            getString(R.string.turtle_bay),
        )

        bookingTime = arrayOf(
            getString(R.string.six_thirty),
            getString(R.string.seven_thirty),
            getString(R.string.quarter_to_eight),
            getString(R.string.six_thirty),
        )

        bookingInfo = arrayOf(
            getString(R.string.reminder),
            getString(R.string.reminder),
            getString(R.string.reminder),
            getString(R.string.reminder),
        )


        for (i in heading.indices){
            val bookings = UpcomingBookings(heading[i], bookingTime[i], bookingInfo[i])
            bookingsArrayList.add(bookings)
        }
    }

}