package com.example.penentuanidentitas

class ProcessingKalimat {
    companion object {
        fun identitas(kalimat: String): Triple<MutableList<String>, MutableList<String>, MutableList<String>> {
            val identitas: MutableList<String> =
                ArrayList() //berisi identitas kata dari setiap kata
            val ciriAwal: MutableList<String> =
                ArrayList()  //berisi ciri awal kata dari setiap kata
            val ciriAkhir: MutableList<String> =
                ArrayList() //berisi ciri akhir kata dari setiap kata
            val kalimat_split = kalimat.split(" ")
            for (kata in kalimat_split) {
                val panjang = kata.length
                when {                                                                 //when pertama adalah mencari ciri akhir
                    kata.substring(panjang - 2, panjang) == "ًا" -> {                   //fathah tanwin  (1)
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
                        kata.substring(panjang - 2) == "ال" -> {              //when kedua adalah mencari  ciri awal
                            identitas.add("Isim Mufrod")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }

                        kata.substring(panjang - 1) == "ي" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
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
                        kata.substring(panjang - 2) == "ال" -> {
                            identitas.add("Isim Mufrod")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ي" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        else -> {
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                    }
                    kata.substring(panjang - 1, panjang) == "ْ" -> when {                //sukun          (5)
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        else -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                    }
                    kata.substring(panjang - 1, panjang) == "ا" &&
                            kata.substring(panjang - 3, panjang) == "تَا" &&
                            kata.substring(panjang - 5, panjang) == "تُمَا" -> when {                 //alif           (6)
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        else -> {
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                    }
                    kata.substring(panjang - 3, panjang) == "انِ" -> when {                   //aani        (7)
                        kata.substring(panjang - 2) == "ال" -> {
                            identitas.add("Isim Tatsniyah")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        kata.substring(panjang - 1) == "ي" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
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
                        kata.substring(panjang - 2) == "ال" -> {
                            identitas.add("Isim Mufrod")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ي" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ن" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 1, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
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
                        kata.substring(panjang - 2) == "ال" -> {
                            identitas.add("Jama' Mudzakar Salim")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        kata.substring(panjang - 1) == "ي" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
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
                    kata.substring(panjang - 3, panjang) == "ْتَ" -> {                         //sukun ta     (12)
                        identitas.add("Fi'il Madhi")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 3, panjang))
                    }
                    kata.substring(panjang - 4, panjang) == "يْنَ" -> when {                     //iina        (13)
                        kata.substring(panjang - 2) == "ال" -> {
                            identitas.add("Jama' Mudzakar Salim")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        else -> {
                            identitas.add("Jama' Mudzakar Salim")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                    }
                    kata.substring(panjang - 4, panjang) == "يْنِ" -> when {                     //ayni        (14)
                        kata.substring(panjang - 2) == "ال" -> {
                            identitas.add("Isim Tatsniyah")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                        else -> {
                            identitas.add("Isim Tatsniyah")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 4, panjang))
                        }
                    }
                    kata.substring(panjang - 3, panjang - 1) == "ات" -> when {                  //aati       (15)
                        kata.substring(panjang - 2) == "ال" -> {
                            identitas.add("Jama' Muannats Salim")
                            ciriAwal.add(kata.substring(panjang - 2))
                            ciriAkhir.add(kata.substring(panjang - 3, panjang - 1))
                        }
                        else -> {
                            identitas.add("Jama' Muannats Salim")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 3, panjang - 1))
                        }
                    }
                    kata.substring(panjang - 2, panjang) == "تْ" -> {                           //ta sukun   (16)
                        identitas.add("Fi'il Madhi")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 2, panjang))
                    }
                    kata.substring(panjang - 3, panjang) == "تَا" -> when {                      //taa        (17)
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                        else -> {
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 3, panjang))
                        }
                    }
                    kata.substring(panjang - 5, panjang) == "تُمَا" -> {                        //tumaa       (18)
                        identitas.add("Fi'il Madhi")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 5, panjang))
                    }
                    kata.substring(panjang - 4, panjang) == "تُمْ" -> {                         //tum         (19)
                        identitas.add("Fi'il Madhi")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 4, panjang))
                    }
                    kata.substring(panjang - 2, panjang) == "تِ" -> {                           //ti         (20)
                        identitas.add("Fi'il Madhi'")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 1, panjang))
                    }
                    kata.substring(panjang - 3, panjang) == "ْنَ" -> {                          //sukun na    (21)
                        identitas.add("Fi'il Madhi")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 3, panjang))
                    }
                    kata.substring(panjang - 4, panjang) == "ُنَّ" -> {                         //unna         (22)
                        identitas.add("Fi'il Madhi")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 4, panjang))
                    }
                    kata.substring(panjang - 2, panjang) == "نَ" -> when {                       //na         (23)
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                        kata.substring(panjang - 1) == "ي" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                        kata.substring(panjang - 1) == "ت" -> {
                            identitas.add("Fi'il Mudhari'")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                        else -> {
                            identitas.add("Fi'il Madhi")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                    }
                    kata.substring(panjang - 2, panjang) == "يَ" -> when {                       //ya         (24)
                        kata.substring(panjang - 1) == "ا" -> {
                            identitas.add("Fi'il Amr")
                            ciriAwal.add(kata.substring(panjang - 1))
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                        else -> {
                            identitas.add("Isim Mufrod")
                            ciriAwal.add("None")
                            ciriAkhir.add(kata.substring(panjang - 2, panjang))
                        }
                    }
                    kata.substring(panjang - 3, panjang) == "ُوْ" -> {                          //uu          (25)
                        identitas.add("Fi'il Madhi")
                        ciriAwal.add("None")
                        ciriAkhir.add(kata.substring(panjang - 3, panjang))
                    }
                    kata.substring(panjang - 4, panjang - 2) == "وْ" &&                       //wawu sukun u      (26)
                            kata.substring(panjang - 2, panjang - 1) == "ُ" -> when {
                        kata.substring(panjang - 1) == "م" -> {
                            identitas.add("Maf'ul Bih")
                            ciriAwal.add(kata.substring(panjang - 1))
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
            return Triple(identitas, ciriAwal, ciriAkhir)
        }
    }
}