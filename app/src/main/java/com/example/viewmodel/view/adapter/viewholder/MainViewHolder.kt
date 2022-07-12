package com.example.viewmodel.view.adapter.viewholder

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.databinding.CardListUiBinding
import com.example.viewmodel.model.data.CardModel
import com.example.viewmodel.viewmodel.CardViewModel

class MainViewHolder (val binding : CardListUiBinding, var viewModel : CardViewModel) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CardModel) = with(binding) {
        binding.cardModel = data
        button.setOnClickListener{
            viewModel.deleteData(data.num)
        }
    }
}