package com.example.todolist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todolist.Todo

@Database(
    entities = [Todo::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object {
        fun buildDatabase(context: Context, dbName: String): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, dbName).build()
        }
    }
}