package com.example.dailyfood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfood.R
import com.example.dailyfood.adapter.MenuAdapter
import com.example.dailyfood.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val menuItemName = listOf("Burger","Sandwich","Pizza","Meat Box","Sandwich11","Pizza11","Meat Box11")
    private val menuItemPrice = listOf("$6","$5","$10","$71","$51","$101","$71")
    private val menuItemImg = listOf(
        R.drawable.menu1,
        R.drawable.menu2,
        R.drawable.menu3,
        R.drawable.menu4,
        R.drawable.menu5,
        R.drawable.menu6,
        R.drawable.menu7,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val fileterMenuName = mutableListOf<String>()
    private val fileterMenuPrice = mutableListOf<String>()
    private val fileterMenuImg = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater,container,false)

        adapter = MenuAdapter(fileterMenuName,fileterMenuPrice,fileterMenuImg)
        binding.recylerViewMenu.layoutManager = LinearLayoutManager(requireContext())
        binding.recylerViewMenu.adapter = adapter

        setupSearchView()
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        fileterMenuName.clear()
        fileterMenuPrice.clear()
        fileterMenuImg.clear()
        fileterMenuName.addAll(menuItemName)
        fileterMenuPrice.addAll(menuItemPrice)
        fileterMenuImg.addAll(menuItemImg)
        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                fielterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                fielterMenuItems(newText)
                return true
            }
        })
    }

    private fun fielterMenuItems(query: String) {
        fileterMenuName.clear()
        fileterMenuPrice.clear()
        fileterMenuImg.clear()

        menuItemName.forEachIndexed { index, foodName ->
            if (foodName.contains(query.toString(),ignoreCase = true)){
                fileterMenuName.add(foodName)
                fileterMenuPrice.add(menuItemPrice[index])
                fileterMenuImg.add(menuItemImg[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}