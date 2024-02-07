package com.example.dailyfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dailyfood.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding  : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val foodName = intent.getStringExtra("MenuItemName")
        val foodImg = intent.getIntExtra("MenuItemImg",0)
        binding.txtDetailsFoodName.text = foodName
        binding.imgDetailsFoodImg.setImageResource(foodImg)
        binding.btnDetailsBack.setOnClickListener {
            finish()
        }
    }
}