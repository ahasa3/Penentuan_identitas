package com.example.penentuanidentitas
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.example.penentuanidentitas.databinding.DialogHasilBinding
import android.widget.ArrayAdapter

class HasilDialog: BottomSheetDialogFragment(){
    private lateinit var binding: DialogHasilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogHasilBinding.inflate(
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
        const val TAG = "HasilDialog"
        private const val isi_dialog= "arg_list"
        fun newInstance(value: List<String>): HasilDialog {
            val args = Bundle()
            args.putStringArrayList(isi_dialog, ArrayList(value))
            val fragment = HasilDialog()
            fragment.arguments = args
            return fragment
        }
    }
    fun dialogView(){
        val isi_text = arguments?.getStringArrayList(isi_dialog)
        val kata = isi_text!!.get(0)
        val identitas = isi_text!!.get(1)
        val irab = isi_text!!.get(2)
        val tanda_irab = isi_text!!.get(3)
        val kedudukan = isi_text.get(4)
        val identitasSebelumnya = isi_text.get(5)
        binding.arab.text = kata
        val tandaIrab = tandaIrabText(tanda_irab)
        var text:String
        when{
            kata.takeLast(1) == "َ" && irab=="Jer"-> text = "Irabnya $irab karena merupakan $identitas dan isim ghairu munsharif.\nDalilnya:"
            kedudukan=="Mubtada' Kaana" -> text = "Hukumnya $irab karena merupakan $identitas dan berada setelah Keluarga Kaana.\nDalilnya:"
            kedudukan=="Khobar Kaana" -> text = "Hukumnya $irab karena merupakan khobar dan berada setelah Keluarga Kaana.\nDalilnya:"
            kedudukan=="Mubtada' Inna" -> text = "Hukumnya $irab karena merupakan $identitas dan berada setelah Keluarga Inna.\nDalilnya:"
            kedudukan=="Khobar Inna" -> text = "Hukumnya $irab karena merupakan khobar dan berada setelah Keluarga Inna.\nDalilnya:"
            irab=="Mabni" -> when(identitas){
                "Fi'il Mudhari'" -> text = "Hukumnya $identitas karena merupakan $identitas yang diakhiri dengan $tandaIrab.\nDalilnya:"
                "Huruf Jer", "Huruf Athof", "Amil Nawashib", "Amil Jawazim", "Adat Istisna'", "Huruf Nida'","Isim Dhomir", "Fi'il Madhi", "Fi'il Amr" ->text = "Hukumnya Mabni, karena merupakan $identitas.\nDalilnya:"
                else -> text = "Hukumnya Mabni, karena merupakan $identitas."
            }
            tanda_irab == "Membuang Huruf 'Illat" -> text = "Irabnya $irab karena merupakan $identitas mu'tal akhir.\nDalilnya:"
            kedudukan=="Mustasna'" -> text = "I'robnya $irab karena berada setelah Adat atau Alat Istisna'.\nDalilnya:"
            else -> text = "Irabnya $irab ditandai dengan $tandaIrab karena $identitas.\nDalilnya:"
        }
        val isi:MutableList<String> = DalilKeterangan.dalilIrab(text,irab,identitas,tanda_irab,identitasSebelumnya,kedudukan)
        binding.textViewKketerangan.text= isi.joinToString(separator = "\n")
        binding.kedudukan.setOnClickListener{
            dismiss()
            val isiDialog = listOf(kata!!,identitas!!,irab!!,tanda_irab!!,kedudukan!!,identitasSebelumnya!!)
            val previous = KedudukanDialog.intanceBaru(isiDialog)
            previous.show(parentFragmentManager, KedudukanDialog.TAG)
        }
    }
    fun tandaIrabText(tanda_irab:String):String{
        val tandaIrab:String
        when (tanda_irab){
            "ُ" -> tandaIrab = "$tanda_irab (Dhommah)"
            "ٌ" -> tandaIrab = "$tanda_irab (Dhommatain)"
            "َ" -> tandaIrab = "$tanda_irab (Fathah)"
            "ً" -> tandaIrab = "$tanda_irab (Fathatain)"
            "ًا" -> tandaIrab = "$tanda_irab (Fathatain)"
            "ِ" -> tandaIrab = "$tanda_irab (Kasrah)"
            "ٍ" -> tandaIrab = "$tanda_irab (Kasratain)"
            else -> tandaIrab = tanda_irab
        }
        return tandaIrab
    }
}