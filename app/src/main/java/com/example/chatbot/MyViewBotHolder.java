package com.example.chatbot;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewBotHolder  extends RecyclerView.ViewHolder {
    ImageView imageview;
    TextView nameview;
    public MyViewBotHolder(@NonNull View itemView) {
        super(itemView);
        imageview =itemView.findViewById(R.id.BotImage);
        nameview= itemView.findViewById(R.id.botName);

    }
}
