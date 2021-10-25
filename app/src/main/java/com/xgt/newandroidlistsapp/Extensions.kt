package com.xgt.newandroidlistsapp

import android.widget.ImageView
import androidx.constraintlayout.helper.widget.MotionPlaceholder
import com.bumptech.glide.Glide
import java.net.URL

fun ImageView.imageFromUrl(imageURL: String, placeholder: Int = R.drawable.avatar) {
    Glide.with(this)
        .load(imageURL)
        .placeholder(R.drawable.avatar)
        .into(this)

}