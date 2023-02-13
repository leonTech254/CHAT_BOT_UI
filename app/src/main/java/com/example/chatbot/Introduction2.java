package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Introduction2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction2);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }
    public void  toIntro3(View view)
    {
        Intent intent =new Intent(this,Introduction3.class);
        startActivity(intent);

    }
}