package com.example.todolist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

class TodoViewHolder(
    itemView: View,
    private val itemClickListener: TodoAdapter.OnItemClickListener
) : RecyclerView.ViewHolder(itemView) {

    fun bind(todo: Todo) {
        with(itemView) {
            todo.run {
                nameTextView.text = text

                deleteItemImageView.setOnClickListener {
                    itemClickListener.onItemClicked(id = id)
                }
            }
        }
    }

}