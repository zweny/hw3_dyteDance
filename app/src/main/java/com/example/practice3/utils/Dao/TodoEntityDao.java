package com.example.practice3.utils.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.practice3.utils.beans.TodoEntity;

import java.util.List;

@Dao
public interface TodoEntityDao {

    @Query("SELECT * FROM TodoTable")
    List<TodoEntity> getTodoList();

    @Query("SELECT * FROM TodoTable WHERE content = :text")
    TodoEntity selectTodo(String text);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addTodo(TodoEntity todoEntity);

    @Delete()
    void deleteTodo(TodoEntity todoEntity);
}
