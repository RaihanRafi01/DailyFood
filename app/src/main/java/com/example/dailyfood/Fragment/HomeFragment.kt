package com.example.dailyfood.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.dailyfood.R
import com.example.dailyfood.adapter.PopularAdapter
import com.example.dailyfood.databinding.FragmentHomeBinding

class homeFragment : Fragment() {
private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        onClickActivity()
        return binding.root
    }

    private fun onClickActivity() {
        binding.btnMenu.setOnClickListener {
            MenuBottomSheetFragment().show(parentFragmentManager,"Menu")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgList = ArrayList<SlideModel>()
        imgList.add(SlideModel(R.drawable.banner1,ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.banner2,ScaleTypes.FIT))
        imgList.add(SlideModel(R.drawable.banner3,ScaleTypes.FIT))
        val imgSlider = binding.imageSlider
        imgSlider.setImageList(imgList,ScaleTypes.FIT)
        imgSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imgList[position]
                val itemMsg = "Selected Image $position"
                Toast.makeText(requireContext(),itemMsg,Toast.LENGTH_SHORT).show()
            }
        })

        val popularFoodName = listOf("Burger","Sandwich","Pizza","Meat Box")
        val popularFoodPrice = listOf("$6","$5","$10","$7")
        val popularFoodImg = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,R.drawable.menu4)
        binding.recyclerViewPopular.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewPopular.adapter = PopularAdapter(popularFoodName,popularFoodPrice,popularFoodImg,requireContext())
    }

}