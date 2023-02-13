package com.example.chatbot;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BotAdapter extends RecyclerView.Adapter<MyViewBotHolder> {

Context context;
List <ClipData.Item> items;
    @NonNull
    @Override
    public MyViewBotHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewBotHolder(LayoutInflater.from(context).inflate(R.layout.bots_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewBotHolder holder, int position) {
    holder.nameview.setText("CHAT BOT");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
