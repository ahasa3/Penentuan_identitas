package com.example.penentuanidentitas

import kotlinx.coroutines.sync.Mutex

class DalilKeterangan {
    companion object{
        fun dalilIrab(text:String,irab:String,identitas:String,tanda_irab:String,identitas_sebelumnya:String,kedudukan:String):MutableList<String>{
            var ket:MutableList<String> = ArrayList()
            when{
                identitas=="Huruf Jer"||
                        identitas=="Huruf Athof"||
                        identitas=="Amil Nawashib"||
                        identitas=="Amil Jawazim"||
                        identitas=="Adat Istisna'"||
                        identitas=="Huruf Nida'" ->{
                            ket = mutableListOf(
                                text,
                                BaitImrithi.babKalam["arab"]!!.get(4),
                                BaitImrithi.babKalam["arab"]!!.get(5),
                                BaitImrithi.babKalam["terjemah"]!!.get(4),
                                BaitImrithi.babKalam["terjemah"]!!.get(5)
                            )
                        }
                identitas=="Isim Dhomir"||
                identitas=="Fi'il Madhi"||
                identitas=="Fi'il Amr"->{
                            ket = mutableListOf(
                                text,
                                BaitImrithi.babIrob["arab"]!!.get(8),
                                BaitImrithi.babIrob["terjemah"]!!.get(8)
                            )
                        }
                kedudukan=="Mubtada Kaana" ||
                kedudukan=="Khobar Kaana"->{
                    ket = mutableListOf(
                        text,
                        BaitImrithi.babKeluargaKaana["arab"]!!.get(1),
                        BaitImrithi.babKeluargaKaana["arab"]!!.get(2),
                        BaitImrithi.babKeluargaKaana["arab"]!!.get(3),
                        BaitImrithi.babKeluargaKaana["terjemah"]!!.get(1),
                        BaitImrithi.babKeluargaKaana["terjemah"]!!.get(2),
                        BaitImrithi.babKeluargaKaana["terjemah"]!!.get(3)
                    )
                }
                kedudukan=="Mubtada Inna" ||
                        kedudukan=="Khobar Inna"->{
                            ket = mutableListOf(
                                text,
                                BaitImrithi.babKeluargaInna["arab"]!!.get(1),
                                BaitImrithi.babKeluargaInna["arab"]!!.get(2),
                                BaitImrithi.babKeluargaInna["terjemah"]!!.get(1),
                                BaitImrithi.babKeluargaInna["terjemah"]!!.get(2)
                            )
                        }
                irab=="Mengikuti Irab Sebelumnya" ->{
                    when(identitas_sebelumnya){
                        "Huruf Athof" -> {
                            ket = mutableListOf(
                                text,
                                BaitImrithi.babAthof["arab"]!!.get(1),
                                BaitImrithi.babAthof["arab"]!!.get(2),
                                BaitImrithi.babAthof["terjemah"]!!.get(1),
                                BaitImrithi.babAthof["terjemah"]!!.get(2)
                            )
                        }
                        else -> {
                            ket = mutableListOf(text,"-")
                        }
                    }
                }
                irab=="Rofa'" -> when(identitas){
                    "Isim Mufrod" ->{
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaRofa["arab"]!!.get(2),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(2)
                        )
                    }
                    "Jama' Muannats Salim", "Fi'il Mudhari'" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaRofa["arab"]!!.get(2),
                            BaitImrithi.babTandaRofa["arab"]!!.get(3),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(2),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(3))
                    }
                    "Jama' Mudzakkar Salim" ->{
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaRofa["arab"]!!.get(4),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(4)
                        )
                    }
                    "Asmaul Khomsah" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaRofa["arab"]!!.get(4),
                            BaitImrithi.babTandaRofa["arab"]!!.get(5),
                            BaitImrithi.babTandaRofa["arab"]!!.get(6),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(4),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(5),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(6)
                        )
                    }
                    "Isim Tatsniyah" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaRofa["arab"]!!.get(7),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(7)
                        )
                    }
                    "Af'alul Khomsah" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaRofa["arab"]!!.get(7),
                            BaitImrithi.babTandaRofa["arab"]!!.get(8),
                            BaitImrithi.babTandaRofa["arab"]!!.get(9),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(7),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(8),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(9)
                        )
                    }
                }
                irab=="Nashob" -> when(identitas){
                    "Isim Mufrod", "Fi'il Mudhari'" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaNashob["arab"]!!.get(2),
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(2)
                        )
                    }
                    "Asmaul Khomsah" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaNashob["arab"]!!.get(3),
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(3)
                        )
                    }
                    "Isim Tatsniyah", "Jama' Mudzakkar Salim" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaNashob["arab"]!!.get(4),
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(4)
                        )
                    }
                    "Jama' Muannats Salim" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaNashob["arab"]!!.get(4),
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(4)
                        )
                    }
                    "Af'alul Khomsah" ->{
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaNashob["arab"]!!.get(5),
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(5)
                        )
                    }
                }
                irab=="Jer" -> when(identitas){
                    "Isim Mufrod", "Jama' Muannats Salim" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaJer["arab"]!!.get(2),
                            BaitImrithi.babTandaJer["terjemah"]!!.get(2)
                        )
                    }
                    "Isim Tatsniyah", "Jama' Mudzakkar Salim", "Asmaul Khomsah" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaJer["arab"]!!.get(3),
                            BaitImrithi.babTandaJer["terjemah"]!!.get(3)
                        )
                    }
                    else -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaJer["arab"]!!.get(4),
                            BaitImrithi.babTandaJer["terjemah"]!!.get(4)
                        )
                    }
                }
                irab=="Jazm" -> when(identitas){
                    "Af'alul Khomsah" -> {
                        ket = mutableListOf(
                            text,
                            BaitImrithi.babTandaJazm["arab"]!!.get(2),
                            BaitImrithi.babTandaJazm["terjemah"]!!.get(2)
                        )
                    }
                    "Fi'il Mudhari'" -> {
                        when(tanda_irab){
                            "Membuang Huruf 'Illat" -> {
                                ket = mutableListOf(
                                    text,
                                    BaitImrithi.babTandaJazm["arab"]!!.get(4),
                                    BaitImrithi.babTandaJazm["terjemah"]!!.get(4)
                                )
                            }
                            else -> {
                                ket = mutableListOf(
                                    text,
                                    BaitImrithi.babTandaJazm["arab"]!!.get(3),
                                    BaitImrithi.babTandaJazm["terjemah"]!!.get(3)
                                )
                            }
                        }
                    }
                }
                else -> {
                    ket = mutableListOf(text,"-")
                }
            }
            return ket
        }
        fun dalilKedudukan(text:String,kedudukan:String,identitas:String):MutableList<String>{
            val posisi:MutableList<String>
            when{
                kedudukan == "Mubtada'" ->{
                    when{
                        identitas=="Isim Dhomir" ->{
                            posisi = mutableListOf(
                                text,
                                BaitImrithi.babMubtadaKhabar["arab"]!!.get(5),
                                BaitImrithi.babMubtadaKhabar["arab"]!!.get(6),
                                BaitImrithi.babMubtadaKhabar["terjemah"]!!.get(5),
                                BaitImrithi.babMubtadaKhabar["terjemah"]!!.get(6)
                            )
                        }
                        else->{
                            posisi = mutableListOf(
                                text,
                                BaitImrithi.babMubtadaKhabar["arab"]!!.get(1),
                                BaitImrithi.babMubtadaKhabar["terjemah"]!!.get(1)
                                )
                        }
                    }
                }
                kedudukan =="Khobar" ->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babMubtadaKhabar["arab"]!!.get(2),
                        BaitImrithi.babMubtadaKhabar["terjemah"]!!.get(2)
                    )
                }
                kedudukan =="Khobar (Fa'il)" ||
                kedudukan =="Khobar (Fi'il)"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babMubtadaKhabar["arab"]!!.get(10),
                        BaitImrithi.babMubtadaKhabar["arab"]!!.get(11),
                        BaitImrithi.babMubtadaKhabar["terjemah"]!!.get(10),
                        BaitImrithi.babMubtadaKhabar["terjemah"]!!.get(11)
                    )
                }
                kedudukan=="Mubtada' Kaana" ||
                        kedudukan=="Khobar Kaana"||
                identitas=="Keluarga Kaana"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babKeluargaKaana["arab"]!!.get(1),
                        BaitImrithi.babKeluargaKaana["arab"]!!.get(2),
                        BaitImrithi.babKeluargaKaana["arab"]!!.get(3),
                        BaitImrithi.babKeluargaKaana["terjemah"]!!.get(1),
                        BaitImrithi.babKeluargaKaana["terjemah"]!!.get(2),
                        BaitImrithi.babKeluargaKaana["terjemah"]!!.get(3)
                    )
                }
                kedudukan=="Mubtada' Inna" ||
                        kedudukan=="Khobar Inna"||
                identitas=="Keluarga Inna"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babKeluargaInna["arab"]!!.get(1),
                        BaitImrithi.babKeluargaInna["arab"]!!.get(2),
                        BaitImrithi.babKeluargaInna["terjemah"]!!.get(1),
                        BaitImrithi.babKeluargaInna["terjemah"]!!.get(2)
                    )
                }
                kedudukan=="Taukid" ->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babTaukid["arab"]!!.get(1),
                        BaitImrithi.babTaukid["arab"]!!.get(2),
                        BaitImrithi.babTaukid["arab"]!!.get(3),
                        BaitImrithi.babTaukid["arab"]!!.get(4),
                        BaitImrithi.babTaukid["terjemah"]!!.get(1),
                        BaitImrithi.babTaukid["terjemah"]!!.get(2),
                        BaitImrithi.babTaukid["terjemah"]!!.get(3),
                        BaitImrithi.babTaukid["terjemah"]!!.get(4)
                    )
                }
                identitas=="Lafadz Taukid"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babTaukid["arab"]!!.get(3),
                        BaitImrithi.babTaukid["arab"]!!.get(4),
                        BaitImrithi.babTaukid["terjemah"]!!.get(3),
                        BaitImrithi.babTaukid["terjemah"]!!.get(4)
                    )
                }
                kedudukan=="Fi'il" ->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babIsimRofa["arab"]!!.get(2),
                        BaitImrithi.babIsimRofa["arab"]!!.get(3),
                        BaitImrithi.babIsimRofa["terjemah"]!!.get(2),
                        BaitImrithi.babIsimRofa["terjemah"]!!.get(3)
                    )
                }
                kedudukan=="Fa'il" ->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babIsimRofa["arab"]!!.get(2),
                        BaitImrithi.babIsimRofa["arab"]!!.get(3),
                        BaitImrithi.babIsimRofa["terjemah"]!!.get(2),
                        BaitImrithi.babIsimRofa["terjemah"]!!.get(3)
                    )
                }
                kedudukan=="Mudhof" ->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babIdhofah["arab"]!!.get(1),
                        BaitImrithi.babIdhofah["arab"]!!.get(2),
                        BaitImrithi.babIdhofah["terjemah"]!!.get(1),
                        BaitImrithi.babIdhofah["terjemah"]!!.get(2)
                    )
                }
                kedudukan=="Mudhof Ilaih"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babIdhofah["arab"]!!.get(1),
                        BaitImrithi.babIdhofah["arab"]!!.get(2),
                        BaitImrithi.babIdhofah["terjemah"]!!.get(1),
                        BaitImrithi.babIdhofah["terjemah"]!!.get(2)
                    )
                }
                kedudukan=="Na'at" ->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babNaat["arab"]!!.get(1),
                        BaitImrithi.babNaat["terjemah"]!!.get(1)
                    )
                }
                kedudukan=="Maf'ul Bih"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babIsimNashob["arab"]!!.get(3),
                        BaitImrithi.babIsimNashob["terjemah"]!!.get(3)
                    )
                }
                kedudukan=="Mustasna'"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babIstisna["arab"]!!.get(1),
                        BaitImrithi.babIstisna["arab"]!!.get(2),
                        BaitImrithi.babIstisna["arab"]!!.get(3),
                        BaitImrithi.babIstisna["terjemah"]!!.get(1),
                        BaitImrithi.babIstisna["terjemah"]!!.get(2),
                        BaitImrithi.babIstisna["terjemah"]!!.get(3)
                    )
                }
                kedudukan == "Ma'thuf 'Alaih"->{
                    posisi = mutableListOf(
                        text,
                        BaitImrithi.babAthof["arab"]!!.get(1),
                        BaitImrithi.babAthof["arab"]!!.get(2),
                        BaitImrithi.babAthof["terjemah"]!!.get(1),
                        BaitImrithi.babAthof["terjemah"]!!.get(2)
                    )
                }
                else->{
                    posisi = mutableListOf(text,"-")
                }
            }
            return posisi
        }
    }
}