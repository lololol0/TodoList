package com.example.todolist.data

import com.example.todolist.Todo
import com.example.todolist.TodoId


interface TodoRepository {

    suspend fun insert(todo: Todo)

    suspend fun getAllTodo(): List<Todo>

    suspend fun deleteById(id: TodoId)

    suspend fun deleteAll()
}