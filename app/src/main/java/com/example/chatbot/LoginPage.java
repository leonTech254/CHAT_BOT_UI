package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginPage extends AppCompatActivity {
    public String URL="https://api2.leonteqsecurity.com/api/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
    }
    public  void CheckUser(String email,String password)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject requestBody=new JSONObject();
        try {
            requestBody.put("email",email);
            requestBody.put("password",password);

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try
                {
                    String serverResponse=response.getString("response");
                    System.out.println(serverResponse);
                    if (serverResponse.equals("success"))
                    {
                        Toast.makeText(LoginPage.this, serverResponse, Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(getApplicationContext(),Introduction1.class);
                        startActivity(intent);

                    }else
                    {
                        Toast.makeText(LoginPage.this, serverResponse, Toast.LENGTH_SHORT).show();

                    }

                }catch (JSONException e)
                {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LoginPage.this, "Failed:Check your internet connection", Toast.LENGTH_SHORT).show();

            }
        });

        queue.add(jsonObjectRequest);

    }

    public  void UserLogIn(View view)
    {

        EditText email= (EditText) findViewById(R.id.email_login);
        EditText password= (EditText) findViewById(R.id.password_login);
        String emailString =email.getText().toString();
        String passwordString=password.getText().toString();


        if(passwordString.isEmpty() || emailString.isEmpty())
        {
            Toast.makeText(this, "All field required", Toast.LENGTH_SHORT).show();
        }else
        {
            CheckUser(emailString,passwordString);
        }
    }
    public void toRegister(View view)
    {
        Intent intent = new Intent(this,RegisterPage.class);
        startActivity(intent);

    }
    public void toForgotPassword(View view)
    {
        Intent intent = new Intent(this,ForgotPassword.class);
        startActivity(intent);
    }
}