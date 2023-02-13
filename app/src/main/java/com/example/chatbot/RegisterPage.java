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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.PublicKey;


public class RegisterPage extends AppCompatActivity {
    public String URL="https://api2.leonteqsecurity.com/api/register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }

    }
    public void  RegisterUser(String names,String email,String password)
    {
        RequestQueue queue= Volley.newRequestQueue(this);
        JSONObject requestBody =new JSONObject();
        try {
            requestBody.put("names",names);
            requestBody.put("email",email);
            requestBody.put("password",password);
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, URL, requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String leon=response.toString();
                try {
                    String serverResponse = response.getString("response");
                    if (serverResponse.equals("success"))
                    {
                        Toast.makeText(RegisterPage.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(RegisterPage.this,LoginPage.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(RegisterPage.this, serverResponse, Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(RegisterPage.this, "Request not succeded Try again later", Toast.LENGTH_SHORT).show();
                System.out.println(error);
            }
        });
        queue.add(jsonObjectRequest);
    }
    public  void  Register(View view) throws IOException {
//
        EditText firstname= (EditText) findViewById(R.id.firstname);
        EditText lastname= (EditText) findViewById(R.id.lastname);
        EditText email= (EditText) findViewById(R.id.email);
        EditText password= (EditText) findViewById(R.id.password);
        String names=firstname.getText().toString()+" "+ lastname.getText().toString();
        String emailString =email.getText().toString();
        String passwordString=password.getText().toString();
//        SendRegisterCredential("name","leon","password");
//        validation

        if(firstname.getText().toString().isEmpty() || lastname.getText().toString().isEmpty() || passwordString.isEmpty() || emailString.isEmpty())
        {
            Toast.makeText(this, "All field required", Toast.LENGTH_SHORT).show();
        }else
        {
            RegisterUser(names,emailString,passwordString);
        }
    }
    public void toLogin(View view)
    {
        Intent intent =new Intent(this,LoginPage.class);
        startActivity(intent);
    }
}