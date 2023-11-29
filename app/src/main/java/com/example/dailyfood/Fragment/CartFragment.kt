package com.example.dailyfood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfood.R
import com.example.dailyfood.adapter.CartAdapter
import com.example.dailyfood.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater,container,false)
        dummydata()
        return binding.root
    }

    private fun dummydata() {
        val cartItemName = listOf("Burger","Sandwich","Pizza","Meat Box","Sandwich11","Pizza11","Meat Box11")
        val cartItemPrice = listOf("$6","$5","$10","$71","$51","$101","$71")
        val cartItemImg = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7,
        )
        val adapter = CartAdapter(ArrayList(cartItemName),ArrayList(cartItemPrice),ArrayList(cartItemImg))
        binding.recylerViewCart.layoutManager = LinearLayoutManager(requireContext())
        binding.recylerViewCart.adapter = adapter
    }

    companion object {

    }
}