package com.example.englishbook.data.entity

import java.io.Serializable

data class Kitaplar(var kitap_id:String?="",
                    var book_name:String?="",
                    var image_name:String?="",
                    var book_level:String?="",
                    var ozel_metin:String?=""):Serializable{}
