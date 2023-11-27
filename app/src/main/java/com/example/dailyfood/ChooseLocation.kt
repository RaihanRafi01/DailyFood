package com.example.dailyfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.dailyfood.databinding.ActivityChooseLocationBinding

class ChooseLocation : AppCompatActivity() {
    private lateinit var binding: ActivityChooseLocationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseLocationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val locationList : Array<String> = arrayOf("Rampura","Khilgaon","Badda","Malibagh")
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,locationList)
        val autoCompleteTxtView = binding.listoflocation
        autoCompleteTxtView.setAdapter(adapter)
    }
}