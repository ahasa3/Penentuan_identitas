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
import android.graphics.drawable.GradientDrawable
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
        val identitas = isi_text?.get(1)
        val irab = isi_text?.get(2)
        val tanda_irab = isi_text?.get(3)
        val kedudukan = isi_text?.get(4)

        binding.arab2.text = kata
        var text:String
        when(kedudukan){
            "Mubtada" -> when{
                identitas == "Isim Dhomir" -> text = "Menjadi Mubtada karena lafadz $kata merupakan $identitas"
                else -> text = "Menjadi Mubtada karena lafadz $kata beri'rob $irab dan sepi dari amil lafdzi"
            }
            "Khabar (Fi'il)" -> text = "Menjadi Khabar (Fi'il) karena lafadz $kata beri'rob $irab dan berada setelah mubtada"
            "Khabar" -> text = "Menjadi Khabar karena lafadz $kata beri'rob $irab dan jatuh setelah mubtada"
            "Khabar (Fa'il)" -> text = "Menjadi Khabar (Fa'il) karena lafadz $kata beri'rob $irab dan berada setelah Fi'il"
            "Keluarga Kaana", "Keluarga Inna", "Adat Istisna'", "Huruf Nida" -> text = identitas!!
            "Taukid" -> text = "Menjadi Taukid karena lafadz $kata merupakan $identitas"
            "Munada" -> text = "Menjadi Munada karena lafadz $kata didahului oleh Huruf Nida'"
            "Fi'il" -> text = "Menjadi Fi'il karena lafadz $kata merupakan $identitas"
            "Fa'il" -> text = "Menjadi Fa'il karena lafadz $kata merupakan $identitas dan berada setelah Fi'il"
            "Mudhof" -> text = "Menjadi Mudhof karena lafadz $kata tidak diberi tanwin dan tidak di ma’rifatkan dengan ال(Al)"
            "Mudhof Ilaih" -> text = "Menjadi Mudhof Ilaih karena lafadz $kata beri'rob Jer dan berada setelah mudhof"
            "Na'at" -> text = "Menjadi Na'at karena lafadz $kata mensifati kata sebelumnya dan memiliki I'rob yang sama dengan kata sebelumnya"
            "Mustasna'" -> text = "Menjadi Mustasna' karena lafadz $kata jatuh setelah Adat / Alat Istisna'"
            else -> text = "Mohon Maaf, untuk saat ini aplikasi kami belum bisa mengidentifikasi kedudukan lafadz tersebut"
        }
        binding.keterangan2.text = text
        binding.irab2.setOnClickListener{
            dismiss()
            val isiDialog = listOf(kata!!,identitas!!,irab!!,tanda_irab!!,kedudukan!!)
            val previous = HasilDialog.newInstance(isiDialog)
            previous.show(parentFragmentManager, HasilDialog.TAG)
        }
    }
}