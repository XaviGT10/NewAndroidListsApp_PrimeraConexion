package com.xgt.newandroidlistsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class AddUSerActivity : AppCompatActivity() {
    private lateinit var tietFirstName: TextInputEditText
    private lateinit var tietLastName: TextInputEditText
    private lateinit var
    private lateinit var
    private lateinit var
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)

        val tietFirstName: TextInputEditText = findViewById(R.id.tiet_firstname)
        val tietLastName: TextInputEditText = findViewById(R.id.tiet_lastname)

        val btnAdd: Button = findViewById(R.id.btn_addUsers)
        val btnAdAndExit: Button = findViewById(R.id.btn_save_and_exit)
        val btnSalir: Button = findViewById(R.id.btn_salir)

        val rgImages: RadioGroup = findViewById(R.id.rg_Images)
        val rbImage1: RadioButton = findViewById(R.id.rb_image1)
        val rbImage2: RadioButton = findViewById(R.id.rb_image2)

        val ivImage1: ImageView = findViewById(R.id.iv_imagen1)
        val ivImage2: ImageView = findViewById(R.id.iv_imagen2)

        Glide.with(this)
            .load("upload.wikimedia.org/wikipedia/commons/3/30/Chuck_Norris_May_2015.jpg")
            .into(ivImage1)
        Glide.with(this)
            .load("i.imgur.com/DvpvklR.png")
            .into(ivImage2)



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
        btnSalir.setOnClickListener { finish() }
    }

        private fun addUser(): Boolean{
            val firstName = tietFirstName.text.toString()
            val lastName = tietLastName.text.toString()
            val imageURL: String? = null


            if (firstName.length > 3 && lastName.length > 3) {
                val newUser = User(UUID.randomUUID().toString(), firstName, lastName)
                (application as App).users.add(newUser)
                return true
            } else {
                Toast.makeText(this, "Alguno de los campos no contiene el mínimo de caracteres requeridos (3", Toast.LENGTH_SHORT).show()
            }
            return true
        }
    }

