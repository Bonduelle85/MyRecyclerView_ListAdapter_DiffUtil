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

class PetAdapter : ListAdapter<Any, PetAdapter.CardViewHolder>(DiffCallback()) {

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
        var photo = when (binding) {
            is CatItemBinding -> (binding as CatItemBinding).itemPhoto
            is DogItemBinding -> (binding as DogItemBinding).itemPhoto
            else -> (binding as CatItemBinding).itemPhoto
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Any>() {
        override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
            when {
                oldItem is Cat && newItem is Cat -> {
                    return oldItem.catName == newItem.catName
                }

                oldItem is Dog && newItem is Dog -> {
                    return oldItem.dogName == newItem.dogName
                }
                else -> return false
            }
        }

        override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
            when {
                oldItem is Cat && newItem is Cat -> {
                    return (oldItem.catName == newItem.catName)
                            && (oldItem.catAge == newItem.catAge)
                            && (oldItem.catPhoto == newItem.catPhoto)
                }
                oldItem is Dog && newItem is Dog -> {
                    return (oldItem.dogName == newItem.dogName)
                            && (oldItem.dogAge == newItem.dogAge)
                            && (oldItem.dogPhoto == newItem.dogPhoto)
                }
                else -> return false
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
        return PetAdapter.CardViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        when (petList[position]) {
            is Dog -> return 1
            is Cat -> return 0
            else -> return super.getItemViewType(position)
        }
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val pet = petList[position]
        when (pet) {

            is Dog -> {
                holder.name.text = pet.dogName
                holder.age.text = pet.dogAge.toString()
                holder.photo.setImageResource(pet.dogPhoto)
            }
            is Cat -> {
                holder.name.text = pet.catName
                holder.age.text = pet.catAge.toString()
                holder.photo.setImageResource(pet.catPhoto)
            }
        }
    }
    fun filterList(newList: ArrayList<Any>) {
        petList = newList
        notifyDataSetChanged()
    }
}