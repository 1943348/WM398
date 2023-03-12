package com.example.myapptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment

// Define Frequently Asked Questions fragment
class FaqsFragment : Fragment(R.layout.fragment_faqs){
    // Define variables
    private lateinit var expandButton: ImageButton
    private lateinit var expandLayout: LinearLayout

    // Inflate fragment layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_faqs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        expandButton = view.findViewById(R.id.toggle_button_faqs)
        expandLayout = view.findViewById(R.id.expand_layout_faqs)

        // When the image button is clicked, open the FAQ information
        expandButton.setOnClickListener {
            if (expandLayout.visibility == View.VISIBLE) {
                expandLayout.visibility = View.GONE
                expandButton.setImageResource(R.drawable.faqs_btn)
            } else {
                expandLayout.visibility = View.VISIBLE
                expandButton.setImageResource(R.drawable.faq_selected_btn)
            }
        }
    }

}