package com.example.todolist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todolist.Todo

@Dao
interface TodoDao {

    @Insert
    suspend fun insert(todo: Todo)

    @Query("SELECT * FROM ${Todo.TABLE_NAME}")
    suspend fun getAllTodo(): List<Todo>

    @Query("DELETE FROM ${Todo.TABLE_NAME} WHERE ${Todo.ID} = :id")
    suspend fun deleteById(id: String)

    @Query("DELETE FROM ${Todo.TABLE_NAME}")
    suspend fun deleteAll()

}