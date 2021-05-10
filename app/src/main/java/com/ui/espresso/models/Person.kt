package com.ui.espresso.models

data class Person(
    @JvmField var _name: String,
    @JvmField var _age: Int,
    @JvmField val _messages: List<String>

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

