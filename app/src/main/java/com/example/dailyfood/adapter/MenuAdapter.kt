package com.example.dailyfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfood.databinding.PopularItemBinding

class MenuAdapter(private val menuItems : MutableList<String>,private val menuItemPrice : MutableList<String>,private val menuItemImg : MutableList<Int>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = menuItems.size
    inner class MenuViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                popularFoodName.text = menuItems[position]
                popularFoodPrice.text = menuItemPrice[position]
                imgPopularItem.setImageResource(menuItemImg[position])
            }
        }

    }
}