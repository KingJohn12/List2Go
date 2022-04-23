package com.example.list2go

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.list2go.fragments.ListFragment
import com.example.list2go.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        // implementation of Bottom Navigation Bar
        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener{
                item ->

            var fragmentToShow: Fragment? = null
            when (item.itemId) {
                R.id.action_profile -> {
                    // navigate to profile screen
                    fragmentToShow = ProfileFragment()
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                }
                R.id.action_list -> {
                    // navigate to list screen
                    fragmentToShow = ListFragment()
                    Toast.makeText(this, "List", Toast.LENGTH_SHORT).show()
                }
                R.id.action_map -> {
                    // navigate to map screen
                    Toast.makeText(this, "Map", Toast.LENGTH_SHORT).show()
                }
                R.id.action_logout -> {
                    // navigate to profile screen
                    ParseUser.logOut()
                    val intent = Intent(this@MainActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }

            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }

            // return true to handle user interaction
            true
        }
        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_list


    }
}