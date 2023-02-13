package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Introduction1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction1);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }


    public void  toIntro2(View view)
    {
        Intent intent =new Intent(this,Introduction2.class);
        startActivity(intent);

    }
}