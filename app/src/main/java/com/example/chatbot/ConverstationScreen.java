package com.example.chatbot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConverstationScreen extends AppCompatActivity {
    public String URL="https://api2.leonteqsecurity.com/api/message/response";

    private RecyclerView recyclerView;
    private  RecyclerView.Adapter adapter;
    private List<MessageList> messageLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converstation_screen);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageLists =new ArrayList<>();
        for(int i=0;i<=0;i++)
        {
            MessageList messageList =new MessageList("Hello|friend");
            messageLists.add(messageList);

        }
        adapter=new ChatBotMessageAdaptor(messageLists,this);
        recyclerView.setAdapter(adapter);



        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }



    }

    public  void send_message(String message)
    {
        RequestQueue queue = Volley.newRequestQueue(this);
        JSONObject requestBody=new JSONObject();
        try {
            requestBody.put("message",message);
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, URL, requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String leon=response.toString();
                try {
                    String message = response.getString("bot");
                    String newMessage=message+"|friend";
                    Thread.sleep(2000);
                    adapter.notifyDataSetChanged();
                    MessageList messageList =new MessageList(newMessage);
                    messageLists.add(messageList);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ConverstationScreen.this, "Request not succeded Try again later", Toast.LENGTH_SHORT).show();
                System.out.println(error);


            }
        });
        queue.add(jsonObjectRequest);
    }

    public  void SendMessage(View view)
    {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        TextView message=(TextView) findViewById(R.id.typedMessage);
        String messageString=message.getText().toString();
        String newMessage=messageString+"|me";
        send_message(messageString);
        MessageList messageList =new MessageList(newMessage);
        messageLists.add(messageList);
        message.setText("");


    }

}