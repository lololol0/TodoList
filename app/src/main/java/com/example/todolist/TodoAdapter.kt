package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<TodoViewHolder>() {

    private val todoList = mutableListOf<Todo>()

    fun addTodo(todo: Todo) {
        todoList.add(todo)
        notifyDataSetChanged()
    }

    fun setTodos(todos: List<Todo>){
        todoList.clear()
        todoList.addAll(todos)
        notifyDataSetChanged()
    }

    fun removeTodo(id: String) {
        val todoToRemove = todoList.find { it.id == id }
        todoToRemove?.let {
            todoList.remove(it)
            notifyDataSetChanged()
        }
    }

    fun removeAllTodo(){
        todoList.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(itemView, itemClickListener)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount() = todoList.size

    interface OnItemClickListener {
        fun onItemClicked(id: String)
    }

}