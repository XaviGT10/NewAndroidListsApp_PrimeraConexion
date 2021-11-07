package com.xgt.newandroidlistsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amarinag.demon02_recyclerview.FakeData
import com.google.gson.Gson
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: User_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvUser: RecyclerView = findViewById(R.id.rv_users)
        val btnAddUser: Button = findViewById(R.id.btn_addUser)

        val app = (application as App)
        val users = app.users

        val gson: Gson =  Gson()
        val results = gson.fromJson(FakeData.usersJson, ResultResponse::class.java)

        users.addAll(results.users.toUser())
        results.users.forEach { userResponse ->
            users.add(userResponse.toUser())
        }

        adapter = User_adapter(users) {user ->
            val intent = Intent(this, NewDetailActivity::class.java)
            intent.putExtra("userId", user.id)
            startActivity(intent)
            Log.d("MainActivity", "User clicked from main activity: $user")
        }
        rvUser.adapter = adapter
        val layoutManager = GridLayoutManager(this,2)
        rvUser.layoutManager = layoutManager


        btnAddUser.setOnClickListener {
            val intent = Intent(this, AddUSerActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}