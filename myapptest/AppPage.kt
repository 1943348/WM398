package com.example.myapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.myapptest.databinding.ActivityPersonPageBinding



class AppPage : AppCompatActivity() {

    private lateinit var binding: ActivityPersonPageBinding
    private lateinit var settingsFragment: SettingsFragment
    private var isSettingsFragmentDisplayed = false
    private lateinit var faqsFragment: FaqsFragment
    private var isFaqsFragmentDisplayed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPersonPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setUpTabBar()



        // Settings Fragment and Toggle button
        settingsFragment = SettingsFragment()

        val toggleButton = findViewById<ImageView>(R.id.toggle_button)
        findViewById<View>(R.id.fragment_container)

        toggleButton.setOnClickListener {
            isSettingsFragmentDisplayed = if (isSettingsFragmentDisplayed) {
                supportFragmentManager.beginTransaction()
                    .remove(settingsFragment)
                    .commit()
                toggleButton.setImageResource(R.drawable.settings_btn)
                false
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, settingsFragment)
                    .commit()
                true
            }
        }

        // FAQs Fragment and Toggle Button
        faqsFragment = FaqsFragment()

        val faqsToggleButton = findViewById<ImageView>(R.id.toggle_button_faqs)

        faqsToggleButton.setOnClickListener {
            isFaqsFragmentDisplayed = if (isFaqsFragmentDisplayed) {
                supportFragmentManager.beginTransaction()
                    .remove(faqsFragment)
                    .commit()
                faqsToggleButton.setImageResource(R.drawable.faqs_btn)
                false
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, faqsFragment)
                    .commit()
                true
            }
        }
}

    // Set up Chip navigation
    private fun setUpTabBar() {
        binding.bottomNavBar.setOnItemSelectedListener {
            when (it) {
                R.id.you -> replaceFragment(YouFragment())
                R.id.friends -> replaceFragment(FriendsFragment())
                R.id.food -> replaceFragment(FoodFragment())
            }
        }
    }

    // Change fragment when chip navigation is in use
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}


