package com.example.practice3.utils.beans;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TodoTable")
public class TodoEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String content;

    public void setContent(String content){
        this.content = content;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getContent() {
        return this.content;
    }

    public TodoEntity(String content){
        this.content =content;
    }
}
