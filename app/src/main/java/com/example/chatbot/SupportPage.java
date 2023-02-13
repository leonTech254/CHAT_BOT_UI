package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SupportPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_page);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }

    public void toSupportstk(View view)
    {
        Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
        if (simToolKitLaunchIntent != null) {
            startActivity(simToolKitLaunchIntent);
        } else {

            // If the STK is not present on the device, show an error message
            Toast.makeText(getApplicationContext(), "STK not found on device.", Toast.LENGTH_SHORT).show();
        }

    }
}