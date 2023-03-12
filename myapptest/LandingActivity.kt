package com.example.myapptest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// Define landing page activity
class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // When Button is pressed, go to the Person Page Activity
        val hungryBtn = findViewById<Button>(R.id.im_hungry_btn)
        hungryBtn.setOnClickListener {
            val intent = Intent(this,AppPage::class.java)
            startActivity(intent)
        }
    }
}