package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }
    public  void  toChat(View view)
    {
        Intent intent =new Intent(this,ConverstationScreen.class);
        startActivity(intent);

    }

    public  void toShareApp(View view)
    {
        Intent shareapp =new Intent(Intent.ACTION_SEND);
        shareapp.putExtra(Intent.EXTRA_TEXT,"check out this amazing application: ChatBot");
        shareapp.setType("text/plain");
        startActivity(Intent.createChooser(shareapp, "Share with"));

    }

    public  void toProfile(View view)
    {
        Intent intent=new Intent(this,UserProfile.class);
        startActivity(intent);

    }
    public  void toSupport(View view)
    {
        Intent intent=new Intent(this,SupportPage.class);
        startActivity(intent);

    }
}