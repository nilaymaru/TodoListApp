
package com.example.todolistapp

import android.content.ContentProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolistapp.data.Word
import com.example.todolistapp.data.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mWordViewModel: WordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ListAdapter()
        val recyclerView = rv
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)



        btn_add.setOnClickListener {
            insertDataToDatabase()
        }

    }

    private fun insertDataToDatabase() {
        val todo_task = tvTodoItems.text.toString()
        val isChecked = false
        if (inputCheck(todo_task)) {
            val word = Word(0, todo_task, false)
            mWordViewModel.addWord(word)
            Toast.makeText(this, "Task created", Toast.LENGTH_SHORT).show()

        } else{
            Toast.makeText(this,"Please enter text", Toast.LENGTH_SHORT).show()}
    }
    private fun inputCheck(todo_task: String): Boolean {
        return !(TextUtils.isEmpty(todo_task))
    }
}