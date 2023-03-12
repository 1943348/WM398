package com.example.myapptest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class FriendsFragment : Fragment(R.layout.fragment_friends){

    // Add Friend button
    private lateinit var addFriend : Button
    private lateinit var addFriendLayout: LinearLayout

    // Inflate Friends Fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_friends, container, false)
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        addFriend = view.findViewById(R.id.add_friend_btn)
        addFriendLayout = view.findViewById(R.id.add_friend_layout)

        // Set Add Friend button to open Add Friend Tab
        addFriendLayout.visibility = View.GONE

        addFriend.setOnClickListener {
            addFriendLayout.visibility = View.VISIBLE
        }

        // User must press Cancel or Add Friend Button to close Add Friend tab
        // Add OnClickListener to the button inside addFriendLayout
        val closeButton = addFriendLayout.findViewById<Button>(R.id.cancel_friend)
        closeButton.setOnClickListener {
            addFriendLayout.visibility = View.GONE
        }

        val addFriendButton = addFriendLayout.findViewById<Button>(R.id.add_friend)
        addFriendButton.setOnClickListener {
            addFriendLayout.visibility = View.GONE
        }

    }
}