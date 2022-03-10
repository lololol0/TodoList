package com.example.todolist

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class MainActivity : AppCompatActivity(), TodoAdapter.OnItemClickListener {

    private val bigRandom: Int
        get() = Random().nextInt(10000)

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Первый запуск!", Toast.LENGTH_LONG).show()



        initRecyclerView()

        val editText = findViewById<EditText>(R.id.editText)
        val text = editText.text

        addPersonButton.setOnClickListener {
            val todo = Todo(
                id = bigRandom.toString(),
                text = text.toString()
            )
            todoAdapter.addTodo(todo)

            insertTodo(todo)

        }

        deleteAllButton.setOnClickListener {
            deleteTodoAll()

        }

        retrieveTodos()
    }

    override fun onItemClicked(id: TodoId) {
        deleteTodoById(id)
    }

    private fun initRecyclerView() {
        todoAdapter = TodoAdapter(this)

        with(todoList) {
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = todoAdapter
            this.setHasFixedSize(true)
        }
    }

    private fun insertTodo(todo: Todo) {
        lifecycleScope.launch(Dispatchers.IO) {
            (applicationContext as App).repository.insert(todo = todo)
        }
    }

    private fun retrieveTodos() {
        lifecycleScope.launch(Dispatchers.IO) {
            val todos = (applicationContext as App).repository.getAllTodo()

            withContext(Dispatchers.Main) {
                todoAdapter.setTodos(todos)
            }
        }
    }

    private fun deleteTodoById(id: TodoId) {
        lifecycleScope.launch(Dispatchers.IO) {
            (applicationContext as App).repository.deleteById(id)
            withContext(Dispatchers.Main) {
                todoAdapter.removeTodo(id)
            }
        }
    }

    private fun deleteTodoAll() {
        lifecycleScope.launch(Dispatchers.IO) {
            (applicationContext as App).repository.deleteAll()

            withContext(Dispatchers.Main) {
                todoAdapter.removeAllTodo()
            }
        }
    }

}
