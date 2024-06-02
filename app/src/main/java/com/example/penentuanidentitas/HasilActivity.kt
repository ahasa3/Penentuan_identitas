package com.example.penentuanidentitas

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
        kalimat = intent.getStringExtra("EXTRA_KALIMAT")
        val kalimat_split = kalimat!!.split(" ")
        val (identitas,ciriAwal,ciriAkhir) = ProcessingKalimat.findingIdentitas(kalimat!!)
        val (irab, tanda_irab) = ProcessingKalimat.findingIrab(kalimat!!,identitas,ciriAkhir)
        val kedudukan = ProcessingKalimat.findingKedudukan(kalimat!!,identitas,irab)
        viewKedudukan(kalimat_split,identitas,irab,kedudukan)
        keterangan(kalimat_split,identitas,ciriAwal,ciriAkhir,irab,tanda_irab,kedudukan)
    }

    private fun viewKedudukan(kalimat_split:List<String>, identitas:MutableList<String>, irab:MutableList<String>, kedudukan:MutableList<String>){

        for ((index, text) in kalimat_split.withIndex()){
            when(index){
                0->{
                    binding.textViewHasil6.text = text
                    binding.textViewHasil6.setTextColor(getColor(R.color.index6))
                    binding.textViewHasil6.setTextSize(25f)
                    val margin = binding.textViewHasil6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil6.layoutParams = margin
                }
                1->{
                    binding.textViewHasil5.text = text
                    binding.textViewHasil5.setTextColor(getColor(R.color.index5))
                    val margin = binding.textViewHasil5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil5.layoutParams = margin
                    binding.textViewHasil5.setTextSize(25f)
                }
                2->{
                    binding.textViewHasil4.text = text
                    binding.textViewHasil4.setTextColor(getColor(R.color.index4))
                    val margin = binding.textViewHasil4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil4.layoutParams = margin
                    binding.textViewHasil4.setTextSize(25f)
                }
                3->{
                    binding.textViewHasil3.text = text
                    binding.textViewHasil3.setTextColor(getColor(R.color.index3))
                    val margin = binding.textViewHasil3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil3.layoutParams = margin
                    binding.textViewHasil3.setTextSize(25f)
                }
                4->{
                    binding.textViewHasil2.text = text
                    binding.textViewHasil2.setTextColor(getColor(R.color.index2))
                    val margin = binding.textViewHasil2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewHasil2.layoutParams = margin
                    binding.textViewHasil2.setTextSize(25f)
                }
                5->{
                    binding.textViewHasil1.text = text
                    binding.textViewHasil1.setTextColor(getColor(R.color.index1))
                    binding.textViewHasil1.setTextSize(25f)
                }
            }
        }
        for ((index, kata_) in identitas.withIndex()){
            val kata = kata_.replace(" ","\n")
            when (index){
                0->{
                    binding.textViewIdentitas6.text = kata
                    binding.textViewIdentitas6.setBackgroundColor(getColor(R.color.index6))
                    binding.textViewIdentitas6.setTextSize(16f)
                    val margin = binding.textViewIdentitas6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas6.layoutParams = margin
                }
                1->{
                    binding.textViewIdentitas5.text = kata
                    binding.textViewIdentitas5.setBackgroundColor(getColor(R.color.index5))
                    val margin = binding.textViewIdentitas5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas5.layoutParams = margin
                    binding.textViewIdentitas5.setTextSize(16f)
                }
                2->{
                    binding.textViewIdentitas4.text = kata
                    binding.textViewIdentitas4.setBackgroundColor(getColor(R.color.index4))
                    val margin = binding.textViewIdentitas4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas4.layoutParams = margin
                    binding.textViewIdentitas4.setTextSize(16f)
                }3->{
                    binding.textViewIdentitas3.text = kata
                    binding.textViewIdentitas3.setBackgroundColor(getColor(R.color.index3))
                    binding.textViewIdentitas3.setTextSize(16f)
                    val margin = binding.textViewIdentitas3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas3.layoutParams = margin
                }4->{
                    binding.textViewIdentitas2.text = kata
                    binding.textViewIdentitas2.setBackgroundColor(getColor(R.color.index2))
                    binding.textViewIdentitas2.setTextSize(16f)
                    val margin = binding.textViewIdentitas2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIdentitas2.layoutParams = margin
                }5->{
                    binding.textViewIdentitas1.text = kata
                    binding.textViewIdentitas1.setBackgroundColor(getColor(R.color.index1))
                    binding.textViewIdentitas1.setTextSize(16f)
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
                    binding.textViewIrab6.setBackgroundColor(getColor(R.color.index6))
                    binding.textViewIrab6.setTextSize(20f)
                    val margin = binding.textViewIrab6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab6.layoutParams = margin
                }
                1->{
                    binding.textViewIrab5.text = irab_
                    binding.textViewIrab5.setBackgroundColor(getColor(R.color.index5))
                    val margin = binding.textViewIrab5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab5.layoutParams = margin
                    binding.textViewIrab5.setTextSize(20f)
                }
                2->{
                    binding.textViewIrab4.text = irab_
                    binding.textViewIrab4.setBackgroundColor(getColor(R.color.index4))
                    val margin = binding.textViewIrab4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab4.layoutParams = margin
                    binding.textViewIrab4.setTextSize(20f)
                }
                3->{
                    binding.textViewIrab3.text = irab_
                    binding.textViewIrab3.setBackgroundColor(getColor(R.color.index3))
                    val margin = binding.textViewIrab3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab3.layoutParams = margin
                    binding.textViewIrab3.setTextSize(20f)
                }
                4->{
                    binding.textViewIrab2.text = irab_
                    binding.textViewIrab2.setBackgroundColor(getColor(R.color.index2))
                    val margin = binding.textViewIrab2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewIrab2.layoutParams = margin
                    binding.textViewIrab2.setTextSize(20f)
                }
                5->{
                    binding.textViewIrab1.text = irab_
                    binding.textViewIrab1.setBackgroundColor(getColor(R.color.index1))
                    binding.textViewIrab1.setTextSize(20f)
                }
            }
        }
        for((index,posisi_) in kedudukan.withIndex()){
            val posisi = posisi_.replace(" ","\n")
            when(index){
                0->{
                    binding.textViewKedudukan6.text = posisi
                    binding.textViewKedudukan6.setBackgroundColor(getColor(R.color.index6))
                    binding.textViewKedudukan6.setTextSize(16f)
                    val margin = binding.textViewKedudukan6.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan6.layoutParams = margin
                }
                1->{
                    binding.textViewKedudukan5.text = posisi
                    binding.textViewKedudukan5.setBackgroundColor(getColor(R.color.index5))
                    val margin = binding.textViewKedudukan5.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan5.layoutParams = margin
                    binding.textViewKedudukan5.setTextSize(16f)
                }
                2->{
                    binding.textViewKedudukan4.text = posisi
                    binding.textViewKedudukan4.setBackgroundColor(getColor(R.color.index4))
                    val margin = binding.textViewKedudukan4.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan4.layoutParams = margin
                    binding.textViewKedudukan4.setTextSize(16f)
                }
                3->{
                    binding.textViewKedudukan3.text = posisi
                    binding.textViewKedudukan3.setBackgroundColor(getColor(R.color.index3))
                    val margin = binding.textViewKedudukan3.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan3.layoutParams = margin
                    binding.textViewKedudukan3.setTextSize(16f)
                }
                4->{
                    binding.textViewKedudukan2.text = posisi
                    binding.textViewKedudukan2.setBackgroundColor(getColor(R.color.index2))
                    val margin = binding.textViewKedudukan2.layoutParams as ViewGroup.MarginLayoutParams
                    margin.marginStart = 10
                    binding.textViewKedudukan2.layoutParams = margin
                    binding.textViewKedudukan2.setTextSize(16f)
                }
                5->{
                    binding.textViewKedudukan1.text = posisi
                    binding.textViewKedudukan1.setBackgroundColor(getColor(R.color.index1))
                    binding.textViewKedudukan1.setTextSize(16f)
                }
            }
        }
    }
    private fun keterangan(kalimat_split:List<String>,identitas:MutableList<String>,ciriawal:MutableList<String>,ciriAkhir:MutableList<String>,irab:MutableList<String>,tanda_irab:MutableList<String>,kedudukan:MutableList<String>){
        binding.textViewKedudukan6.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[0],identitas[0],irab[0],tanda_irab[0],kedudukan[0])
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog,"index6")
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan5.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[1],identitas[1],irab[1],tanda_irab[1],kedudukan[1])
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog,"index5")
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan4.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[2],identitas[2],irab[2],tanda_irab[2],kedudukan[2])
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog,"index4")
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan3.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[3],identitas[3],irab[3],tanda_irab[3],kedudukan[3])
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog,"index3")
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan2.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[4],identitas[4],irab[4],tanda_irab[4],kedudukan[4])
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog,"index2")
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan1.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[5],identitas[5],irab[5],tanda_irab[5],kedudukan[5])
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog,"index1")
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewHasil6.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[0],identitas[0],irab[0],tanda_irab[0],kedudukan[0])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index6")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil5.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[1],identitas[1],irab[1],tanda_irab[1],kedudukan[1])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index5")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil4.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[2],identitas[2],irab[2],tanda_irab[2],kedudukan[2])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index4")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil3.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[3],identitas[3],irab[3],tanda_irab[3],kedudukan[3])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index3")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil2.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[4],identitas[4],irab[4],tanda_irab[4],kedudukan[4])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index2")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil1.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[5],identitas[5],irab[5],tanda_irab[5],kedudukan[5])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index1")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab6.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[0],identitas[0],irab[0],tanda_irab[0],kedudukan[0])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index6")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab5.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[1],identitas[1],irab[1],tanda_irab[1],kedudukan[1])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index5")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab4.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[2],identitas[2],irab[2],tanda_irab[2],kedudukan[2])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index4")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab3.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[3],identitas[3],irab[3],tanda_irab[3],kedudukan[3])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index3")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab2.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[4],identitas[4],irab[4],tanda_irab[4],kedudukan[4])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index2")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab1.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[5],identitas[5],irab[5],tanda_irab[5],kedudukan[5])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog,"index1")
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
    }
}