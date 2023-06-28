package com.example.myrecyclerviewlistadapterdiffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerviewlistadapterdiffutil.databinding.CatItemBinding

class CatAdapter : ListAdapter<Cat, CatAdapter.CardViewHolder>(DiffCallback()) {

    var catList = mutableListOf<Cat>()

    class CardViewHolder(var binding: CatItemBinding) : RecyclerView.ViewHolder(binding.root)

    class DiffCallback: DiffUtil.ItemCallback<Cat>() {
        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemCount() = catList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context) // создаем инфлейтер
        val binding = CatItemBinding.inflate(inflater, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val cat = catList[position]
        holder.binding.itemName.text = cat.name
        holder.binding.itemAge.text = cat.age.toString()
        holder.binding.itemPhoto.setImageResource(cat.photo)
        holder.binding.itemCard.setOnClickListener {
            Toast.makeText(holder.binding.root.context, cat.name, Toast.LENGTH_SHORT).show()
        }
    }

}