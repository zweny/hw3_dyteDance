package com.example.practice3.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.practice3.R;
import com.example.practice3.ui.adapter.ListAdapter;
import com.example.practice3.utils.Dao.TodoEntityDao;
import com.example.practice3.utils.DatabaseUtils.TodoDatabase;
import com.example.practice3.utils.beans.TodoEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ListAdapter mListAdapter;
    private ImageButton addButton;
    private TodoDatabase todoDatabase;
    private TodoEntityDao todoEntityDao;

    public void initDatabase(){
        todoDatabase = Room.databaseBuilder(this, TodoDatabase.class, "todoDatabase").allowMainThreadQueries().build();
        todoEntityDao = todoDatabase.getTodoEntityDao();
        mListAdapter = new ListAdapter(todoDatabase);
    }

    public void initView(){
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mListAdapter);
        mListAdapter.notifyItems();
    }

    public void addListener(){
        addButton = findViewById(R.id.main_add_button);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, NewToDoActivity.class);
                intent.putExtra("todoContent", new String());
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        todoEntityDao.addTodo(new TodoEntity(data.getStringExtra("todoContent")));
        mListAdapter.notifyItems();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initDatabase();
        initView();
        addListener();
    }
}