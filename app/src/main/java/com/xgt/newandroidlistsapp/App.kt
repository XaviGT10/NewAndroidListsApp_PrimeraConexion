package com.xgt.newandroidlistsapp

import android.app.Application

class App : Application() {
    val users: MutableList<User> = mutableListOf()
}