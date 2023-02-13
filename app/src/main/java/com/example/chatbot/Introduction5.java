package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Introduction5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction5);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }

    public  void toMainScreen(View view)
    {
        Intent intent =new Intent(this,MainNavigation.class);
        startActivity(intent);
    }

}