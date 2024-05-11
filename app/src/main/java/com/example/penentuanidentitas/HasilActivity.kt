package com.example.penentuanidentitas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.penentuanidentitas.databinding.ActivityHasilBinding

class HasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilBinding
    val kalimat = intent.getStringExtra("EXTRA_KALIMAT")
    val kalimat_split = intent.getStringArrayExtra("EXTRA_KALIMAT_SPLIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        view()
    }
    fun view(){
        binding.textViewKalimat.text = kalimat
//        binding.textViewIdentitas1.text = kalimat_split?.get(0) ?: "none"
    }
}