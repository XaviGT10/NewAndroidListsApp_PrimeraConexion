package com.xgt.newandroidlistsapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class User_adapter(
    private val users: MutableList<String>,
    val onclickListener: (String) -> Unit
) :
    RecyclerView.Adapter<User_adapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val username = users[position]

        holder.tvUsername.text = username

//        val onClickListener: View.OnClickListener = object  : View.OnClickListener {
//            override fun onClick(v: View?) {
//                onclickListener(username)
//            }
//        }

//        holder.itemView.setOnClickListener(onClickListener)

        holder.itemView.setOnClickListener {
            onclickListener(username)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addUser(user: String){
        users.add(user)
        notifyItemInserted(users.size)
    }

    fun Usedeleter(user: String){
        users.remove(user)
        notifyDataSetChanged()
    }

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvUsername: TextView = view.findViewById(R.id.tv_username)
    }
}

interface UserOnclickListener {
    fun onClick (user: String)
}