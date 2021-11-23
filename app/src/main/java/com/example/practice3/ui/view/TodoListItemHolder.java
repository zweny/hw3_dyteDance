package com.example.practice3.ui.view;

import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.practice3.R;
import com.example.practice3.utils.Dao.TodoEntityDao;
import com.example.practice3.utils.DatabaseUtils.TodoDatabase;
import com.example.practice3.utils.beans.TodoEntity;

public class TodoListItemHolder extends RecyclerView.ViewHolder{

    private CheckBox mCheckBox;
    private AppCompatImageButton mButton;

    public TodoListItemHolder(@NonNull View itemView){
        super(itemView);
        mCheckBox = itemView.findViewById(R.id.list_item_checkBox);
        mButton = itemView.findViewById(R.id.list_item_Button);
        mCheckBox.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i("CheckBox","CheckBox Click detected");
                if (mCheckBox.isChecked())
                    mCheckBox.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                else
                    mCheckBox.setPaintFlags(mCheckBox.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });
    }

    public AppCompatImageButton get_Button(){
        return mButton;
    }

    public CheckBox get_CheckBox(){
        return mCheckBox;
    }

    public void bind(String text){
        mCheckBox.setText(text);
    }
}
