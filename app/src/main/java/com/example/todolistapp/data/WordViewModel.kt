package com.example.todolistapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Word>>
    private val repository: WordRepository
    init {
        val wordDao = WordDatabase.getDatabase(application)!!.wordDao()
        repository = WordRepository(wordDao)
        readAllData = repository.readAllData
    }

    fun addWord(word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addWord(word)
        }
    }
}