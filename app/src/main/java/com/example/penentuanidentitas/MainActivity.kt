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
    }
    fun checkHarakat(kalimat:String){
        val kalimat_clear = kalimat.trimEnd()
        val kalimat_split = kalimat_clear.split(" ")
        if(!kalimat_clear.contains(" ")){
            Toast.makeText(this, "Silahkan Masukkan Kalimat!", Toast.LENGTH_LONG).show()
        }else{
            var harakat = true
            for ((index,kata) in kalimat_split.withIndex()){
                val panjang = kata.length
                if(kata.substring(panjang - 1, panjang)== "ْ" ||
                    kata.substring(panjang - 1, panjang)=="َ" ||
                    kata.substring(panjang - 1, panjang)== "ِ" ||
                    kata.substring(panjang - 1, panjang)== "ُ" ||
                    kata.substring(panjang - 1, panjang)=="ٍ" ||
                    kata.substring(panjang - 1, panjang)=="ٌ" ||
                    kata.substring(panjang - 1, panjang)=="ً"||
                    kata.substring(panjang - 2, panjang)=="ًا" ||
                    kata.substring(panjang - 3, panjang)=="وْا" ||
                    kata.substring(panjang - 2, panjang)=="َا"){
                    continue
                }else {
                    harakat = false
                    val katake = index+1
                    Toast.makeText(this, "Kata ke $katake tidak berharakat lengkap", Toast.LENGTH_LONG).show()
                }
            }
            if (harakat == true){
                val hasil_intent = Intent(this,HasilActivity::class.java)
                hasil_intent.putExtra("EXTRA_KALIMAT", kalimat_clear.toString())
                startActivity(hasil_intent)
            }
        }
    }
}
