package com.kotlinliza.foodmenu

class Foods {
    var foodName: String? =null
    var des: String? =null
    var image: Int? =null

    constructor(foodName: String,des:String,image:Int){
        this.foodName=foodName
        this.des=des
        this.image=image
    }
}