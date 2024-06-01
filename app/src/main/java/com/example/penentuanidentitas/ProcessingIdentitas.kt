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
                    kata == "يَا" -> {
                        identitas.add("Huruf Nida'")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
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
                        kata.substring(panjang - 2, panjang) == "ًا"-> {                   //fathah tanwin + alif (1)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                        kata.substring(panjang - 1, panjang) == "ٌ" -> {                    //dhammahtain    (2)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1, panjang) == "ِ" &&
                                kata.substring(panjang - 3, panjang)!="انِ"&&
                                kata.substring(panjang - 4, panjang) != "يْنِ" &&
                                kata.substring(panjang - 3, panjang - 1) != "ات" &&
                                kata.substring(panjang - 2, panjang) != "تِ" -> when {                //kasrah         (3)
                            kata.substring(0,2) == "ال" -> {              //when kedua adalah mencari  ciri awal
                                identitas.add("Isim Mufrod")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                        }
                        kata.substring(panjang - 1, panjang) == "َ" &&
                                kata.substring(panjang - 4, panjang) != "وْنَ" &&
                                kata.substring(panjang - 3, panjang) != "ْتَ" &&
                                kata.substring(panjang - 4, panjang) != "يْنَ" &&
                                kata.substring(panjang - 3, panjang) != "ْنَ" &&
                                kata.substring(panjang - 2, panjang) != "نَ" &&
                                kata.substring(panjang - 2, panjang) != "يَ" -> when {                 //fathah         (4)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            else -> when(panjang){
                                6, 8 ->{
                                    identitas.add("Fiil Madhi")
                                    ciriAwal.add("None")
                                    ciriAkhir.add(kata.substring(panjang - 1, panjang))
                                }
                                else ->{
                                    identitas.add("Isim Mufrod")
                                    ciriAwal.add("None")
                                    ciriAkhir.add(kata.substring(panjang - 1, panjang))
                                }
                            }
                        }
                        kata.substring(panjang - 1, panjang) == "ْ" -> when {                //sukun          (5)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            else -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                        }
                        kata.substring(panjang - 1, panjang) == "ا" &&
                                kata.substring(panjang - 3, panjang) != "تَا" &&
                                kata.substring(panjang - 5, panjang) != "تُمَا" &&
                                kata.substring(panjang - 2, panjang) != "َا" &&
                                kata.substring(panjang - 3, panjang) != "وْا" -> when {                 //alif           (6)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            else -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                        }
                        kata.substring(panjang - 3, panjang) == "انِ" -> when {                   //aani        (7)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            else -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                        }
                        kata.substring(panjang - 1, panjang) == "ُ" &&
                                kata.substring(panjang - 3, panjang) != "ْتُ" -> when {                  //dhammah    (8)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ن" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                        }
                        kata.endsWith("ٍ") -> {                       //Kasrahtain     (9)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 4, panjang) == "وْنَ" -> when {                   //uuna          (10)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            else -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                        }
                        kata.substring(panjang - 3, panjang) == "ْتُ" -> {                         //sukun tu     (11)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        kata.substring(panjang-1, panjang) == "ً" ->{                        // Fathah Tanwin    (12)
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 3, panjang) == "ْتَ" -> {                         //sukun ta     (13)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        kata.substring(panjang - 4, panjang) == "يْنَ" -> when {                     //iina        (14)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            else -> {
                                identitas.add("Jama' Mudzakar Salim")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                        }
                        kata.substring(panjang - 4, panjang) == "يْنِ" -> when {                     //ayni        (15)
                            kata.substring(0,2) == "ال" -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add(kata.substring(0,2))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            else -> {
                                identitas.add("Isim Tatsniyah")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
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
                        kata.substring(panjang - 2, panjang) == "تْ" -> {                           //ta sukun   (17)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                        kata.substring(panjang - 3, panjang) == "تَا" -> when {                      //taa        (18)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            else -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                        }
                        kata.substring(panjang - 5, panjang) == "تُمَا" -> {                        //tumaa       (19)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 5, panjang))
                        }
                        kata.substring(panjang - 4, panjang) == "تُمْ" -> {                         //tum         (20)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        kata.substring(panjang - 2, panjang) == "تِ" -> {                           //ti         (21)
                            identitas.add("Fi'il Madhi'")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 3, panjang) == "ْنَ" -> {                          //sukun na    (22)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        kata.substring(panjang - 4, panjang) == "ُنَّ" -> {                         //unna         (23)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        kata.substring(panjang - 2, panjang) == "نَ" -> when {                       //na         (24)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                            else -> {
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                        }
                        kata.substring(panjang - 2, panjang) == "يَ" -> when {                       //ya         (25)
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
                            }
                        }
                        kata.substring(panjang - 3, panjang) == "ُوْ" -> {                          //uu          (26)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        kata.substring(panjang - 2, panjang) == "َا" -> when {
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                            else ->{
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                        }
                        kata.substring(panjang - 3, panjang) == "وْا" -> when {
                            kata.substring(0,1) == "ا" -> {
                                identitas.add("Fi'il Amr'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            kata.substring(0,1) == "ي" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Af'alul Khomsah")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            else ->{
                                identitas.add("Fi'il Madhi")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
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
                when (identity){
                    "Huruf Athof", "Amil Nawashib",
                    "Amil Jawazim", "Huruf Jer",
                    "Asmaul Khamsah", "Keluarga Kaana",
                    "Keluarga Inna", "Isim Dhomir",
                    "Lafadz Taukid", "Adat Istisna'" ->{
                        irab.add("Mabni")
                        tanda_irab.add("None")
                    }
                    "Isim Mufrod" -> when (akhir) {
                        "ُ","ٌ" ->{
                            irab.add("Rafa'")
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
                    "Fi'il Mudhari'" -> when (akhir){
                        "ُ" ->{
                            irab.add("Rafa'")
                            tanda_irab.add(akhir)
                        }
                        "َ" ->when{
                            index!=0 && identitas[index-1] == "Amil Jawazim"->{
                                irab.add("Jazm")
                                tanda_irab.add("Membuang Huruf Illat")
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
                    "Af'alul Khomsah" -> when(akhir){
                        "انِ","وْنَ","يْنَ" -> {
                            irab.add("Rafa'")
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
                    "Fi'il Madhi" -> {
                        irab.add("Mabni")
                        tanda_irab.add("None")
                    }
                    "Fi'il Amr" -> {
                        irab.add("Mabni")
                        tanda_irab.add("None")
                    }
                    "Isim Tatsniyah" -> when(akhir){
                        "انِ" ->{
                            irab.add("Rafa'")
                            tanda_irab.add("ا")
                        }
                        "يْنِ" ->{
                            irab.add("Nashab")
                            tanda_irab.add("ي")
                        }
                    }
                    "Jama' Mudzakar Salim" -> when(akhir){
                        "وْنَ" ->{
                            irab.add("Rafa'")
                            tanda_irab.add("و")
                        }
                        "يْنَ" ->when{
                            identitas[index-1]=="Amil Nawashib" ->{
                                irab.add("Nashab")
                                tanda_irab.add("ي")
                            }
                            identitas[index-1]=="Huruf Jer" ->{
                                irab.add("Jer")
                                tanda_irab.add("ي")
                            }
                        }
                    }
                    "Jama' Muannats Salim" -> when(kata.substring(kata.length-1,kata.length)){
                        "ُ" -> {
                            irab.add("Rafa'")
                            tanda_irab.add(kata.substring(kata.length-1,kata.length))
                        }
                        "ِ" -> when{
                            index != 0 &&
                                    identitas[index - 1] == "Huruf Jer" ->{
                                irab.add("Jazm")
                                tanda_irab.add(kata.substring(kata.length-1,kata.length))
                            }
                            index!=0 &&
                                    identitas[index-1] == "Amil Nawashib" ->{
                                irab.add("Nashab")
                                tanda_irab.add(kata.substring(kata.length-1,kata.length))
                            }
                            else ->{
                                irab.add("Mengikuti Irab Sebelumnya")
                                tanda_irab.add(kata.substring(kata.length-1,kata.length))
                            }
                        }
                    }
                    "Asmaul Khomsah" -> when{
                        kata.substring(4,5) == "ُ" ||
                                kata.substring(4,5) == "ٌ" ->{
                            irab.add("Rafa'")
                            tanda_irab.add(kata.substring(4,5))
                        }
                        kata.substring(4,5) == "َ" ->{
                            irab.add("Nashab")
                            tanda_irab.add(kata.substring(4,5))
                        }
                        kata.substring(4,5) == "ِ" ->{
                            irab.add("Jer")
                            tanda_irab.add(kata.substring(4,5))
                        }
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
            for ((index, kata) in kalimat_split.withIndex()){
                val identity = identitas[index]
                val irab = irab_[index]
                when {
                    identity == "Keluarga Kaana" ||
                            identity == "Keluarga Inna" ||
                            identity == "Adat Istisna'" ||
                            identity == "Huruf Nida'" -> kedudukan.add("None")
                    identity == "Isim Dhomir" ->{
                        kedudukan.add("Mubtada")
                        mubtada = true
                    }
                    identity == "Lafadz Taukid" -> kedudukan.add("Taukid")
                    index != 0 && identitas[index-1] == "Huruf Nida'"-> kedudukan.add("Munada")
                    irab == "Rafa'" -> when{
                        mubtada == true -> {
                            kedudukan.add("Khabar")
                            mubtada = false
                        }
                        fiil == true && mubtada == true ->{
                            kedudukan.add("Khabar (Fa'il)")
                            fiil = false
                            mubtada = false
                        }
                        fiil == true -> {
                            kedudukan.add("Fa'il")
                            fiil = false
                            fail = true
                        }
                        kata.substring(kata.length-1,kata.length)!= "ٌ" &&
                                kata.substring(0,2) != "ال" -> {
                            kedudukan.add("Mudhof")
                            idhofah = true
                        }
                        index!=0 && irab_[index-1] == "Rafa'" -> {
                            kedudukan.add("Na'at")
                        }
                        else ->{
                            kedudukan.add("Mubtada")
                            mubtada= true
                        }
                    }
                    identity == "Huruf Jer" ->when (mubtada){
                        true -> kedudukan.add("Khabar")
                        else -> kedudukan.add("Tidak Diketahui")
                    }
                    identity == "Fi'il Mudhari'" ||
                            identity == "Fi'il Madhi" -> when (mubtada){
                        true -> {
                            kedudukan.add("Khabar (Fi'il)")
                            fiil = true
                        }
                        else -> {
                            kedudukan.add("Fi'il")
                            fiil = true
                        }
                    }
                    identity == "Fi'il Amr" ->{
                        kedudukan.add("Fi'il")
                        fiil = true
                    }
                    irab == "Nashob" -> when{
                        index!=0 && identitas[index-1]=="Keluarga Inna" ->{
                            kedudukan.add("Mubtada")
                            mubtada = true
                        }
                        index!=0 && mubtada==true ->{
                            kedudukan.add("Khabar")
                            mubtada = false
                        }
                        index!=0 &&
                                identitas[index-1]=="Adat Istisna'" -> kedudukan.add("Istisna'")
                        fail == true || fiil == true -> {
                            kedudukan.add("Maf'ul Bih")
                            fail = false
                        }
                        kata.substring(kata.length-1,kata.length)!= "ً" &&
                                kata.substring(0,2) != "ال" -> {
                            kedudukan.add("Mudhof")
                            idhofah = true
                        }
                        index!=0 && irab_[index-1] == "Nashab" -> {
                            kedudukan.add("Na'at")
                        }
                        else -> kedudukan.add("Tidak diketahui")
                    }
                    irab == "Jer" -> when{
                        mubtada == true ->{
                            kedudukan.add("Khabar")
                            mubtada = false
                        }
                        idhofah == true -> {
                            kedudukan.add("Mudhof Ilaih")
                            idhofah = false
                        }
                        kata.substring(kata.length-1,kata.length)!= "ٍ" &&
                                kata.substring(0,2) != "ال" -> {
                            kedudukan.add("Mudhof")
                            idhofah = true
                        }
                        index!=0 && irab_[index-1] == "Nashab" -> {
                            kedudukan.add("Na'at")
                        }
                        else -> kedudukan.add("Tidak diketahui")
                    }
                    else -> kedudukan.add("Tidak diketahui")
                }
            }
            return kedudukan
        }
    }
}