package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }

    public void toBack(View view)
    {
        finish();

    }
    public void toExit(View view)
    {
        finishAffinity();
    }
}