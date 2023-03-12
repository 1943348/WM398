package com.example.myapptest

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.provider.Settings.Global.getString
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// Create an Adapter for Restaurant Cards
class FoodAdapter(private val foodList: ArrayList<FoodCards>) :
    RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {
    // Inflate layout of Food Items which holds the restaurant cards
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.food_items, parent, false)
        return MyViewHolder(itemView)

    }

    // Show current item with relevant restaurant information
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = foodList[position]
        holder.foodTitle.text = currentItem.FoodTitle
        holder.foodDescription.text = currentItem.FoodDescription

    }

    // Get size of restaurant list
    override fun getItemCount(): Int {
        return foodList.size

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Define variables in the recycler view
        val foodTitle: TextView = itemView.findViewById(R.id.food_title)
        val foodDescription: TextView = itemView.findViewById(R.id.food_info)
        var bookingInfo: Button = itemView.findViewById(R.id.book_button)

        init {
            // Change button text and colour when pressed
            bookingInfo.setOnClickListener {
                val isButtonPressed = bookingInfo.text == itemView.context.getString(R.string.availability)
                if (isButtonPressed) {
                    bookingInfo.text = itemView.context.getString(R.string.checking_availability)
                    bookingInfo.setBackgroundColor(Color.parseColor("#D9D9D9"))
                } else {
                    bookingInfo.text = itemView.context.getString(R.string.checking_availability)
                }
            }
        }


    }
}