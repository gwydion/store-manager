package com.chatbot.storemanager.exceptions;

public abstract class EntityNotFoundException extends Throwable {

    private final String message;

    protected EntityNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
