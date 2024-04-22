package com.rgbstudios.cxrslides

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.rgbstudios.cxrslides.adapter.TestSlideAdapter
import com.rgbstudios.cxrslides.data.Datasource
import com.rgbstudios.cxrslides.databinding.ActivityStudyBinding

class TestActivity : AppCompatActivity() {
    companion object {
        const val SEARCH_PREFIX = "https://www.google.com/search?tbm=isch&q="
        const val SUFFIX = " radiological slides"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityStudyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize data and pass into the adapter
        val myDataset = Datasource.slides

        // recyclerView
        val recyclerView = binding.studyRecyclerView
        recyclerView.adapter = TestSlideAdapter(this, myDataset)

        // Specify fixed size to improve performance
        binding.studyRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}