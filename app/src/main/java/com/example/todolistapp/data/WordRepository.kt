package com.example.todolistapp.data

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: WordDao) {

    val readAllData: LiveData<List<Word>> = wordDao.readAllData()

    suspend fun addWord(word: Word){
        wordDao.addWord(word)
    }
}