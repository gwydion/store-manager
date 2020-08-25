package com.chatbot.storemanager.model;

public class Document {

    private final String type;
    private final String number;

    public Document(String type, String number){
        this.type = type;
        this.number = number;
    }

    public String getType(){
        return type;
    }

    public String getNumber(){
        return number;
    }
}
