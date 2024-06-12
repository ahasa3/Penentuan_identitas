package com.example.penentuanidentitas

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginTop
import com.example.penentuanidentitas.databinding.ActivityKitabViewBinding

class KitabViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKitabViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kitab_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        kitab()
    }
    fun createTextView(text: String, isArabic: Boolean): TextView {
        return TextView(this).apply {
            this.text = text
            this.textSize = if (isArabic) 18f else 18f
            this.textAlignment = if (isArabic) TextView.TEXT_ALIGNMENT_CENTER else TextView.TEXT_ALIGNMENT_TEXT_START
            this.setPadding(15, 8, 10, 8)
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 20)
            this.layoutParams = params
        }
    }
    fun kitab(){
        val linearLayoutContent = findViewById<LinearLayout>(R.id.linearLayout)
        BaitImrithi.muqoddimah["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.muqoddimah["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKalam["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKalam["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIrob["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIrob["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaRofa["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaRofa["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaNashob["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaNashob["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaJer["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaJer["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaJazm["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTandaJazm["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.fasal["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.fasal["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMarifatNakirah["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMarifatNakirah["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babFiil["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babFiil["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIrabFiil["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIrabFiil["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIsimRofa["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIsimRofa["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babNaibulFail["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babNaibulFail["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMubtadaKhabar["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMubtadaKhabar["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKeluargaKaana["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKeluargaKaana["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKeluargaInna["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKeluargaInna["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKeluargadzonna["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babKeluargadzonna["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babNaat["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babNaat["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babAthof["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babAthof["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTaukid["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTaukid["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babBadal["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babBadal["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIsimNashob["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIsimNashob["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMasdar["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMasdar["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babZhorof["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babZhorof["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babHal["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babHal["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTamyiz["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babTamyiz["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIstisna["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIstisna["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babLaBeramalaInna["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babLaBeramalaInna["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMunada["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMunada["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMafulLiAjlih["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMafulLiAjlih["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMafulMaah["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babMafulMaah["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIsimJer["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIsimJer["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIdhofah["arab"]?.forEach { text ->
            val textView = createTextView(text, true)
            linearLayoutContent.addView(textView)
        }
        BaitImrithi.babIdhofah["terjemah"]?.forEach { text ->
            val textView = createTextView(text, false)
            linearLayoutContent.addView(textView)
        }
    }
}