package com.xgt.newandroidlistsapp

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class NewDetailActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val userId: String? = intent.extras?.getString("userId")
        if (userId == null){
            //Show user that some error has taken place
            finish()
        }

//        var user: User? = null
//        (application as App).users.forEach { forUser ->
//            if (forUser.id == userId){
//                user = forUser
//                return@forEach
//            }

//        }

        val user = (application as App).users.firstOrNull { forUser -> forUser.id == userId }

        if (user == null){
            //Show user that some error has taken place
            Log.d("NewDetailUser", "user == null")
            finish()
        }

        val tvFirstName: TextView = findViewById(R.id.tv_nombreUser)
        val tvLastName: TextView = findViewById(R.id.tv_lastNameUsr)
        val ivAvatar: ImageView = findViewById(R.id.iv_Avatar)

        tvFirstName.text = user?.firstName
        tvLastName.text = user?.lastName
        Glide.with(this).load(user?.imageUrl).into(ivAvatar)
    }
}