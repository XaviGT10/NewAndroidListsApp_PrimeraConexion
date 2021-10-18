package com.xgt.newandroidlistsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AddUSerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val firstNameNU: TextView = findViewById(R.id.tv_firstName2)
        val nomUsr: TextView = findViewById(R.id.tv_Usr)
    }
}