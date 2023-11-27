package com.example.dailyfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dailyfood.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtDontHaveAccount.setOnClickListener {
            val iReg = Intent(this,RegistrationActivity::class.java)
            startActivity(iReg)
        }
        binding.btnLogin.setOnClickListener {
            val itest = Intent(this,ChooseLocation::class.java)
            startActivity(itest)
        }
    }
}