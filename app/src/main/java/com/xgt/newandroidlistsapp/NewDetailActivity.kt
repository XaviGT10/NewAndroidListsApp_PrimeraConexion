package com.xgt.newandroidlistsapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NewDetailActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val userId: String? = intent.extras?.getString("userId")
        if (userId == null){
            //Show user that some error has taken place
            finish()
        }

        var user: User? = null
        (application as App).users.forEach { forUser ->
            if (forUser.id == userId){
                user = forUser
                return
            }

        }

        if (user == null){
            //Show user that some error has taken place
            finish()
        }

        val tvFirstName: TextView = findViewById(R.id.tv_nombreUser)
        val tvLastName: TextView = findViewById(R.id.tv_lastNameUsr)

        tvFirstName.text = user?.firstName
        tvLastName.text = user?.lastName
    }
}