package com.example.myapptest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

class SettingsFragment : Fragment(R.layout.fragment_settings){
    // Define variables for Settings Fragment
    private lateinit var expandButton: ImageButton
    private lateinit var expandLayout: LinearLayout
    private lateinit var logoutButton : Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandButton = view.findViewById(R.id.toggle_button)
        expandLayout = view.findViewById(R.id.expand_layout)
        logoutButton = view.findViewById(R.id.log_out_btn)


        // When settings button is clicked, open Settings information
        expandButton.setOnClickListener {
            if (expandLayout.visibility == View.VISIBLE) {
                expandLayout.visibility = View.GONE
                expandButton.setImageResource(R.drawable.settings_btn)
            } else {
                expandLayout.visibility = View.VISIBLE
                expandButton.setImageResource(R.drawable.settings_selected_btn)
            }
        }

        // When logout button go back to the landing page
        logoutButton.setOnClickListener{
            val intent = Intent(activity,LandingActivity::class.java)
            startActivity(intent)
        }
    }

}