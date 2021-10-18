package com.xgt.newandroidlistsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class AddUSerActivity : AppCompatActivity() {
    private lateinit var tietFirstName: TextInputEditText
    private lateinit var tietLastName: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val tietFirstName: TextInputEditText = findViewById(R.id.tiet_firstname)
        val tietLastName: TextInputEditText = findViewById(R.id.tiet_lastname)

        val btnAdd: Button = findViewById(R.id.btn_addUsers)
        val btnAdAndExit: Button = findViewById(R.id.btn_save_and_exit)

        btnAdd.setOnClickListener{
            if (addUser()){
                tietFirstName.text = null
                tietLastName.text = null
                tietFirstName.requestFocus()
            }


        }
        btnAdAndExit.setOnClickListener{
            if (addUser()){
                finish()
            }
        }
        btnAdAndExit.setOnClickListener { finish() }
    }

        private fun addUser(): Boolean{
            val firstName = tietFirstName.text.toString()
            val lastName = tietLastName.text.toString()

            if (firstName.length > 3 && lastName.length > 3) {
                val newUser = User(UUID.randomUUID().toString(), firstName, lastName)
                (application as App).users.add(newUser)
                return true
            } else {
                Toast.makeText(it.context, "Alguno de los campos no contiene el mínimo de caracteres requeridos (3", Toast.LENGTH_SHORT).show()
            }
        }
    }

