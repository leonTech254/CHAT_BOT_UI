package com.example.chatbot;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatBotMessageAdaptor extends RecyclerView.Adapter<ChatBotMessageAdaptor.MessagesHolder> {
    public ChatBotMessageAdaptor(List<MessageList> messageLists, Context context) {
        this.messageLists = messageLists;
        this.context = context;
    }

   private List<MessageList> messageLists;
private Context context;
    @NonNull
    @Override
    public MessagesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.messages_chatbot_converstation,parent,false);
        return new MessagesHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesHolder holder, int position) {
            MessageList messageList=messageLists.get(position);

//processing the messages
        String[] raw_message=messageList.getMessage().split("\\|");
        String processedMessage=raw_message[0];
        String Sender=raw_message[1];
        if(Sender.equals("me"))
        {
            holder.message.setText(processedMessage);
            holder.alignItems.setGravity(Gravity.RIGHT);
            holder.message.setBackgroundResource(R.drawable.message_me);

        }else
        {
            holder.message.setText(processedMessage);
            holder.alignItems.setGravity(Gravity.LEFT);
            holder.message.setBackgroundResource(R.drawable.message_friend);
        }

//            holder.message.setBackground();
    }

    @Override
    public int getItemCount() {
        return messageLists.size();
    }

    public class MessagesHolder extends RecyclerView.ViewHolder
{
    public TextView message;
    public LinearLayout alignItems;


    public MessagesHolder(@NonNull View itemView) {
        super(itemView);
        message =(TextView) itemView.findViewById(R.id.message);
        alignItems = (LinearLayout) itemView.findViewById(R.id.alignItems);
    }
}

}
