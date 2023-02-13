package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Introduction3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction3);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }
    public void  toIntro4(View view)
    {
        Intent intent =new Intent(this,Introduction5.class);
        startActivity(intent);

    }
}