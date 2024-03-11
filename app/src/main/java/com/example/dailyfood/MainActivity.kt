package com.example.dailyfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dailyfood.Fragment.NotificationFragment
import com.example.dailyfood.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setupWithNavController(findNavController(R.id.fragmentContainerView))
        onClickButton()
    }
    private fun onClickButton() {
       binding.btnNotification.setOnClickListener {
           val bottomsheetDialog = NotificationFragment()
           bottomsheetDialog.show(supportFragmentManager,"Test")
       }
    }
}