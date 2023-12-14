package com.example.dailyfood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfood.DetailsActivity
import com.example.dailyfood.databinding.PopularItemBinding

class PopularAdapter(private val items:List<String>,private val prices:List<String>,private val imgs:List<Int>,private val requireContext: Context) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val img = imgs[position]
        val price = prices[position]
        holder.bind(item,price,img)
        holder.itemView.setOnClickListener {
            val iDetails = Intent(requireContext, DetailsActivity::class.java)
            iDetails.putExtra("MenuItemName",item)
            iDetails.putExtra("MenuItemImg",img)
            requireContext.startActivity(iDetails)
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    class PopularViewHolder(private val binding: PopularItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String,price: String, img: Int) {
            binding.popularFoodName.text = item
            binding.popularFoodPrice.text = price
            binding.imgPopularItem.setImageResource(img)
            //binding.btnPopularAddToCart.text = "hiiiii"
        }
    }
}