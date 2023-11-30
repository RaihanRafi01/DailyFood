package com.example.dailyfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfood.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainItemName : ArrayList<String>,private val buyAgainItemPrice : ArrayList<String>,private val buyAgainItemImg: ArrayList<Int>)
    : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding = BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        holder.bind(buyAgainItemName[position],buyAgainItemPrice[position],buyAgainItemImg[position])
    }
    override fun getItemCount(): Int = buyAgainItemName.size
    class BuyAgainViewHolder (private val binding : BuyAgainItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(name: String, price: String, img: Int) {
            binding.txtBuyAgainName.text = name
            binding.txtBuyAgainPrice.text = price
            binding.imgBuyAgain.setImageResource(img)
        }

    }

}