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
import android.graphics.drawable.GradientDrawable
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
        private const val warna = "arg_warna"
        fun newInstance(value: List<String>, iro:String): HasilDialog {
            val args = Bundle()
            args.putStringArrayList(isi_dialog, ArrayList(value))
            args.putString(warna, iro)
            val fragment = HasilDialog()
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
//        val kedudukan = isi_text?.get(4)
        val warna = arguments?.getString(warna)
        val drawable_left = resources.getDrawable(R.drawable.rounded_background, null) as GradientDrawable
        val drawable_right = resources.getDrawable(R.drawable.rounded_background_2, null) as GradientDrawable
        when (warna){
            "index6"-> {
                drawable_right.setColor(resources.getColor(R.color.index6_2, null))
                drawable_left.setColor(resources.getColor(R.color.index6, null))
                binding.scrollView.setBackgroundColor(resources.getColor(R.color.index6, null))
                binding.linearLayout.setBackgroundColor(resources.getColor(R.color.index6, null))
            }
            "index5"->{
                drawable_right.setColor(resources.getColor(R.color.index5_2, null))
                drawable_left.setColor(resources.getColor(R.color.index5, null))
                binding.scrollView.setBackgroundColor(resources.getColor(R.color.index5, null))
                binding.linearLayout.setBackgroundColor(resources.getColor(R.color.index5, null))
            }
            "index4"->{
                drawable_right.setColor(resources.getColor(R.color.index4_2, null))
                drawable_left.setColor(resources.getColor(R.color.index4, null))
                binding.scrollView.setBackgroundColor(resources.getColor(R.color.index4, null))
                binding.linearLayout.setBackgroundColor(resources.getColor(R.color.index4, null))
            }
            "index3"->{
                drawable_right.setColor(resources.getColor(R.color.index3_2, null))
                drawable_left.setColor(resources.getColor(R.color.index3, null))
                binding.scrollView.setBackgroundColor(resources.getColor(R.color.index3, null))
                binding.linearLayout.setBackgroundColor(resources.getColor(R.color.index3, null))
            }
            "index2"->{
                drawable_right.setColor(resources.getColor(R.color.index2_2, null))
                drawable_left.setColor(resources.getColor(R.color.index2, null))
                binding.scrollView.setBackgroundColor(resources.getColor(R.color.index2, null))
                binding.linearLayout.setBackgroundColor(resources.getColor(R.color.index2, null))
            }
            "index1"->{
                drawable_right.setColor(resources.getColor(R.color.index1_2, null))
                drawable_left.setColor(resources.getColor(R.color.index1, null))
                binding.scrollView.setBackgroundColor(resources.getColor(R.color.index1, null))
                binding.linearLayout.setBackgroundColor(resources.getColor(R.color.index1, null))
            }
        }
        binding.irab.background = drawable_left
        binding.kedudukan.background = drawable_right
        binding.arab.text = kata
        var text:String
        when(irab){
            "Mabni" -> text = "Hukumnya Mabni, karena merupakan $identitas"
            else -> text = "Irabnya $irab ditandai dengan $tanda_irab  karena $identitas"
        }
        binding.keterangan.text = text
    }
}