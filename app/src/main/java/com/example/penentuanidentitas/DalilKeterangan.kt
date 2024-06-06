package com.example.penentuanidentitas

class DalilKeterangan {
    companion object{
        fun dalil(irab:String,identitas:String,tanda_irab:String):Pair<MutableList<String>,MutableList<String>>{
            var arab:MutableList<String> = ArrayList()
            var terjemah:MutableList<String> = ArrayList()
            when(irab){
                "rofa'" -> when(identitas){
                    "Isim Mufrod", "Jama' Muannats Salim", "Fi'il Mudhari'" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaRofa["arab"]!!.get(2),
                            BaitImrithi.babTandaRofa["arab"]!!.get(3))
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(2),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(3))
                    }
                    "Jama' Mudzakkar Salim", "Asmaul Khomsah" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaRofa["arab"]!!.get(4),
                            BaitImrithi.babTandaRofa["arab"]!!.get(5),
                            BaitImrithi.babTandaRofa["arab"]!!.get(6)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(4),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(5),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(6)
                        )
                    }
                    "Isim Tatsniyah" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaRofa["arab"]!!.get(7)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(7)
                        )
                    }
                    "Af'alul Khomsah" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaRofa["arab"]!!.get(7),
                            BaitImrithi.babTandaRofa["arab"]!!.get(8),
                            BaitImrithi.babTandaRofa["arab"]!!.get(9)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(7),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(8),
                            BaitImrithi.babTandaRofa["terjemah"]!!.get(9)
                        )
                    }
                }
                "Nashob" -> when(identitas){
                    "Isim Mufrod", "Fi'il Mudhari'" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaNashob["arab"]!!.get(2)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(2)
                        )
                    }
                    "Asmaul Khomsah" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaNashob["arab"]!!.get(3)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(3)
                        )
                    }
                    "Isim Tatsniyah", "Jama' Mudzakkar Salim" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaNashob["arab"]!!.get(4)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(4)
                        )
                    }
                    "Jama' Muannats Salim" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaNashob["arab"]!!.get(4)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(4)
                        )
                    }
                    "Af'alul Khomsah" ->{
                        arab = mutableListOf(
                            BaitImrithi.babTandaNashob["arab"]!!.get(5)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaNashob["terjemah"]!!.get(5)
                        )
                    }
                }
                "Jer" -> when(identitas){
                    "Isim Mufrod", "Jama' Muannats Salim" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaJer["arab"]!!.get(2)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaJer["terjemah"]!!.get(2)
                        )
                    }
                    "Isim Tatsniyah", "Jama' Mudzakkar Salim", "Asmaul Khomsah" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaJer["arab"]!!.get(3)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaJer["terjemah"]!!.get(3)
                        )
                    }
                    else -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaJer["arab"]!!.get(4)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaJer["terjemah"]!!.get(4)
                        )
                    }
                }
                "Jazm" -> when(identitas){
                    "Af'alul Khomsah" -> {
                        arab = mutableListOf(
                            BaitImrithi.babTandaJazm["arab"]!!.get(2)
                        )
                        terjemah = mutableListOf(
                            BaitImrithi.babTandaJazm["terjemah"]!!.get(2)
                        )
                    }
                    "Fi'il Mudhari'" -> {
                        when(tanda_irab){
                            "Membuang Huruf 'Illat" -> {
                                arab = mutableListOf(
                                    BaitImrithi.babTandaJazm["arab"]!!.get(3)
                                )
                                terjemah = mutableListOf(
                                    BaitImrithi.babTandaJazm["terjemah"]!!.get(3)
                                )
                            }
                            else -> {
                                arab = mutableListOf(
                                    BaitImrithi.babTandaJazm["arab"]!!.get(4)
                                )
                                terjemah = mutableListOf(
                                    BaitImrithi.babTandaJazm["terjemah"]!!.get(4)
                                )
                            }
                        }
                    }
                }
                else -> ""
            }
            return Pair(arab,terjemah)
        }
    }
}