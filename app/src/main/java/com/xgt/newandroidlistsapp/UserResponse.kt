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
){

}

data class FullNameResponse(
    @SerializedName("title") val title: String,
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
)

data class PictureResponse(
    @SerializedName("large") val large: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("thumbail") val thumbail: String
)