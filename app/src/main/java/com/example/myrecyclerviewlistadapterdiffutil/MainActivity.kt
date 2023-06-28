package com.example.myrecyclerviewlistadapterdiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myrecyclerviewlistadapterdiffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val catsData = CatsData()
        val adapter = CatAdapter()
        adapter.catList = catsData.catList
//        val layout = LinearLayoutManager(this)
//        val layout = StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL)
        val layout = GridLayoutManager(this, 4)
        binding.myRecyclerView.layoutManager = layout
        binding.myRecyclerView.adapter = adapter


    }
}