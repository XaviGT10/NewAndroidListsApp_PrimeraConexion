package com.xgt.newandroidlistsapp

data class User(
    var id: String,
    val firstName: String,
    val lastName: String,
    val imageUrl: String? = null
){

fun checkValueUser(): Boolean = true
}
