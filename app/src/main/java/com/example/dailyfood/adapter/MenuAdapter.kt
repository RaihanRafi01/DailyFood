package com.example.dailyfood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfood.DetailsActivity
import com.example.dailyfood.databinding.PopularItemBinding

class MenuAdapter(private val menuItems : MutableList<String>,private val menuItemPrice : MutableList<String>,private val menuItemImg : MutableList<Int>,private val requireContext : Context) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val itemClickListener : OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = menuItems.size
    inner class MenuViewHolder (private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                val iDetails = Intent(requireContext,DetailsActivity::class.java)
                iDetails.putExtra("MenuItemName",menuItems.get(position))
                iDetails.putExtra("MenuItemImg",menuItemImg.get(position))
                requireContext.startActivity(iDetails)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                popularFoodName.text = menuItems[position]
                popularFoodPrice.text = menuItemPrice[position]
                imgPopularItem.setImageResource(menuItemImg[position])
            }
        }

    }
    interface OnClickListener {
        fun onItemClick(position: Int){
        }
    }
}


