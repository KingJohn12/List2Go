package com.example.list2go.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.list2go.ListAdapter
import com.example.list2go.ListItem
import com.example.list2go.R
import com.parse.ParseUser
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    // holds list of tasks
    var listOfItems = mutableListOf<ListItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // creates variable reference here that will be initialized later
        lateinit var adapter: ListAdapter


            // Lookup the recyclerview in activity layout
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            // Create adapter passing in the sample user data
            adapter = ListAdapter(listOfItems)
            // Attach the adapter to the recyclerview to populate items
            recyclerView.adapter = adapter
            // Set layout manager to position the items
            //recyclerView.layoutManager = LinearLayoutManager(this)

            // set up the button and input field so that the user can enter a task and add it to the list
            val inputItem = view.findViewById<EditText>(R.id.addItem)
            val inputQuantity = view.findViewById<EditText>(R.id.addQuantity)
            val inputPrice = view.findViewById<EditText>(R.id.addPrice)

            // get a reference to the button, and set an onClickListener
            view.findViewById<Button>(R.id.addButton).setOnClickListener {
                // grab text that user inputted into @id/addItem, @id/addQuantity, and @id/addPrice
                val userInputtedItem = inputItem.text.toString()
                val userInputtedQ = inputQuantity.text.toString()
                val userInputtedPrice = inputPrice.text.toString()
                // get current user
                val user = ParseUser.getCurrentUser()
                // reset text field
                inputItem.setText("")
                inputQuantity.setText("")
                inputPrice.setText("")
                // save items
                saveItems(userInputtedItem, userInputtedPrice.toBigDecimal(), userInputtedQ.toBigInteger(), user)
                // notify adapter that data has been updated
                adapter.notifyItemInserted(listOfItems.size - 1)
            }

    }

    // load tasks from profile
    fun loadItems() {

    }

    // save items
    fun saveItems(item: String, price: Number, quantity: Number,  user: ParseUser) {
        // create ListItem object
        val listItem = ListItem()
        // set item, price, quantity and user
        listItem.setItem(item)
        listItem.setPrice(price)
        listItem.setQuantity(quantity)
        listItem.setUser(user)
        // add string to list of tasks: listOfTasks
        listOfItems.add(listItem)
        // save
        listItem.saveInBackground { exception ->
            if (exception != null) {
                // something went wrong
                exception.printStackTrace()
            } else {
                // successful
            }

        }
    }
}