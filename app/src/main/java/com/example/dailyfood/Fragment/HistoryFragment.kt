package com.example.dailyfood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfood.R
import com.example.dailyfood.adapter.BuyAgainAdapter
import com.example.dailyfood.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter : BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecylerView()
        return binding.root
    }

    private fun setupRecylerView() {
        val buyAgainItemName = arrayListOf("Burger","Sandwich","Pizza")
        val buyAgainItePrice = arrayListOf("$3","$5","$10")
        val buyAgainItemImg = arrayListOf(R.drawable.menu5,R.drawable.menu2,R.drawable.menu3)
        buyAgainAdapter = BuyAgainAdapter(buyAgainItemName,buyAgainItePrice,buyAgainItemImg)
        binding.recylerViewBuyAgain.adapter = buyAgainAdapter
        binding.recylerViewBuyAgain.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {

    }
}