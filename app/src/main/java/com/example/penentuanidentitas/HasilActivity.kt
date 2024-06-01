package com.example.penentuanidentitas

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginStart
import com.example.penentuanidentitas.databinding.ActivityHasilBinding
import android.view.ViewGroup

class HasilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHasilBinding
    private var kalimat: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHasilBinding.inflate(layoutInflater)
        setContentView(binding.root)
        view_kedudukan()
    }
    fun view_kedudukan(){
        kalimat = intent.getStringExtra("EXTRA_KALIMAT")
        var kalimat_split = kalimat?.split(" ")
        val (identitas,ciriAwal,ciriAkhir) = ProcessingKalimat.findingIdentitas(kalimat!!)
        val (irab, tanda_irab) = ProcessingKalimat.findingIrab(kalimat!!,identitas,ciriAkhir)
        val kedudukan = ProcessingKalimat.findingKedudukan(kalimat!!,identitas,irab)
        for ((index, text) in kalimat_split!!.withIndex()){
            when(index){
                0->{
                    binding.textViewHasil6.text = text
                    binding.textViewHasil6.setTextColor(Color.GREEN)
                    binding.textViewHasil6.setTextSize(25f)
                    val margin = binding.textViewHasil6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil6.layoutParams = margin
                }
                1->{
                    binding.textViewHasil5.text = text
                    val margin = binding.textViewHasil5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil5.layoutParams = margin
                    binding.textViewHasil5.setTextSize(25f)
                    binding.textViewHasil5.setTextColor(Color.CYAN)
                }
                2->{
                    binding.textViewHasil4.text = text
                    val margin = binding.textViewHasil4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil4.layoutParams = margin
                    binding.textViewHasil4.setTextSize(25f)
                    binding.textViewHasil4.setTextColor(Color.rgb(173,216,230))
                }
                3->{
                    binding.textViewHasil3.text = text
                    val margin = binding.textViewHasil3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil3.layoutParams = margin
                    binding.textViewHasil3.setTextSize(25f)
                    binding.textViewHasil3.setTextColor(Color.rgb(39,211,254))
                }
                4->{
                    binding.textViewHasil2.text = text
                    val margin = binding.textViewHasil2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil2.layoutParams = margin
                    binding.textViewHasil2.setTextSize(25f)
                    binding.textViewHasil2.setTextColor(Color.LTGRAY)
                }
                5->{
                    binding.textViewHasil1.text = text
                    binding.textViewHasil1.setTextSize(25f)
                    binding.textViewHasil1.setTextColor(Color.MAGENTA)
                }
            }
        }
        for ((index, kata_) in identitas.withIndex()){
            val kata = kata_.replace(" ","\n")
            when (index){
                0->{
                    binding.textViewIdentitas6.text = kata
                    binding.textViewIdentitas6.setBackgroundColor(Color.GREEN)
                    binding.textViewIdentitas6.setTextSize(16f)
                    val margin = binding.textViewIdentitas6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas6.layoutParams = margin
                }
                1->{
                    binding.textViewIdentitas5.text = kata
                    val margin = binding.textViewIdentitas5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas5.layoutParams = margin
                    binding.textViewIdentitas5.setTextSize(16f)
                    binding.textViewIdentitas5.setBackgroundColor(Color.CYAN)
                }
                2->{
                    binding.textViewIdentitas4.text = kata
                    val margin = binding.textViewIdentitas4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas4.layoutParams = margin
                    binding.textViewIdentitas4.setTextSize(16f)
                    binding.textViewIdentitas4.setBackgroundColor(Color.rgb(173,216,230))
                }3->{
                    binding.textViewIdentitas3.text = kata
                    binding.textViewIdentitas3.setTextSize(16f)
                    val margin = binding.textViewIdentitas3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas3.layoutParams = margin
                    binding.textViewIdentitas3.setBackgroundColor(Color.rgb(39,211,254))
                }4->{
                    binding.textViewIdentitas2.text = kata
                    binding.textViewIdentitas2.setTextSize(16f)
                    val margin = binding.textViewIdentitas2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas2.layoutParams = margin
                    binding.textViewIdentitas2.setBackgroundColor(Color.LTGRAY)
                }5->{
                    binding.textViewIdentitas1.text = kata
                    binding.textViewIdentitas1.setTextSize(16f)
                    binding.textViewIdentitas1.setBackgroundColor(Color.MAGENTA)
                }
            }
        }
        for ((index, irab__) in irab.withIndex()){
            val irab_:String
            when (irab__){
                "Mengikuti Irab Sebelumnya" ->when(irab[index-1]){
                    "Mabni" -> irab_ = irab[index-2]
                    else-> irab_ = irab[index-1]
                }
                else->irab_ = irab__.replace(" ","\n")
            }
            when (index){
                0->{
                    binding.textViewIrab6.text = irab_
                    binding.textViewIrab6.setBackgroundColor(Color.GREEN)
                    binding.textViewIrab6.setTextSize(16f)
                    val margin = binding.textViewIrab6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab6.layoutParams = margin
                }
                1->{
                    binding.textViewIrab5.text = irab_
                    val margin = binding.textViewIrab5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab5.layoutParams = margin
                    binding.textViewIrab5.setTextSize(16f)
                    binding.textViewIrab5.setBackgroundColor(Color.CYAN)
                }
                2->{
                    binding.textViewIrab4.text = irab_
                    val margin = binding.textViewIrab4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab4.layoutParams = margin
                    binding.textViewIrab4.setTextSize(16f)
                    binding.textViewIrab4.setBackgroundColor(Color.rgb(173,216,230))
                }
                3->{
                    binding.textViewIrab3.text = irab_
                    val margin = binding.textViewIrab3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab3.layoutParams = margin
                    binding.textViewIrab3.setTextSize(16f)
                    binding.textViewIrab3.setBackgroundColor(Color.rgb(39,211,254))
                }
                4->{
                    binding.textViewIrab2.text = irab_
                    val margin = binding.textViewIrab2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab2.layoutParams = margin
                    binding.textViewIrab2.setTextSize(16f)
                    binding.textViewIrab2.setBackgroundColor(Color.LTGRAY)
                }
                5->{
                    binding.textViewIrab1.text = irab_
                    binding.textViewIrab1.setTextSize(16f)
                    binding.textViewIrab1.setBackgroundColor(Color.MAGENTA)
                }
            }
        }
        for((index,posisi_) in kedudukan.withIndex()){
            val posisi = posisi_.replace(" ","\n")
            when(index){
                0->{
                    binding.textViewKedudukan6.text = posisi
                    binding.textViewKedudukan6.setBackgroundColor(Color.GREEN)
                    binding.textViewKedudukan6.setTextSize(16f)
                    val margin = binding.textViewKedudukan6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan6.layoutParams = margin
                }
                1->{
                    binding.textViewKedudukan5.text = posisi
                    val margin = binding.textViewKedudukan5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan5.layoutParams = margin
                    binding.textViewKedudukan5.setTextSize(16f)
                    binding.textViewKedudukan5.setBackgroundColor(Color.CYAN)
                }
                2->{
                    binding.textViewKedudukan4.text = posisi
                    val margin = binding.textViewKedudukan4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan4.layoutParams = margin
                    binding.textViewKedudukan4.setTextSize(16f)
                    binding.textViewKedudukan4.setBackgroundColor(Color.rgb(173,216,230))
                }
                3->{
                    binding.textViewKedudukan3.text = posisi
                    val margin = binding.textViewKedudukan3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan3.layoutParams = margin
                    binding.textViewKedudukan3.setTextSize(16f)
                    binding.textViewKedudukan3.setBackgroundColor(Color.rgb(39,211,254))
                }
                4->{
                    binding.textViewKedudukan2.text = posisi
                    val margin = binding.textViewKedudukan2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan2.layoutParams = margin
                    binding.textViewKedudukan2.setTextSize(16f)
                    binding.textViewKedudukan2.setBackgroundColor(Color.LTGRAY)
                }
                5->{
                    binding.textViewKedudukan1.text = posisi
                    binding.textViewKedudukan1.setTextSize(16f)
                    binding.textViewKedudukan1.setBackgroundColor(Color.MAGENTA)
                }
            }
        }
    }
}