package com.example.pamlatihan8

import android.app.Application
import androidx.room.Room

class MyApp : Application() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this, AppDatabase::class.java, "my_database")
            .build()

        // Isi data dummy ke dalam database
        Thread {
            val userDao = database.userDao()
            userDao.insertUser(User(
                username = "John Doe", email = "john@example.com"))
            userDao.insertUser(User(
                username = "Jane Smith", email = "jane@example.com"))
            userDao.insertUser(User(
                username = "Mike Johnson", email = "mike@example.com"))
            userDao.insertUser(User(
                username = "Jossy Saragih", email = "jossyraya.saragih@example.com"))
            userDao.insertUser(User(
                username = "Budi Santoso", email = "budi.santoso@example.com"))
            userDao.insertUser(User(
                username = "Siti Rahayu", email = "siti.rahayu@example.com"))
            userDao.insertUser(User(
                username = "Dewi Susanti", email = "dewi.susanti@example.com"))
        }.start()
    }
}