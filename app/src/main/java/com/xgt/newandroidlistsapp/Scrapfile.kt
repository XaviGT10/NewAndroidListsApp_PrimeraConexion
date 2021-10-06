package com.xgt.newandroidlistsapp

class Square constructor(private val side: Int, var area: Int, blue: Boolean = area > 5) {



    data class User(
        val id: Int,
        val name: String,
        val password: String? = "foco",
        val imageUrl: String? = null
    )

    object FFF {
        fun scarp() {
            val sq = Square(1, 2, true)
            User(id = 1, name = "name", null, "imageUrl")
        }
    }
}