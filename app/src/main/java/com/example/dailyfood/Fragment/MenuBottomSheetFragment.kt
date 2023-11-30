package com.example.dailyfood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfood.R
import com.example.dailyfood.adapter.CartAdapter
import com.example.dailyfood.adapter.MenuAdapter
import com.example.dailyfood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)
        dummyData()
        binding.btnbackMenu.setOnClickListener {
            dismiss()
        }
        return binding.root
    }

    private fun dummyData() {
        val cartItemName = listOf("Burger","Sandwich","Pizza","Meat Box","Sandwich11","Pizza11","Meat Box11","Burger","Sandwich","Pizza","Meat Box","Sandwich11","Pizza11","Meat Box11")
        val cartItemPrice = listOf("$6","$5","$10","$71","$51","$101","$71","$6","$5","$10","$71","$51","$101","$71")
        val cartItemImg = listOf(
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7,
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7,
        )
        val adapter = MenuAdapter(ArrayList(cartItemName),ArrayList(cartItemPrice),ArrayList(cartItemImg))
        binding.recylerViewMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.recylerViewMenu.adapter = adapter
    }

    companion object {

    }
}