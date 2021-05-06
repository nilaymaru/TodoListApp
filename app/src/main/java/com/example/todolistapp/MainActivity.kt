
package com.example.todolistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.data.Word
import com.example.todolistapp.data.WordViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mWordViewModel: WordViewModel
    private lateinit var todoAdapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mWordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)



        btn_add.setOnClickListener {
            insertDataToDatabase()
        }

    }

    private fun insertDataToDatabase() {
        val todo_task = rvTodoItems.text.toString()
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