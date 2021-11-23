package com.example.practice3.utils.DatabaseUtils;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.practice3.utils.Dao.TodoEntityDao;
import com.example.practice3.utils.beans.TodoEntity;

@Database(entities = {TodoEntity.class}, version = 1, exportSchema = false)
public abstract class TodoDatabase extends RoomDatabase {

    private static TodoDatabase sInstance;

    public static TodoDatabase getDatabase(Context context){
        if (sInstance == null){
            sInstance = Room.databaseBuilder(context.getApplicationContext(), TodoDatabase.class, "TodoDatabase.db").allowMainThreadQueries().build();
        }
        return sInstance;
    }

    public static void onDestory(){
        sInstance = null;
    }

    public abstract TodoEntityDao getTodoEntityDao();
}
