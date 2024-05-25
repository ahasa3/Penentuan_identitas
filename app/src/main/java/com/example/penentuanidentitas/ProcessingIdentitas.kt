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
            "tidak_gabung" to listOf("مِنْ","اِلَى","فِى","عَنْ","عَلَى","مُذْ","مُنْذُ","رُبَّ"),
            "gabung" to listOf("بِ","كَ","لِ","وَ","تَ"))
        fun identitas(kalimat: String): Triple<MutableList<String>, MutableList<String>, MutableList<String>> {
            val identitas: MutableList<String> =ArrayList() //berisi identitas kata dari setiap kata
            val ciriAwal: MutableList<String> =ArrayList()  //berisi ciri awal kata dari setiap kata
            val ciriAkhir: MutableList<String> =ArrayList() //berisi ciri akhir kata dari setiap kata
            val kalimat_split = kalimat.split(" ")
            for (kata in kalimat_split) {
                val panjang = kata.length
                when{
                    huruf_athof["tidak_gabung"]!!.contains(kata) ->{                        //Kata Pengecualian
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
                    lafadz_taukid.contains(kata.substring(0,4)) ||
                            lafadz_taukid.contains(kata.substring(0,5)) ||
                            lafadz_taukid.contains(kata.substring(0,7)) -> {
                        identitas.add("Lafadz Taukid")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    adat_istitsna.contains(kata) -> {
                        identitas.add("Adat Istisna'")
                        ciriAwal.add("None")
                        ciriAkhir.add("None")
                    }
                    else -> when {                                                                 //when pertama adalah mencari ciri akhir
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
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 1, panjang))
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
                                kata.substring(panjang - 5, panjang) != "تُمَا" -> when {                 //alif           (6)
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
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 3, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
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
                                kata.substring(panjang - 3, panjang) != "ْتُ" &&
                                kata.substring(panjang - 4, panjang - 2) != "وْ" -> when {                  //dhammah    (8)
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
                        kata.substring(panjang - 1, panjang) == "ٍ" -> {                       //Kasrahtain     (9)
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
                                identitas.add("Fi'il Mudhari'")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang))
                            }
                            kata.substring(0,1) == "ت" -> {
                                identitas.add("Fi'il Mudhari'")
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
                                identitas.add("Fi'il Mudhari'")
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
                                ciriAkhir.add(kata.substring(panjang - 2, panjang))
                            }
                        }
                        kata.substring(panjang - 3, panjang) == "ُوْ" -> {                          //uu          (26)
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        kata.substring(panjang - 4, panjang - 2) == "وْ" &&                       //wawu sukun u      (27)
                                kata.substring(panjang - 2, panjang - 1) == "ُ" -> when {
                            kata.substring(0,1) == "م" -> {
                                identitas.add("Maf'ul Bih")
                                ciriAwal.add(kata.substring(0,1))
                                ciriAkhir.add(kata.substring(panjang - 4, panjang - 1))
                            }
                            else -> {
                                identitas.add("Isim Mufrod")
                                ciriAwal.add("None")
                                ciriAkhir.add(kata.substring(panjang - 4, panjang - 1))
                            }
                        }
                    }
                }

            }
            return Triple(identitas, ciriAwal, ciriAkhir)
        }
    }
}