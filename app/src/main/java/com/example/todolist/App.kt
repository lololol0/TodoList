package com.example.todolist

import android.app.Application
import com.example.todolist.data.AppDatabase
import com.example.todolist.data.TodoRepository
import com.example.todolist.data.TodoRepositoryImpl

class App : Application() {

    private lateinit var database: AppDatabase

    lateinit var repository: TodoRepository

    override fun onCreate() {
        super.onCreate()

        database =
            AppDatabase.buildDatabase(
                applicationContext,
                DATABASE_NAME
            )

        repository =
            TodoRepositoryImpl(database.todoDao())
    }


    companion object {
        private const val DATABASE_NAME = "my_app.db"
    }
}