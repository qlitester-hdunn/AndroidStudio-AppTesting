package com.ui.espresso.models

import com.google.gson.annotations.SerializedName

class Person (

     @JvmField
     @SerializedName("name")
     var _name: String,

     @JvmField
     @SerializedName("age")
     var _age: Int,

     @JvmField
     @SerializedName("messages")
     val _messages: List<String>

){
    fun getName(): String {
        return this._name
    }
    fun getAge(): Int {
        return this._age
    }
    fun getMessages(): List<String> {
        return this._messages
    }
}

