package com.example.new1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.room.Room


class MainActivity2 : AppCompatActivity() {

    private var wordDatabase:WordDatabase?=null
    lateinit var wordDao: WordDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        wordDatabase= Room.databaseBuilder( this,WordDatabase::class.java,"word_database")
            .allowMainThreadQueries().build()
        wordDao= wordDatabase?.getWordDao()!!

        val buttonInsert = findViewById<Button>(R.id.buttonInsert)
        buttonInsert.setOnClickListener {
            var word:word = word("Hello","你好")
            var word1:word = word("ByeBye","再见")
            wordDao.insertWords(word,word1)
            updateView();
        }

        val buttonDelete = findViewById<Button>(R.id.buttonDelete)
        buttonDelete.setOnClickListener {
            var word:word = word("Word","世界")
            word.setId(40)
            wordDao.deleteWords(word)
            updateView()
        }

        val buttonClear = findViewById<Button>(R.id.buttonClear)
        buttonClear.setOnClickListener{
            wordDao.deleteAllWords()
            updateView()
        }

        val buttonUpdate = findViewById<Button>(R.id.buttonUpdate)
        buttonUpdate.setOnClickListener {
            var word:word = word("Word","世界")
            word.setId(40)
            wordDao.updateWords(word)
            updateView()
        }

    }

    fun updateView(){
        var list:List<word> =wordDao.getAllWords();
        var text=""

        for (i in (0 until list.size)){
            var word:word =list.get(i)
            text+=""+word.getId()+":"+word.getWord()+"="+word.getChineseMeaning();
        }

        val textView2 = findViewById<TextView>(R.id.textView2)
        textView2.text=text


    }


    }
