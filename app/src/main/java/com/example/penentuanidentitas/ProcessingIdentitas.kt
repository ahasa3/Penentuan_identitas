package com.example.penentuanidentitas

class ProcessingKalimat {
    companion object {
        val asmaul_khomsah = listOf("اَب","اَخ","حَم","فُوْ","ذُوْ")
        val kana_dan_saudaranya = listOf("اَضْحَى","ظَلَّ","بَاتَ","اَمْسَى","اَصْبَحَ","صَارَ","لَيْسَ",
            "فَتَئَ","اِنْفَكَ","زَالَ","بَرِحَ") //harus diikutkan dengan nafi
        val inna_dan_saudaranya = listOf("اِنَّ","اَنَّ","لَيْتَ","كَأَنَّ","لَكِنَّ","لَعَلَّ")
        val isim_dhomir = listOf("هُوَ","هُمَا","هُمْ","هِيَ","هُنَّ","اَنْتَ","اَنْتُمَا","اَنْتُمْ","اَنْتِ","اَنْتُنَّ","اَنَا","نَحْنُ")
        val amil_nashob = mapOf(
            "tidak_gabung" to listOf("اَنْ","لَنْ","كَيْ","اِذَنْ","حَتَّى","اَوْ","وَ"),
            "gabung" to listOf("لِ","فَ"))
        val amil_jawazim = mapOf(
            "tidak_gabung" to listOf("لَمْ","لَمَّا","لَا","اِنْ","مَا","مَنْ","اَيُّ","مَتَى","اَيَّنَ","اَيْنَ","اِذْمَا","مَهْمَا","حَيْثُمَا","كَيْفَمَا","اَنَّى"),
            "gabung" to listOf("لِ"))
        val huruf_athof = mapOf(
            "tidak_gabung" to listOf("وَ","اَوْ","اَمْ","ثُمِِّ","حَتَّى","لَا","بَلْ","لَكِنْ","اِمَّا"),
            "gabung" to listOf("فَ"))
        val lafadz_taukid = listOf("نَفْس","عَيْن","كُلّ","اَجْمَع","اَبْتَع","اَكْتَع","اَبْصَع")
        val adat_istitsna = listOf("اِلَّا","إِلَّا","غَيْرُ","سِوَى","سُوَى","سَوَا","خَلَا","عَدَا","حَشَا")
        val huruf_jer = mapOf(
            "tidak_gabung" to listOf("مِنَ","مِنْ","اِلَى","فِى","عَنْ","عَلَى","مُذْ","مُنْذُ","رُبَّ"),
            "gabung" to listOf("بِ","كَ","لِ","وَ","تَ"))
        fun findingIdentitas(kalimat: String): Triple<MutableList<String>, MutableList<String>, MutableList<String>> {
            val identitas: MutableList<String> =ArrayList() //berisi identitas kata dari setiap kata
            val ciriAwal: MutableList<String> =ArrayList()  //berisi ciri awal kata dari setiap kata
            val ciriAkhir: MutableList<String> =ArrayList() //berisi ciri akhir kata dari setiap kata
            val kalimat_split = kalimat.split(" ")
            for (kata_ in kalimat_split) {
                var kata = kata_
                val panjang_ = kata.length
                when{
                    kata.length > 2 -> when{
                        kata.substring(panjang_-1,panjang_)=="ْ" &&
                                amil_jawazim["gabung"]!!.contains(kata.substring(0,2)) ->{
                            kata = kata.substring(2,panjang_)
                        }
                        kata.substring(panjang_-1,panjang_)=="َ" &&
                                amil_nashob["gabung"]!!.contains(kata.substring(0,2)) -> {
                            kata = kata.substring(2,panjang_)
                        }
                    }
                }
                val panjang = kata.length
                when{
                    huruf_athof["tidak_gabung"]!!.contains(kata) ->{
                        identitas.add("Huruf Athof")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    amil_nashob["tidak_gabung"]!!.contains(kata) -> {
                        identitas.add("Amil Nawashib")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    amil_jawazim["tidak_gabung"]!!.contains(kata) -> {
                        identitas.add("Amil Jawazim")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    huruf_jer["tidak_gabung"]!!.contains(kata) -> {
                        identitas.add("Huruf Jer")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    asmaul_khomsah.contains(kata.substring(0,3)) ||
                            asmaul_khomsah.contains(kata.substring(0,4)) -> {
                        identitas.add("Asmaul Khomsah")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    kana_dan_saudaranya.contains(kata) -> {
                        identitas.add("Keluarga Kaana")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    inna_dan_saudaranya.contains(kata) -> {
                        identitas.add("Keluarga Inna")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    isim_dhomir.contains(kata) -> {
                        identitas.add("Isim Dhomir")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    lafadz_taukid.contains(kata.substring(0,4)) -> {
                        identitas.add("Lafadz Taukid")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    panjang > 5 && lafadz_taukid.contains(kata.substring(0,5)) -> {
                        identitas.add("Lafadz Taukid")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    panjang > 7 && lafadz_taukid.contains(kata.substring(0,7)) -> {
                        identitas.add("Lafadz Taukid")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    adat_istitsna.contains(kata) -> {
                        identitas.add("Adat Istisna'")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    else -> when {                                                      //when pertama adalah mencari ciri akhir
                        kata.takeLast(2) == "ًا"-> {                   //fathah tanwin + alif (1)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(2))
                        }
                        kata.takeLast(1) == "ٌ" -> {                    //dhammahtain    (2)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(1))
                        }
                        kata.takeLast(1) == "ِ" &&
                                kata.takeLast(3)!="انِ"&&
                                kata.takeLast(4) != "يْنِ" &&
                                kata.substring(panjang - 3, panjang - 1) != "ات" &&
                                kata.takeLast(2) != "تِ" -> when {                //kasrah         (3)
                            kata.substring(0,2) == "ال" -> {              //when kedua adalah mencari  ciri awal
                                identitas.add("Isim Mufrod")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(1))
                            }
                        }
                        kata.takeLast(1) == "َ" &&
                                kata.takeLast(4) != "وْنَ" &&
                                kata.takeLast(3) != "ْتَ" &&
                                kata.takeLast(4) != "يْنَ" &&
                                kata.takeLast(3) != "ْنَ" &&
                                kata.takeLast(2) != "نَ" &&
                                kata.takeLast(2) != "يَ" -> when {                 //fathah         (4)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            else -> when(panjang){
                                5, 6, 8 ->{
                                    identitas.add("Fi'il Madhi")
                                    ciriAwal.add("None")
                                    ciriAkhir.add(kata.takeLast(1))
                                }
                                else ->{
                                    identitas.add("Isim Mufrod")
                                    ciriAwal.add("None")
                                    ciriAkhir.add(kata.takeLast(1))
                                }
                            }
                        }
                        kata.takeLast(1) == "ْ" -> when {                //sukun          (5)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            else -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(1))
                            }
                        }
                        kata.takeLast(1) == "ا" &&
                                kata.takeLast(3) != "تَا" &&
                                kata.substring(panjang - 5, panjang) != "تُمَا" &&
                                kata.takeLast(2) != "َا" &&
                                kata.takeLast(3) != "وْا" -> when {                 //alif           (6)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            else -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(1))
                            }
                        }
                        kata.takeLast(3) == "انِ" -> when {                   //aani        (7)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.takeLast(3))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(3))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(3))
                            }
                            else -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(3))
                            }
                        }
                        kata.takeLast(1) == "ُ" &&
                                kata.takeLast(3) != "ْتُ" -> when {                  //dhammah    (8)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ن" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(1))
                            }
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(1))
                            }
                        }
                        kata.endsWith("ٍ") -> {                       //Kasrahtain     (9)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(1))
                        }
                        kata.takeLast(4) == "وْنَ" -> when {                   //uuna          (10)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.takeLast(4))
                            }
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(4))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(4))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(4))
                            }
                            else -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(4))
                            }
                        }
                        kata.takeLast(3) == "ْتُ" -> {                         //sukun tu     (11)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(3))
                        }
                        kata.substring(panjang-1, panjang) == "ً" ->{                        // Fathah Tanwin    (12)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(1))
                        }
                        kata.takeLast(3) == "ْتَ" -> {                         //sukun ta     (13)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(3))
                        }
                        kata.takeLast(4) == "يْنَ" -> when {                     //iina        (14)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.takeLast(4))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(4))
                            }
                            else -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(4))
                            }
                        }
                        kata.takeLast(4) == "يْنِ" -> when {                     //ayni        (15)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.takeLast(4))
                            }
                            else -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(4))
                            }
                        }
                        kata.substring(panjang - 3, panjang - 1) == "ات" -> when {                  //aati       (16)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Jama' Muannats Salim")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang - 1))
                            }
                            else -> {
                                identitas.add("Jama' Muannats Salim")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 3, panjang - 1))
                            }
                        }
                        kata.takeLast(2) == "تْ" -> {                           //ta sukun   (17)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(2))
                        }
                        kata.takeLast(3) == "تَا" -> when {                      //taa        (18)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(3))
                            }
                            else -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(3))
                            }
                        }
                        kata.substring(panjang - 5, panjang) == "تُمَا" -> {                        //tumaa       (19)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 5, panjang))
                        }
                        kata.takeLast(4) == "تُمْ" -> {                         //tum         (20)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(4))
                        }
                        kata.takeLast(2) == "تِ" -> {                           //ti         (21)
                            identitas.add("Fi'il Madhi'")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(1))
                        }
                        kata.takeLast(3) == "ْنَ" -> {                          //sukun na    (22)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(3))
                        }
                        kata.takeLast(4) == "ُنَّ" -> {                         //unna         (23)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(4))
                        }
                        kata.takeLast(2) == "نَ" -> when {                       //na         (24)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(2))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(2))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(2))
                            }
                            else -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(2))
                            }
                        }
                        kata.takeLast(2) == "يَ" -> when {                       //ya         (25)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(2))
                            }
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(1))
                            }
                        }
                        kata.takeLast(3) == "ُوْ" -> {                          //uu          (26)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.takeLast(3))
                        }
                        kata.takeLast(2) == "َا" -> when {
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(2))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(2))
                            }
                            else ->{
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(2))
                            }
                        }
                        kata.takeLast(3) == "وْا" -> when {
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(3))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(3))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.takeLast(3))
                            }
                            else ->{
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.takeLast(3))
                            }
                        }
                    }
                }

            }
            return Triple(identitas, ciriAwal, ciriAkhir)
        }
        fun findingIrab(kalimat:String,identitas:MutableList<String>,ciriAkhir:MutableList<String>): Pair<MutableList<String>, MutableList<String>>{
            val kalimat_split = kalimat.split(" ")
            val irab:MutableList<String> =ArrayList()
            val tanda_irab:MutableList<String> =ArrayList()
            for ((index, kata) in kalimat_split.withIndex()){
                val identity = identitas[index]
                val akhir = ciriAkhir[index]
                when{
                    index!=0 && identitas[index-1] == "Huruf Athof" ->{
                        irab.add("Mengikuti Irab Sebelumnya")
                        tanda_irab.add(akhir)
                    }
                    identity == "Isim Mufrod" -> when (akhir) {
                        "ُ","ٌ" ->{
                            irab.add("Rofa'")
                            tanda_irab.add(akhir)
                        }
                        "َ","ً","ًا" ->{
                            irab.add("Nashob")
                            tanda_irab.add(akhir)
                        }
                        "ِ","ٍ" -> {
                            irab.add("Jer")
                            tanda_irab.add(akhir)
                        }
                    }
                    identity == "Fi'il Mudhari'" -> when (akhir){
                        "ُ" ->{
                            irab.add("Rofa'")
                            tanda_irab.add(akhir)
                        }
                        "َ" ->when{
                            index!=0 && identitas[index-1] == "Amil Jawazim"->{
                                irab.add("Jazm")
                                tanda_irab.add("Membuang Huruf 'Illat")
                            }
                            else->{
                                irab.add("Nashob")
                                tanda_irab.add(akhir)
                            }
                        }
                        "ْ" ->{
                            irab.add("Jazm")
                            tanda_irab.add(akhir)
                        }
                        "نَ" -> {
                            irab.add("Mabni")
                            tanda_irab.add("Nun Jama' Niswah")
                        }
                    }
                    identity == "Af'alul Khomsah" -> when(akhir){
                        "انِ","وْنَ","يْنَ" -> {
                            irab.add("Rofa'")
                            tanda_irab.add("Tetapnya Nun")
                        }
                        "َا","وْا" -> when{
                            index != 0 -> when{
                                identitas[index - 1] == "Amil Nawashib" ->{
                                    irab.add("Nashob")
                                    tanda_irab.add("Membuang Nun")
                                }
                                identitas[index - 1] == "Amil Jawazim"->{
                                    irab.add("Jazm")
                                    tanda_irab.add("Membuang Nun")
                                }
                            }
                        }
                    }
                    identity == "Fi'il Madhi" -> {
                        irab.add("Mabni")
                        tanda_irab.add("None")
                    }
                    identity == "Fi'il Amr" -> {
                        irab.add("Mabni")
                        tanda_irab.add("None")
                    }
                    identity == "Isim Tatsniyah" -> when(akhir){
                        "انِ" ->{
                            irab.add("Rofa'")
                            tanda_irab.add("ا")
                        }
                        "يْنِ" ->{
                            irab.add("Nashob")
                            tanda_irab.add("ي")
                        }
                    }
                    identity == "Jama' Mudzakar Salim" -> when(akhir){
                        "وْنَ" ->{
                            irab.add("Rofa'")
                            tanda_irab.add("و")
                        }
                        "يْنَ" ->when{
                            identitas[index-1]=="Amil Nawashib" ->{
                                irab.add("Nashob")
                                tanda_irab.add("ي")
                            }
                            identitas[index-1]=="Huruf Jer" ->{
                                irab.add("Jer")
                                tanda_irab.add("ي")
                            }
                        }
                    }
                    identity == "Jama' Muannats Salim" -> when(kata.substring(kata.length-1,kata.length)){
                        "ُ" -> {
                            irab.add("Rofa'")
                            tanda_irab.add(kata.substring(kata.length-1,kata.length))
                        }
                        "ِ" -> when{
                            index != 0 &&
                                    identitas[index - 1] == "Huruf Jer" ->{
                                irab.add("Jer")
                                tanda_irab.add(kata.substring(kata.length-1,kata.length))
                            }
                            index!=0 &&
                                    identitas[index-1] == "Amil Nawashib" ->{
                                irab.add("Nashob")
                                tanda_irab.add(kata.substring(kata.length-1,kata.length))
                            }
                            else ->{
                                irab.add("Mengikuti Irab Sebelumnya")
                                tanda_irab.add(kata.substring(kata.length-1,kata.length))
                            }
                        }
                    }
                    identity=="Asmaul Khomsah" -> when{
                        kata.substring(4,5) == "ُ" ||
                                kata.substring(4,5) == "ٌ" ->{
                            irab.add("Rofa'")
                            tanda_irab.add(kata.substring(4,5))
                        }
                        kata.substring(4,5) == "َ" ->{
                            irab.add("Nashob")
                            tanda_irab.add(kata.substring(4,5))
                        }
                        kata.substring(4,5) == "ِ" ->{
                            irab.add("Jer")
                            tanda_irab.add(kata.substring(4,5))
                        }
                    }
                    kata.takeLast(1) == "َ" || kata.takeLast(1) == "ً"->{
                        irab.add("Jer")
                        tanda_irab.add(kata.takeLast(1))
                    }
                    kata.takeLast(2) == "ًا"-> {
                        irab.add("Jer")
                        tanda_irab.add(kata.takeLast(2))
                    }
                    else -> {
                        irab.add("Mabni")
                        tanda_irab.add("None")
                    }
                }
            }
            return Pair(irab,tanda_irab)
        }

        fun findingKedudukan(kalimat:String,identitas:MutableList<String>,irab_:MutableList<String>):MutableList<String>{
            val kalimat_split = kalimat.split(" ")
            val kedudukan: MutableList<String> = ArrayList()
            var mubtada = false
            var fiil = false
            var fail = false
            var idhofah = false
            var kaana = false
            var inna = false
            for ((index, kata) in kalimat_split.withIndex()){
                val identity = identitas[index]
                val irab = irab_[index]
                when {
                    identity == "Keluarga Kaana" ->{
                        kedudukan.add(identity)
                        kaana = true
                    }
                    identity == "Keluarga Inna" ->{
                        kedudukan.add(identity)
                        inna = true
                    }
                    identity == "Adat Istisna'" -> kedudukan.add(identity)
                    identity == "Isim Dhomir" ->{
                        kedudukan.add("Mubtada'")
                        mubtada = true
                    }
                    kaana == true -> kedudukan.add("Mubtada' Kaana")
                    inna == true -> kedudukan.add("Mubtada' Inna")
                    index!=kalimat_split.size-1 && identitas[index+1]== "Lafadz Taukid" ->kedudukan.add("Taukid")
                    identity == "Lafadz Taukid" -> kedudukan.add("Lafadz Taukid")
                    identity == "Fi'il Mudhari'" ||
                            identity == "Fi'il Madhi" -> when (mubtada){
                        true -> {
                            kedudukan.add("Khobar (Fi'il)")
                            fiil = true
                        }
                        else -> {
                            kedudukan.add("Fi'il")
                            fiil = true
                        }
                    }
                    identity == "Fi'il Amr" ||
                            identity == "Fi'il Madhi" ->{
                        kedudukan.add("Fi'il")
                        fiil = true
                    }
                    irab == "Rofa'" -> when{
                        inna == true ->{
                            kedudukan.add("Khobar Inna")
                            inna = false
                        }
                        mubtada == true -> {
                            kedudukan.add("Khobar")
                            mubtada = false
                        }
                        fiil == true && mubtada == true ->{
                            kedudukan.add("Khobar (Fa'il)")
                            fiil = false
                            mubtada = false
                        }
                        fiil == true -> {
                            kedudukan.add("Fa'il")
                            fiil = false
                            fail = true
                        }
                        kata.substring(kata.length-1,kata.length)== "ُ" &&
                                kata.substring(0,2) != "ال" &&
                        index!=0-> {
                            kedudukan.add("Mudhof")
                            idhofah = true
                        }
                        index!=0 && irab_[index-1] == "Rofa'" -> {
                            kedudukan.add("Na'at")
                        }
                        else ->{
                            kedudukan.add("Mubtada'")
                            mubtada= true
                        }
                    }
                    identity == "Huruf Jer" ->when (mubtada){
                        true -> kedudukan.add("Khobar")
                        else -> kedudukan.add("Tidak Diketahui")
                    }
                    irab == "Nashob" -> when{
                        kaana == true ->{
                            kedudukan.add("Khobar Kaana")
                            kaana = false
                        }
                        index!=0 && identitas[index-1]=="Keluarga Inna" ->{
                            kedudukan.add("Mubtada'")
                            mubtada = true
                        }
                        index!=0 && mubtada==true ->{
                            kedudukan.add("Khobar")
                            mubtada = false
                        }
                        index!=0 &&
                                identitas[index-1]=="Adat Istisna'" -> kedudukan.add("Mustasna'")
                        fail == true &&
                                kata.takeLast(1) == "َ" ->{
                            kedudukan.add("Fa'il")
                            idhofah = true
                        }
                        fail == true || fiil == true -> {
                            kedudukan.add("Maf'ul Bih")
                            fail = false
                        }
                        kata.substring(kata.length-1,kata.length)=="َ" &&
                                kata.substring(0,2) != "ال" -> {
                            kedudukan.add("Mudhof")
                            idhofah = true
                        }
                        index!=0 && irab_[index-1] == "Nashob" -> {
                            kedudukan.add("Na'at")
                        }
                        else -> kedudukan.add("Tidak diketahui")
                    }
                    irab == "Jer" -> when{
                        mubtada == true ->{
                            kedudukan.add("Khobar")
                            mubtada = false
                        }
                        idhofah == true -> {
                            kedudukan.add("Mudhof Ilaih")
                            idhofah = false
                        }
                        kata.substring(kata.length-1,kata.length)== "ِ" &&
                                kata.substring(0,2) != "ال" -> {
                            kedudukan.add("Mudhof")
                            idhofah = true
                        }
                        index!=0 && irab_[index-1] == "Nashob" -> {
                            kedudukan.add("Na'at")
                        }
                        else -> kedudukan.add("Tidak diketahui")
                    }
                    index!=0 && identitas[index-1]=="Huruf Athof" -> kedudukan.add("Ma'thuf 'Alaih")
                    else -> kedudukan.add("Tidak diketahui")
                }
            }
            return kedudukan
        }
    }
}