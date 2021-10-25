package com.xgt.newandroidlistsapp

data class User(
    var id: String,
    val firstName: String,
    val lastName: String,
    val imageUrl: String? = null
)
    fun UserResponse.toUser(): User {
        return User(
            this.email,
            this.name.first,
            this.name.last,
            this.picture.medium

        )
    }
fun List<UserResponse>.toUser():List<User> {
    return this.map { it.toUser() }
}
