package com.example.penentuanidentitas

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.penentuanidentitas.databinding.ActivityHasilBinding
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

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
                    binding.textViewHasil6.setTextSize(30f)
                    binding.textViewHasil6.setPadding(10,5,10,5)
                    val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kanan)
                    DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index6))
                    binding.textViewHasil6.background = drawable
                }
                1->{
                    binding.textViewHasil5.text = text
                    binding.textViewHasil5.setTextSize(30f)
                    binding.textViewHasil5.setPadding(10,5,10,5)
                    binding.textViewHasil5.setBackgroundColor(getColor(R.color.index5))

                }
                2->{
                    binding.textViewHasil4.text = text
                    binding.textViewHasil4.setTextSize(30f)
                    binding.textViewHasil4.setPadding(10,5,10,5)
                    binding.textViewHasil4.setBackgroundColor(getColor(R.color.index4))
                }
                3->{
                    binding.textViewHasil3.text = text
                    binding.textViewHasil3.setTextSize(30f)
                    binding.textViewHasil3.setPadding(10,5,10,5)
                    binding.textViewHasil3.setBackgroundColor(getColor(R.color.index3))
                }
                4->{
                    binding.textViewHasil2.text = text
                    binding.textViewHasil2.setTextSize(30f)
                    binding.textViewHasil2.setPadding(10,5,10,5)
                    binding.textViewHasil2.setBackgroundColor(getColor(R.color.index2))
                }
                5->{
                    binding.textViewHasil1.text = text
                    binding.textViewHasil1.setTextSize(30f)
                    binding.textViewHasil1.setPadding(10,5,10,5)
                    binding.textViewHasil1.setBackgroundColor(getColor(R.color.index1))
                }
            }
        }
        for ((index, kata_) in identitas.withIndex()){
            val kata = kata_.replace(" ","\n")
            when (index){
                0->{
                    binding.textViewIdentitas6.text = kata
                    binding.textViewIdentitas6.setTextSize(20f)
                    binding.textViewIdentitas6.setPadding(10,5,10,5)
                    val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kanan)
                    DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index6))
                    binding.textViewIdentitas6.background = drawable
                }
                1->{
                    binding.textViewIdentitas5.text = kata
                    binding.textViewIdentitas5.setTextSize(20f)
                    binding.textViewIdentitas5.setPadding(10,5,10,5)
                    binding.textViewIdentitas5.setBackgroundColor(getColor(R.color.index5))
                }
                2->{
                    binding.textViewIdentitas4.text = kata
                    binding.textViewIdentitas4.setTextSize(20f)
                    binding.textViewIdentitas4.setPadding(10,5,10,5)
                    binding.textViewIdentitas4.setBackgroundColor(getColor(R.color.index4))
                }3->{
                    binding.textViewIdentitas3.text = kata
                    binding.textViewIdentitas3.setTextSize(20f)
                    binding.textViewIdentitas3.setPadding(10,5,10,5)
                    binding.textViewIdentitas3.setBackgroundColor(getColor(R.color.index3))
                }4->{
                    binding.textViewIdentitas2.text = kata
                    binding.textViewIdentitas2.setTextSize(20f)
                    binding.textViewIdentitas2.setPadding(10,5,10,5)
                    binding.textViewIdentitas2.setBackgroundColor(getColor(R.color.index2))
                }5->{
                    binding.textViewIdentitas1.text = kata
                    binding.textViewIdentitas1.setTextSize(20f)
                    binding.textViewIdentitas1.setPadding(10,5,10,5)
                    binding.textViewIdentitas1.setBackgroundColor(getColor(R.color.index1))
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
                    binding.textViewIrab6.setTextSize(20f)
                    binding.textViewIrab6.setPadding(10,5,10,5)
                    val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kanan)
                    DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index6))
                    binding.textViewIrab6.background = drawable
                }
                1->{
                    binding.textViewIrab5.text = irab_
                    binding.textViewIrab5.setBackgroundColor(getColor(R.color.index5))
                    binding.textViewIrab5.setTextSize(20f)
                    binding.textViewIrab5.setPadding(10,5,10,5)
                }
                2->{
                    binding.textViewIrab4.text = irab_
                    binding.textViewIrab4.setBackgroundColor(getColor(R.color.index4))
                    binding.textViewIrab4.setTextSize(20f)
                    binding.textViewIrab4.setPadding(10,5,10,5)
                }
                3->{
                    binding.textViewIrab3.text = irab_
                    binding.textViewIrab3.setBackgroundColor(getColor(R.color.index3))
                    binding.textViewIrab3.setTextSize(20f)
                    binding.textViewIrab3.setPadding(10,5,10,5)
                }
                4->{
                    binding.textViewIrab2.text = irab_
                    binding.textViewIrab2.setBackgroundColor(getColor(R.color.index2))
                    binding.textViewIrab2.setTextSize(20f)
                    binding.textViewIrab2.setPadding(10,5,10,5)
                }
                5->{
                    binding.textViewIrab1.text = irab_
                    binding.textViewIrab1.setBackgroundColor(getColor(R.color.index1))
                    binding.textViewIrab1.setTextSize(20f)
                    binding.textViewIrab1.setPadding(10,5,10,5)
                }
            }
        }
        for((index,posisi__) in kedudukan.withIndex()){
            var posisi:String
            when(posisi__){
                "Mengikuti Kedudukan Sebelumnya" ->when(irab[index-1]){
                    "Mabni" -> posisi = kedudukan[index-2]
                    else-> posisi = kedudukan[index-1]
                }
                else -> posisi = posisi__
            }
            when(index){
                0->{
                    binding.textViewKedudukan6.text = posisi
                    binding.textViewKedudukan6.setBackgroundColor(getColor(R.color.index6))
                    binding.textViewKedudukan6.setTextSize(20f)
                    binding.textViewKedudukan6.setPadding(10,5,10,5)
                    val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kanan)
                    DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index6))
                    binding.textViewKedudukan6.background = drawable
                }
                1->{
                    binding.textViewKedudukan5.text = posisi
                    binding.textViewKedudukan5.setBackgroundColor(getColor(R.color.index5))
                    binding.textViewKedudukan5.setTextSize(20f)
                    binding.textViewKedudukan5.setPadding(10,5,10,5)
                }
                2->{
                    binding.textViewKedudukan4.text = posisi
                    binding.textViewKedudukan4.setBackgroundColor(getColor(R.color.index4))
                    binding.textViewKedudukan4.setTextSize(20f)
                    binding.textViewKedudukan4.setPadding(10,5,10,5)
                }
                3->{
                    binding.textViewKedudukan3.text = posisi
                    binding.textViewKedudukan3.setBackgroundColor(getColor(R.color.index3))
                    binding.textViewKedudukan3.setTextSize(20f)
                    binding.textViewKedudukan3.setPadding(10,5,10,5)
                }
                4->{
                    binding.textViewKedudukan2.text = posisi
                    binding.textViewKedudukan2.setBackgroundColor(getColor(R.color.index2))
                    binding.textViewKedudukan2.setTextSize(20f)
                    binding.textViewKedudukan2.setPadding(10,5,10,5)
                }
                5->{
                    binding.textViewKedudukan1.text = posisi
                    binding.textViewKedudukan1.setBackgroundColor(getColor(R.color.index1))
                    binding.textViewKedudukan1.setTextSize(20f)
                    binding.textViewKedudukan1.setPadding(10,5,10,5)
                }
            }
        }
        when(kalimat_split.size){
            2 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index5))
                binding.textViewHasil5.background = drawable
            }
            3 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index4))
                binding.textViewHasil4.background = drawable
            }
            4 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index3))
                binding.textViewHasil3.background = drawable
            }
            5 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index2))
                binding.textViewHasil2.background = drawable
            }
            6 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index1))
                binding.textViewHasil1.background = drawable
            }
        }
        when(kalimat_split.size){
            2 ->{
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index5))
                binding.textViewIdentitas5.background = drawable
            }
            3 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index4))
                binding.textViewIdentitas4.background = drawable
            }
            4 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index3))
                binding.textViewIdentitas3.background = drawable
            }
            5 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index2))
                binding.textViewIdentitas2.background = drawable
            }
            6 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index1))
                binding.textViewIdentitas1.background = drawable
            }
        }
        when(kalimat_split.size){
            2 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index5))
                binding.textViewIrab5.background = drawable
            }
            3 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index4))
                binding.textViewIrab4.background = drawable
            }
            4 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index3))
                binding.textViewIrab3.background = drawable
            }
            5 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index2))
                binding.textViewIrab2.background = drawable
            }
            6 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index1))
                binding.textViewIrab1.background = drawable
            }
        }
        when(kalimat_split.size){
            2 ->{
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index5))
                binding.textViewKedudukan5.background = drawable
            }
            3 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index4))
                binding.textViewKedudukan4.background = drawable
            }
            4 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index3))
                binding.textViewKedudukan3.background = drawable
            }
            5 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index2))
                binding.textViewKedudukan2.background = drawable
            }
            6 -> {
                val drawable = ContextCompat.getDrawable(this, R.drawable.rounded_kiri)
                DrawableCompat.setTint(drawable!!, ContextCompat.getColor(this, R.color.index1))
                binding.textViewKedudukan1.background = drawable
            }
        }
    }
    private fun keterangan(kalimat_split:List<String>,identitas:MutableList<String>,ciriawal:MutableList<String>,ciriAkhir:MutableList<String>,irab:MutableList<String>,tanda_irab:MutableList<String>,kedudukan:MutableList<String>){
        binding.textViewKedudukan6.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[0],identitas[0],irab[0],tanda_irab[0],kedudukan[0],"None")
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog)
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan5.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[1],identitas[1],irab[1],tanda_irab[1],kedudukan[1],kalimat_split[0],"None")
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog)
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan4.setOnClickListener {
            val kedudukanSebelumnya:String
            when(irab[2]){
                "Mengikuti Kedudukan Sebelumnya" -> when {
                    irab[0] == "Mabni" -> kedudukanSebelumnya = irab[0]
                    else-> kedudukanSebelumnya = irab[1]
                }
                else-> kedudukanSebelumnya = "None"
            }
            val isi_dialog = listOf(kalimat_split[2],identitas[2],irab[2],tanda_irab[2],kedudukan[2],kalimat_split[1],kedudukanSebelumnya)
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog)
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan3.setOnClickListener {
            val kedudukanSebelumnya:String
            when(irab[3]){
                "Mengikuti Kedudukan Sebelumnya" -> when {
                    irab[0] == "Mabni" -> kedudukanSebelumnya = irab[1]
                    else-> kedudukanSebelumnya = irab[2]
                }
                else-> kedudukanSebelumnya = "None"
            }
            val isi_dialog = listOf(kalimat_split[3],identitas[3],irab[3],tanda_irab[3],kedudukan[3],kalimat_split[2],kedudukanSebelumnya)
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog)
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan2.setOnClickListener {
            val kedudukanSebelumnya:String
            when (irab[4]){
                "Mengikuti Kedudukan Sebelumnya" -> when {
                    irab[0] == "Mabni" -> kedudukanSebelumnya = irab[2]
                    else-> kedudukanSebelumnya = irab[3]
                }
                else-> kedudukanSebelumnya = "None"
            }
            val isi_dialog = listOf(kalimat_split[4],identitas[4],irab[4],tanda_irab[4],kedudukan[4],kalimat_split[3],kedudukanSebelumnya)
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog)
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewKedudukan1.setOnClickListener {
            val kedudukanSebelumnya:String
            when (irab[5]){
                "Mengikuti Kedudukan Sebelumnya" -> when {
                    irab[0] == "Mabni" -> kedudukanSebelumnya = irab[3]
                    else-> kedudukanSebelumnya = irab[4]
                }
                else-> kedudukanSebelumnya = "None"
            }
            val isi_dialog = listOf(kalimat_split[5],identitas[5],irab[5],tanda_irab[5],kedudukan[5],kalimat_split[4],kedudukanSebelumnya)
            val dialog_kedudukan = KedudukanDialog.intanceBaru(isi_dialog)
            supportFragmentManager.let{dialog_kedudukan.show(it, KedudukanDialog.TAG)}
        }
        binding.textViewHasil6.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[0],identitas[0],irab[0],tanda_irab[0],kedudukan[0],"None")
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil5.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[1],identitas[1],irab[1],tanda_irab[1],kedudukan[1],"None")
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil4.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[2],identitas[2],irab[2],tanda_irab[2],kedudukan[2],identitas[1])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil3.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[3],identitas[3],irab[3],tanda_irab[3],kedudukan[3],identitas[2])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil2.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[4],identitas[4],irab[4],tanda_irab[4],kedudukan[4],identitas[3])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewHasil1.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[5],identitas[5],irab[5],tanda_irab[5],kedudukan[5],identitas[4])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab6.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[0],identitas[0],irab[0],tanda_irab[0],kedudukan[0],"None")
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab5.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[1],identitas[1],irab[1],tanda_irab[1],kedudukan[1],"None")
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab4.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[2],identitas[2],irab[2],tanda_irab[2],kedudukan[2],identitas[1])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab3.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[3],identitas[3],irab[3],tanda_irab[3],kedudukan[3],identitas[2])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab2.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[4],identitas[4],irab[4],tanda_irab[4],kedudukan[4],identitas[3])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
        binding.textViewIrab1.setOnClickListener {
            val isi_dialog = listOf(kalimat_split[5],identitas[5],irab[5],tanda_irab[5],kedudukan[5],identitas[4])
            val dialog_hasil = HasilDialog.newInstance(isi_dialog)
            supportFragmentManager.let{dialog_hasil.show(it, HasilDialog.TAG)}
        }
    }
}