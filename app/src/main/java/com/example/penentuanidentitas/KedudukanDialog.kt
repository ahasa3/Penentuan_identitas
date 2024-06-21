package com.example.penentuanidentitas
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.penentuanidentitas.databinding.DialogKedudukanBinding
class KedudukanDialog: BottomSheetDialogFragment(){
    private lateinit var binding: DialogKedudukanBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogKedudukanBinding.inflate(
            inflater,
            container,
            false
        )
        dialogView()

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialog?.setOnShowListener { it ->
            val d = it as BottomSheetDialog
            val bottomSheet =
                d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let {
                val behavior = BottomSheetBehavior.from(it)
                behavior.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return super.onCreateDialog(savedInstanceState)
    }

    companion object {
        const val TAG = "KedudukanDialog"
        private const val isi_dialog= "arg_list"
        private const val warna = "arg_warna"
        fun intanceBaru(value: List<String>):KedudukanDialog {
            val args = Bundle()
            args.putStringArrayList(isi_dialog, ArrayList(value))
            val fragment = KedudukanDialog()
            fragment.arguments = args
            return fragment
        }
    }
    fun dialogView(){
        val isi_text = arguments?.getStringArrayList(isi_dialog)
        val kata = isi_text?.get(0)
        val identitas = isi_text!!.get(1)
        val irab = isi_text?.get(2)
        val tanda_irab = isi_text?.get(3)
        val kedudukan = isi_text!!.get(4)
        val identitasSebelumnya = isi_text?.get(5)

        binding.arab2.text = kata
        var text:String
        when(kedudukan){
            "Mubtada'" -> when{
                identitas == "Isim Dhomir" -> text = "Menjadi Mubtada karena lafadz $kata merupakan $identitas.\nDalilnya:"
                else -> text = "Menjadi Mubtada karena lafadz $kata beri'rob $irab dan sepi dari amil lafdzi.\nDalilnya:"
            }
            "Mubtada' Kaana" -> text = "Menjadi Mubtadanya Kaana karena lafadz $kata berada setelah salah satu dari Keluarga Kaana.\nDalilnya:"
            "Mubtada' Inna" -> text = "Menjadi Mubtadanya Inna karena lafadz $kata berada setelah salah satu dari Keluarga Inna.\nDalilnya:"
            "Khobar Kaana" -> text = "Menjadi Khabarnya Kaana karena lafadz $kata beri'rob $irab dan berada setelah mubtada kaana.\nDalilnya:"
            "Khobar Inna" -> text = "Menjadi Khabarnya Inna karena lafadz $kata beri'rob $irab dan berada setelah mubtada inna.\nDalilnya:"
            "Khobar Jumlah Fi'liyah (Fi'il)" -> text = "Menjadi Khabar Jumlah Fi'liyah (Fi'il) karena lafadz $kata berupa Fi'il dan berada setelah mubtada.\nDalilnya:"
            "Khobar" -> text = "Menjadi Khabar karena lafadz $kata beri'rob $irab dan jatuh setelah mubtada.\nDalilnya:"
            "Khobar Jumlah Fi'liyah (Fa'il)" -> text = "Menjadi Khabar Jumlah Fi'liyah (Fa'il) karena lafadz $kata berupa Fa'il dan berada setelah Fi'il.\nDalilnya:"
            "Khobar Jumlah Ismiyah (Mubtada')" -> text = "Menjadi Khabar Jumlah Ismiyah (Mubtada') karena lafadz $kata merupakan mubtada' dan berada setelah mubtada'.\nDalilnya:"
            "Khobar Jumlah Ismiyah (Khobar)" -> text = "Menjadi Khabar Jumlah Ismiyah (Khobar) karena lafadz $kata merupakan khabar dan berada setelah dua mubtada'.\nDalilnya:"
            "Keluarga Kaana", "Keluarga Inna", "Adat Istisna'","Lafadz Taukid" -> text = "$identitas.\nDalilnya:"
            "Taukid" -> text = "Menjadi Taukid karena lafadz $kata berada sebelum Lafadz Taukid.\nDalilnya:"
            "Fi'il" -> text = "Menjadi Fi'il karena lafadz $kata merupakan $identitas.\nDalilnya:"
            "Fa'il" -> text = "Menjadi Fa'il karena lafadz $kata merupakan $identitas dan berada setelah Fi'il.\nDalilnya:"
            "Mudhof" -> text = "Menjadi Mudhof karena lafadz $kata tidak diberi tanwin dan tidak di ma’rifatkan dengan ال(Al).\nDalilnya:"
            "Mudhof Ilaih" -> text = "Menjadi Mudhof Ilaih karena lafadz $kata beri'rob Jer dan berada setelah mudhof.\nDalilnya"
            "Na'at" -> text = "Menjadi Na'at karena lafadz $kata mensifati kata sebelumnya dan memiliki I'rob yang sama dengan kata sebelumnya.\nDalilnya:"
            "Mustasna'" -> text = "Menjadi Mustasna' karena lafadz $kata jatuh setelah Adat / Alat Istisna'.\nDalilnya:"
            "Ma'thuf 'Alaih"-> text = "Menjadi Ma'thuf 'Alaih karena lafadz $kata berada setelah Huruf 'Athof.\nDalilnya:"
            "Maf'ul Bih" -> text = "Menjadi Maf'ul Bih karena lafadz $kata I'robnya Nashob dan menjadi sasaran pekerjaan dari kata sebelumnya.\nDalilnya:"
            else -> text = "Mohon Maaf, untuk saat ini aplikasi kami belum bisa mengidentifikasi kedudukan lafadz tersebut."
        }
        val isi:MutableList<String> = DalilKeterangan.dalilKedudukan(text,kedudukan,identitas)
        binding.textViewKeterangan2.text= isi.joinToString(separator = "\n")
        binding.irab2.setOnClickListener{
            dismiss()
            val isiDialog = listOf(kata!!,identitas!!,irab!!,tanda_irab!!,kedudukan!!,identitasSebelumnya!!)
            val previous = HasilDialog.newInstance(isiDialog)
            previous.show(parentFragmentManager, HasilDialog.TAG)
        }
    }
}