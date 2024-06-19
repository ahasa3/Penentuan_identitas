package com.example.penentuanidentitas

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.penentuanidentitas.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import android.content.Intent
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonProcess.setOnClickListener {
            val kalimat = binding.textInputUser.text.toString()
            checkHarakat(kalimat)
        }
        binding.imageViewInfo.setOnClickListener {
            val info_intent = Intent(this, aboutActivity::class.java)
            startActivity(info_intent)
        }
        binding.imageViewBook.setOnClickListener {
            val book_intent = Intent(this, KitabViewActivity::class.java)
            startActivity(book_intent)
        }
    }
    fun checkHarakat(kalimat: String) {
        val kalimat_clear = kalimat.trim()
        if (kalimat_clear.isNotEmpty()) {
            val kalimat_split = kalimat_clear.split(" ")
            val harakat = listOf("ْ","َ", "ِ", "ُ","ٍ","ٌ", "ً", "ًا", "وْا", "َا","ى")
            var isHarakatComplete = true
            for ((index, kata) in kalimat_split.withIndex()) {
                val lastChar = kata.takeLast(1)
                val lastTwoChars = kata.takeLast(2)
                val lastThreeChars = kata.takeLast(3)
                if (lastChar !in harakat && lastTwoChars !in harakat && lastThreeChars !in harakat) {
                    isHarakatComplete = false
                    val katake = index + 1
                    Toast.makeText(this, "Kata ke $katake tidak berharakat lengkap", Toast.LENGTH_LONG).show()
                    break
                }
            }
            if (kalimat_split.size < 2){
                Toast.makeText(this, "Kalimat harus lebih dari 2 kata", Toast.LENGTH_LONG).show()
            }
            else if (kalimat_split.size > 6) {
                Toast.makeText(this, "Kalimat tidak boleh lebih dari 6 kata", Toast.LENGTH_LONG).show()
            }
            else if (isHarakatComplete) {
                val hasil_intent = Intent(this, HasilActivity::class.java).apply {
                    putExtra("EXTRA_KALIMAT", kalimat_clear)
                }
                startActivity(hasil_intent)
            }
        } else {
            Toast.makeText(this, "Silahkan Masukkan Kalimat!", Toast.LENGTH_LONG).show()
        }
    }
}
