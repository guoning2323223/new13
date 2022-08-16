package com.example.new1;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {word.class},version = 1,exportSchema = false)
public abstract class WordDatabase extends  RoomDatabase{
    public abstract WordDao getWordDao();
}
