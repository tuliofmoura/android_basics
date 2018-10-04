package br.com.tuliofmoura.androidbasics.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.tuliofmoura.androidbasics.R;

public class TodoStarterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_activity_starter);
    }
}
