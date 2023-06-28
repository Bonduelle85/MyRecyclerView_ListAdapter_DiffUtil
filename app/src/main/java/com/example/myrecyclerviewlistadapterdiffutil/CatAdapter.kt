package com.example.myrecyclerviewlistadapterdiffutil

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.myrecyclerviewlistadapterdiffutil.databinding.CatItemBinding
import com.example.myrecyclerviewlistadapterdiffutil.databinding.DogItemBinding

class CatAdapter : ListAdapter<Any, CatAdapter.CardViewHolder>(DiffCallback()) {

    var petList = mutableListOf<Any>()

    class CardViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {
        var name = when (binding) {
            is DogItemBinding -> (binding as DogItemBinding).itemName
            is CatItemBinding -> (binding as CatItemBinding).itemName
            else -> (binding as CatItemBinding).itemName
        }
        var age = when (binding) {
            is CatItemBinding -> (binding as CatItemBinding).itemAge
            is DogItemBinding -> (binding as DogItemBinding).itemAge
            else -> (binding as CatItemBinding).itemAge
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            return when {
                oldItem is Cat && newItem is Cat -> {
                    oldItem.name == newItem.name
                }

                oldItem is Dog && newItem is Dog -> {
                    oldItem.nickName == newItem.nickName
                }

                else -> false
            }
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            return when {
                oldItem is Cat && newItem is Cat -> {
                    oldItem == newItem
                }

                oldItem is Dog && newItem is Dog -> {
                    oldItem == newItem
                }

                else -> false
            }
        }
    }

    override fun getItemCount() = petList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
//        val catItemBinding = CatItemBinding.inflate(inflater, parent, false)
        val binding: ViewBinding =
            when (viewType) {
                0 -> CatItemBinding.inflate(inflater, parent, false)
                1 -> DogItemBinding.inflate(inflater, parent, false)
                else -> CatItemBinding.inflate(inflater, parent, false)
            }
        return CatAdapter.CardViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return when (petList[position]) {
            is Dog -> 1
            is Cat -> 0
            else -> super.getItemViewType(position)
        }
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val pet = petList[position]
        when (pet) {

            is Dog -> {
                holder.name.text = pet.nickName
                holder.age.text = pet.age.toString()
            }

            is Cat -> {
                holder.name.text = pet.name
                holder.age.text = pet.age.toString()
            }
        }
    }
}