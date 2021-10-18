package com.xgt.newandroidlistsapp

data class User(
    val id: Int,
    val name: String,
    val password: String? = "foco",
    val imageUrl: String? = null
){

fun checkValueUser(): Boolean = true
}
