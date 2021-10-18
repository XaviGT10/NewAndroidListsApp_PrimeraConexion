package com.xgt.newandroidlistsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AddUSerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val firstNameNU: EditText = findViewById(R.id.et_Nombre2)
        val nomUsr: EditText = findViewById(R.id.et_Usr)
        val btnAdd: Button = findViewById(R.id.btn_addUsers)

        btnAdd.setOnClickListener{
            finish()
        }
    }
}