package com.example.todolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistapp.data.Word
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var wordList = emptyList<Word>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.custom_row, parent, false
        ))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = wordList[position]
        holder.itemView.apply {
            tvTodoTitle.text = currentItem.todo_task
            cbDone.isChecked = currentItem.isChecked
        }
    }

    override fun getItemCount(): Int {
        return wordList.size
    }
    fun setData(word: List<Word>) {
        this.wordList = word
        notifyDataSetChanged()
    }
}