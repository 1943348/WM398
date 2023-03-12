package com.example.myapptest

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

// Create Adapter for Upcoming Bookings RecyclerView
class BookingsAdapter(private val bookingsList: ArrayList<UpcomingBookings>) :
    RecyclerView.Adapter<BookingsAdapter.MyViewHolder>() {
    // Create a new ViewHolder for reference objects
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate the upcoming booking card view
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.upcoming_bkgs_cardview,
            parent, false
        )
        // Show the inflated view
        return MyViewHolder(itemView)
    }

    // Create function to get information for each card in the recycler view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = bookingsList[position]
        // Show Restaurant Title
        holder.tvHeading.text = currentItem.heading
        // Show Restaurant booked time
        holder.bookingTime.text = currentItem.bookingTime
        // Show Remind Me and Switch Button text
        holder.bookingDetails.text = currentItem.bookingDetails

        // Collapse booking details until card is clicked on
        val isVisible: Boolean = currentItem.visibility
        holder.cardLayout.visibility = if (isVisible) View.VISIBLE else View.GONE

        holder.tvHeading.setOnClickListener {
            currentItem.visibility = !currentItem.visibility
            notifyItemChanged(position)
        }

    }

    // Get item count of bookingsList
    override fun getItemCount(): Int {
        return bookingsList.size
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Define variables in the booking card
        val tvHeading: TextView = itemView.findViewById(R.id.text_booking)
        val bookingTime: TextView = itemView.findViewById(R.id.booking_time)
        val bookingDetails: TextView = itemView.findViewById(R.id.booking_information)
        val cardLayout: CardView = itemView.findViewById(R.id.expanded_booking)

        @SuppressLint("UseSwitchCompatOrMaterialCode")
        val reminderSwitch: Switch = itemView.findViewById(R.id.reminder_switch)

        // Define variable for Reminder Switch
        init {
            // custom switch design
            val switchBackgroundOn =
                ContextCompat.getDrawable(itemView.context, R.drawable.ic_switch_on)
            val switchBackgroundOff =
                ContextCompat.getDrawable(itemView.context, R.drawable.ic_switch_off)
            val switchBackgroundInitialOff =
                ContextCompat.getDrawable(itemView.context, R.drawable.ic_switch_off_disable)
            reminderSwitch.background = switchBackgroundInitialOff
            // When the reminder switch is pressed, change switch background
            reminderSwitch.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    Log.d("BookingAdapter", "Switch Clicked!")
                    reminderSwitch.background = switchBackgroundOn
                } else {
                    reminderSwitch.background = switchBackgroundOff
                }
            }
        }

    }

}
