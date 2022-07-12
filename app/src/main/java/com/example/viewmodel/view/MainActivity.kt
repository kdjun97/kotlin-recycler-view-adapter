package com.example.viewmodel.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewmodel.R
import com.example.viewmodel.databinding.ActivityMainBinding
import com.example.viewmodel.model.data.CardModel
import com.example.viewmodel.view.adapter.MainAdapter
import com.example.viewmodel.viewmodel.CardViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var viewModel : CardViewModel
    private lateinit var adapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.activity = this@MainActivity

        viewModel = ViewModelProvider(this).get(CardViewModel::class.java)

        adapter = MainAdapter(this, viewModel)
        binding.recyclerviewId.layoutManager = LinearLayoutManager(this)
        binding.recyclerviewId.adapter = adapter


        observeData()
    }

    fun observeData() {
        viewModel.fetchData().observe(
            this, Observer {
                adapter.data = viewModel.mutableData.value as ArrayList<CardModel>
                adapter.notifyDataSetChanged()
                Log.d("[ObserveData]", "값 바뀐거 감지!")
            }
        )
    }

    fun btnFloating(view : View) {
        Log.d("[FloatingButton]", "버튼을 클릭하셨습니다!")
        viewModel.updateView()
    }
}