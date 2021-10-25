package com.xgt.newandroidlistsapp

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("result")
    val users: List <UserResponse>
)

data class UserResponse (
    val email: String,
    val name: FullNameResponse,
    val picture: PictureResponse
)

data class FullNameResponse(
    val title: String,
    val first: String,
    val last: String
)

data class PictureResponse(
    val large: String,
    val medium: String,
    val thumbail: String
)