package com.example.todolist.data

import com.example.todolist.Todo
import com.example.todolist.TodoId


class TodoRepositoryImpl(private val todoDao: TodoDao) : TodoRepository {
    override suspend fun insert(todo: Todo) {
        todoDao.insert(todo)
    }

    override suspend fun getAllTodo() = todoDao.getAllTodo()

    override suspend fun deleteById(id: TodoId) {
        todoDao.deleteById(id)
    }

    override suspend fun deleteAll() {
        todoDao.deleteAll()
    }

}