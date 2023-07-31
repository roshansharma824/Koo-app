package com.example.kooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kooapp.adapter.DataListAdapter
import com.example.kooapp.databinding.ActivityMainBinding
import com.example.kooapp.pojo.PostItem

import com.example.kooapp.pojo.Status
import com.example.kooapp.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DataListAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initRecyclerView()
        setupObserver()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DataListAdapter(arrayListOf())
        binding.recyclerView.adapter = adapter
    }
    private fun setupObserver() {
        mainViewModel.getDataList().observe(this, {
            when (it.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { data ->
                        renderList(data)

                    }
                    binding.recyclerView.visibility = View.VISIBLE

                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    private fun renderList(dataList: List<PostItem>) {
        adapter.addData(dataList)
        adapter.notifyDataSetChanged()
    }
}