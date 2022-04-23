package com.example.list2go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // implementation of Bottom Navigation Bar
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener{
                item ->

            when (item.itemId) {
                R.id.action_profile -> {
                    // navigate to profile screen
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
                R.id.action_list -> {
                    // navigate to list screen
                    Toast.makeText(this, "List", Toast.LENGTH_SHORT).show()
                }
                R.id.action_map -> {
                    // navigate to map screen
                    Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()
                }

            }

            // return true to handle user interaction
            true
        }
        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_list


    }
}