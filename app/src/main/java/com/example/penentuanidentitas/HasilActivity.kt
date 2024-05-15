package com.example.penentuanidentitas

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginStart
import com.example.penentuanidentitas.databinding.ActivityHasilBinding

class HasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilBinding
    private var kalimat: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        view()
    }
    fun view(){
        kalimat = intent.getStringExtra("EXTRA_KALIMAT")
        var kalimat_split = kalimat?.split(" ")
        val (identitas,ciriAwal,ciriAkhir) = ProcessingKalimat.identitas(kalimat!!)
        Log.d("kalimat_split","$kalimat_split")
        binding.textViewKalimat.text = kalimat
        for ((index, kata) in identitas.withIndex()){
            if(index == 0){
                binding.textViewIdentitas6.text = identitas.get(index)
            }else if (index==1){
                binding.textViewIdentitas5.text = identitas.get(index)+" "
            }else if (index==2){
                binding.textViewIdentitas4.text = identitas.get(index)+" "
            }else if (index==3){
                binding.textViewIdentitas3.text = identitas.get(index)+" "
            }else if (index==4){
                binding.textViewIdentitas2.text = identitas.get(index)+" "
            }else if (index==5){
                binding.textViewIdentitas1.text = identitas.get(index)+" "
            }
        }

    }
}