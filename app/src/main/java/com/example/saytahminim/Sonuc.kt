package com.example.saytahminim

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.saytahminim.databinding.ActivitySonucBinding

class Sonuc : AppCompatActivity() {
    private lateinit var binding: ActivitySonucBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySonucBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sonuc = intent.getBooleanExtra("sonuc",false)
        val rakam = intent.getIntExtra("rakam",0)

        if(sonuc==false){
            binding.imageView3.setImageResource(R.drawable.sad)
            binding.textView4.text = "Kazanamadın Rakam Buydu  $rakam"

        }
        else{
            binding.imageView3.setImageResource(R.drawable.smile)
            binding.textView4.text = "Kazandın"


        }


        binding.button3.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }


    }


}