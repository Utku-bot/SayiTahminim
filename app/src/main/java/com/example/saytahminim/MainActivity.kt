package com.example.saytahminim

import android.content.Intent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.saytahminim.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if(binding.editTextNumber.text.toString()==""){
                Toast.makeText(this, "Lütfen sayı giriniz.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }
            val intent = Intent(this@MainActivity, Tahmin::class.java)
            val aralik = binding.editTextNumber.text.toString().toInt()
            intent.putExtra("aralık",aralik)
            startActivity(intent)


        }


    }
}