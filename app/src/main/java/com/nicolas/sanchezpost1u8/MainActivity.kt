package com.nicolas.sanchezpost1u8

import android.os.Bundle
import android.os.Trace
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicolas.sanchezpost1u8.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ProductViewModel by viewModels()
    private val adapter = ProductAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        viewModel.products.observe(this) { products ->
            Trace.beginSection("submitList_optimized")
            adapter.submitList(products)
            Trace.endSection()
        }

        viewModel.startUpdates()
    }

    override fun onDestroy() {
        binding.recyclerView.adapter = null
        super.onDestroy()
    }
}
