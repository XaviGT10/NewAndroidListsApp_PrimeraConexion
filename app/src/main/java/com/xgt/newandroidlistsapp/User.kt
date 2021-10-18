package com.xgt.newandroidlistsapp

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val imageUrl: String? = null
){

fun checkValueUser(): Boolean = true
}
