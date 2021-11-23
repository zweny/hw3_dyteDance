package com.example.practice3.ui.adapter;

import android.graphics.Paint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practice3.R;
import com.example.practice3.ui.view.TodoListItemHolder;
import com.example.practice3.utils.Dao.TodoEntityDao;
import com.example.practice3.utils.DatabaseUtils.TodoDatabase;
import com.example.practice3.utils.beans.TodoEntity;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<TodoListItemHolder> {
    @NonNull
    private List<TodoEntity> mItems = new ArrayList<TodoEntity>();
    private TodoDatabase mtodoDatabase;
    private TodoEntityDao mtodoEntityDao;

    public ListAdapter(@NonNull TodoDatabase todoDatabase){
        mtodoDatabase = todoDatabase;
        mtodoEntityDao = mtodoDatabase.getTodoEntityDao();
    }
    @NonNull
    @Override
    public TodoListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new TodoListItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_todo_list_item, parent, false));
    }

    public void onBindViewHolder(@NonNull TodoListItemHolder holder, int position){
        holder.bind((mItems.get(position)).getContent());
        holder.get_Button().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoEntity needToDelete = mtodoEntityDao.selectTodo(holder.get_CheckBox().getText().toString());
                mtodoEntityDao.deleteTodo(needToDelete);
                mItems.clear();
                mItems.addAll(mtodoEntityDao.getTodoList());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mItems.size();
    }

    public void notifyItems(){
        mItems.clear();
        mItems.addAll(mtodoEntityDao.getTodoList());
        notifyDataSetChanged();
    }

}
