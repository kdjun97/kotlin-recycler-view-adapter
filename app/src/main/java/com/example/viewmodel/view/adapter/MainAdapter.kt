package com.example.viewmodel.view.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.databinding.CardListUiBinding
import com.example.viewmodel.model.data.CardModel
import com.example.viewmodel.view.adapter.viewholder.MainViewHolder
import com.example.viewmodel.viewmodel.CardViewModel

class MainAdapter (private val context : Context, var viewModel : CardViewModel) : RecyclerView.Adapter<MainViewHolder>(){
    var data = ArrayList<CardModel>()
    lateinit var binding : CardListUiBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        binding = CardListUiBinding.inflate(
            LayoutInflater.from(context), parent, false)

        return MainViewHolder(binding, viewModel)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(data[position])
    }

}