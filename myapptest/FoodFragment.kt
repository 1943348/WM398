package com.example.myapptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodFragment : Fragment(R.layout.fragment_food) {
    // Define variables for Food Fragment and RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: ArrayList<FoodCards>

    private lateinit var foodTitle : Array<String>
    private lateinit var foodDescription: Array<String>

    // Pick For Me button
    private lateinit var pickForMe : Button
    private lateinit var pickforMeLayout: LinearLayout


    // Inflate layout for Food Fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        pickForMe = view.findViewById(R.id.pick_for_me)
        pickforMeLayout = view.findViewById(R.id.pick_for_me_layout)

        // Set Pick For Me visibility of the layout to GONE
        pickforMeLayout.visibility = View.GONE

        // When Pick for Me button is clicked, display recommendation
        pickForMe.setOnClickListener {
            if (pickforMeLayout.visibility == View.VISIBLE)
                pickforMeLayout.visibility = View.GONE
             else {
                pickforMeLayout.visibility = View.VISIBLE
            }
        }
        // Recycler View for Restaurants
        dataInitialize()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView = view.findViewById(R.id.food_gallery)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter

    }


    // Initialise data for Restaurant Cards
    private fun dataInitialize(){
        foodList = arrayListOf<FoodCards>()

        foodTitle = arrayOf(
            getString(R.string.bebas_greek),
            getString(R.string.nandos),
            getString(R.string.turtle_bay),
            getString(R.string.wagamamas)
        )

        foodDescription = arrayOf(
            getString(R.string.bebas_info),
            getString(R.string.nandos_info),
            getString(R.string.turtle_bay_info),
            getString(R.string.wagamamas_info)
        )

        for (i in foodTitle.indices){

            val food = FoodCards(foodTitle[i],foodDescription[i])
            foodList.add(food)
        }
    }

}