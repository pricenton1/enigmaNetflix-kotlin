package com.example.enigmanetflix.wrapper

class ResponseData(var status:String = "",
                   var message:Int,
                   var result:Any){

}

class ResponseDataList(var status:String = "",
                   var message:Int,
                   var result:List<Any>){

}