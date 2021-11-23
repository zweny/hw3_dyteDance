package com.example.practice3.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.practice3.R;

public class NewToDoActivity extends AppCompatActivity {

    private EditText meditText;
    private Button submit_button;

    public void initView(){
        setContentView(R.layout.activity_newtodo);
    }

    public void addlistener(){
        meditText = findViewById(R.id.newTodoEditText);
        submit_button = findViewById(R.id.submit_button);
        submit_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = getIntent();
                intent.putExtra("todoContent", meditText.getText().toString());
                setResult(1,intent);
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initView();
        addlistener();
    }
}
