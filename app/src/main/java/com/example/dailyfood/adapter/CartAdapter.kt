package com.example.dailyfood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyfood.databinding.CartItemBinding
class CartAdapter(private val cartItems : MutableList<String>,private val cartItemPrice : MutableList<String>,private val cartItemImg : MutableList<Int>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    private val itemQuantity = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = cartItems.size
    inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                txtCardFoodName.text = cartItems[position]
                txtCardItemPrice.text = cartItemPrice[position]
                imgCartFood.setImageResource(cartItemImg[position])
                txtCartItemQuantity.text = itemQuantity[position].toString()
                btnCartMinus.setOnClickListener {
                    decrease(position)
                }
                btnCartPlus.setOnClickListener {
                    increase(position)
                }
                btnCartDel.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION){
                        delete(position)
                    }
                }
            }
        }
        private fun decrease(position: Int){
            if (itemQuantity[position]>0){
                itemQuantity[position]--
                binding.txtCartItemQuantity.text = itemQuantity[position].toString()
            }
        }
        private fun increase(position: Int){
            if (itemQuantity[position]<20){
                itemQuantity[position]++
                binding.txtCartItemQuantity.text = itemQuantity[position].toString()
            }
        }
        private fun delete(position: Int){
            cartItems.removeAt(position)
            cartItemPrice.removeAt(position)
            cartItemImg.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,cartItems.size)
        }

    }

}