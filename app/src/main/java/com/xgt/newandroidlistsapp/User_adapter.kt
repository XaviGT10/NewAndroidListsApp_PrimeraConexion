package com.xgt.newandroidlistsapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class User_adapter(
    private val users: MutableList<User>,
    val onclickListener: (User) -> Unit
) :
    RecyclerView.Adapter<User_adapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvFirstName: TextView = view.findViewById(R.id.tv_username)
        val tvLastName: TextView = view.findViewById(R.id.tv_lastName)
        val avatarImage: ImageView = view.findViewById(R.id.iv_Avatar)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = users[position]

        holder.tvFirstName.text = user.firstName
        holder.tvLastName.text = user.lastName

        Glide.with(holder.avatarImage.context)
            .load("https://goo.gl/gEgYUd")
            .placeholder(R.drawable.avatar)
            .into(holder.avatarImage)

//        val onClickListener: View.OnClickListener = object  : View.OnClickListener {
//            override fun onClick(v: View?) {
//                onclickListener(username)
//            }
//        }

//        holder.itemView.setOnClickListener(onClickListener)

        holder.itemView.setOnClickListener {
            onclickListener(user)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addUser(user: User){
        users.add(user)
        notifyItemInserted(users.size)
    }

    fun Usedeleter(user: User){
        users.remove(user)
        notifyDataSetChanged()
    }

}

interface UserOnclickListener {
    fun onClick (user: String)
}