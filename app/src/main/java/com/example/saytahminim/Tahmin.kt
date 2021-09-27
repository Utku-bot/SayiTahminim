package com.example.saytahminim

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.saytahminim.databinding.ActivityTahminBinding




class Tahmin : AppCompatActivity() {
    private lateinit var binding: ActivityTahminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTahminBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val aralik = intent.getIntExtra("aralık",100)

        var hak = 5
        val sayi = (0..aralik).random()
        var tahmin: Int


        binding.button2.setOnClickListener {
            if (binding.editText.text.toString() == "") {
                Toast.makeText(this, "Lütfen sayı giriniz.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            tahmin = binding.editText.text.toString().toInt()
            if (tahmin == sayi) {
                val intent = Intent(
                    this, Sonuc::class.java
                )
                intent.putExtra("sonuc", true)
                intent.putExtra("rakam", sayi)
                finish()


                startActivity(intent)
            }

            if (tahmin < sayi) {
                binding.textView3.text = "Arttır"
                hak--
                binding.textView2.text = "Kalan hak : $hak"

            }
            if (tahmin > sayi) {
                binding.textView3.text = "Azalt"
                hak--
                binding.textView2.text = "Kalan hak : $hak"

            }
            if (hak == 0) {
                val intent = Intent(
                    this, Sonuc::class.java
                )
                intent.putExtra("sonuc", false)
                intent.putExtra("rakam", sayi)
                finish()

                startActivity(intent)
            }

        }


    }

}