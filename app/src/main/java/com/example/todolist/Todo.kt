package com.example.todolist

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todolist.Todo.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME
)
data class Todo(
    @PrimaryKey
    val id: String,
    val text: String

) {

    companion object {
        const val TABLE_NAME = "Todo"

        const val ID = "Id"
    }
}