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
import com.example.list2go.R


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // holds list of tasks
        var listOfTasks = mutableListOf<String>()
        // creates variable reference here that will be initialized later
        lateinit var adapter: ListAdapter

            // variable for onClickListener
            val onLongClickListener = object : ListAdapter.OnLongClickListener {
                override fun onItemLongClicked(position: Int) {
                    // remove item from list
                    listOfTasks.removeAt(position)
                    // notify adapter that data set has changed
                    adapter.notifyItemRemoved(position)
                    // check for action in Logcat
                    // Log.i("Caren", "Trying to remove")
                    // save new list of items
                }

            }

            // Fake list of tasks
            listOfTasks.add("Do laundry")
            listOfTasks.add("Go for a walk")


            // Lookup the recyclerview in activity layout
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            // Create adapter passing in the sample user data
            adapter = ListAdapter(listOfTasks, onLongClickListener)
            // Attach the adapter to the recyclerview to populate items
            recyclerView.adapter = adapter
            // Set layout manager to position the items
            //recyclerView.layoutManager = LinearLayoutManager(this)

            // set up the button and input field so that the user can enter a task and add it to the list
            val inputTestField = view.findViewById<EditText>(R.id.addItem)

            // get a reference to the button, and set an onClickListener
            view.findViewById<Button>(R.id.addButton).setOnClickListener {
                // grab test that user inputted into @id/addTaskField
                val userInputtedTask = inputTestField.text.toString()
                // add string to list of tasks: listOfTasks
                listOfTasks.add(userInputtedTask)
                // notify adapter that data has been updated
                adapter.notifyItemInserted(listOfTasks.size - 1)
                // reset text field
                inputTestField.setText("")
            }

    }
    // Save the data that the user has inputted

    // load tasks from profile
    fun loadItems() {

    }

    // save items
    fun saveItems() {

    }
}