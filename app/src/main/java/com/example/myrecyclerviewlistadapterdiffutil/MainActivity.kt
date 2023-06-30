package com.example.myrecyclerviewlistadapterdiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myrecyclerviewlistadapterdiffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var petData: PetData
    lateinit var adapter: PetAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        petData = PetData()
        adapter = PetAdapter()
        adapter.petList = petData.petList
        val layout = GridLayoutManager(this, 4)
        binding.myRecyclerView.layoutManager = layout
        binding.myRecyclerView.adapter = adapter

        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem? = menu?.findItem(R.id.actionSearch)
        val searchView: SearchView = searchItem?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                filter(s)
                return false
            }
        })
        return true
    }

    private fun filter(text: String) {

        val newList: ArrayList<Any> = ArrayList()


        for (item in petData.petList) {
            when (item) {
                is Dog -> {
                    if (item.dogName.lowercase().contains(text.lowercase())) {
                        newList.add(item)
                    }
                }
                is Cat -> {
                    if (item.catName.lowercase().contains(text.lowercase())) {
                        newList.add(item)
                    }
                }
            }
        }
        if (newList.isEmpty()) {
            Toast.makeText(this, "No Pet Found..", Toast.LENGTH_SHORT).show()
        } else {

            adapter.filterList(newList)
        }
    }

}