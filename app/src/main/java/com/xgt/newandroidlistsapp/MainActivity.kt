package com.xgt.newandroidlistsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvUser: RecyclerView = findViewById(R.id.rv_users)
        val userOnclickListener = object : UserOnclickListener{
            override fun onClick(user: String) {
                Log.d("MainActivity", "User clicked from main activity: $user")
            }
        }
        val adapter = User_adapter(retriveUsers()) {user ->
            Log.d("MainActivity", "User clicked from main activity: $user")
        }
        rvUser.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvUser.layoutManager = layoutManager

    }

    private fun retriveUsers(): MutableList<String> {
        return List(5) { index -> "Users from MAinActivity $index" }.toMutableList()
    }
}