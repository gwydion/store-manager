package com.chatbot.storemanager.web;

public class DocumentWebResponse{

    private final String type;
    private final String number;

    public DocumentWebResponse(String type, String number){
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
