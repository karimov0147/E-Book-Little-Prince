package com.example.bubook.models

import java.io.Serializable

class Part : Serializable {
    var title : String? = null
    var str1 : String? = null
    var img1 : Int? = null


    constructor(
        title: String?,
        str1: String?,
        img1: Int?
    ) {
        this.title = title
        this.str1 = str1
        this.img1 = img1
    }
}