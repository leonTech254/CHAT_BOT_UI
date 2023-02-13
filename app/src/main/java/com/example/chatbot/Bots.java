package com.example.chatbot;

public class Bots {
    String bots;

    public Bots(String bots, String image) {
        this.bots = bots;
        Image = image;
    }

    String Image;

    public String getBots() {
        return bots;
    }

    public void setBots(String bots) {
        this.bots = bots;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
