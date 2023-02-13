package com.example.chatbot;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
public class ForgotPassword extends AppCompatActivity {
    public String URL="https://api2.leonteqsecurity.com/api/password/recover";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }
    public  void SendPassword(String email)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject requestBody=new JSONObject();
        try {
            requestBody.put("email",email);
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
                        Toast.makeText(ForgotPassword.this, "we sent password to email: "+email, Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this);
                        builder.setTitle("PASSWORD SENT");
                        builder.setMessage("We sent password to email "+email);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent =new Intent(getApplicationContext(),LoginPage.class);
                                startActivity(intent);
                            }
                        });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }else
                    {
                        Toast.makeText(ForgotPassword.this, serverResponse, Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ForgotPassword.this, "Failed:Check your internet connection", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
    public void toSendPassword(View view)
    {
        EditText email =(EditText) findViewById(R.id.email_forgot);
        String emailString=email.getText().toString();
        SendPassword(emailString);
    }
    public void toLogin(View view)
    {
        Intent intent =new Intent(this,LoginPage.class);
        startActivity(intent);
    }
}