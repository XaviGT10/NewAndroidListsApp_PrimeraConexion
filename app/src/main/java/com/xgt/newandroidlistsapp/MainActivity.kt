package com.xgt.newandroidlistsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvUser: RecyclerView = findViewById(R.id.rv_users)
        val btnAddUser: Button = findViewById(R.id.btn_addUser)
        val userOnclickListener = object : UserOnclickListener{
            override fun onClick(user: String) {
                Log.d("MainActivity", "User clicked from main activity: $user")
            }
        }

        val app = (application as App)
        val users = app.users


        val adapter = User_adapter(users) {user ->
            Log.d("MainActivity", "User clicked from main activity: $user")
        }
        rvUser.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvUser.layoutManager = layoutManager


        btnAddUser.setOnClickListener {
            val intent = Intent(this, AddUSerActivity::class.java)
            startActivity(intent)
        }
    }

//    private fun retriveUsers(): MutableList<User> {
//        return List(5) { index -> User(
//            UUID.randomUUID().toString(),
//            "firstName $index",
//            "lastName $index",
//            "Image $index"
//        )}.toMutableList()
//    }
}