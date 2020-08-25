package com.chatbot.storemanager.exceptions;

public class ProcedureExecutionException extends Throwable {

    private final String message;

    public ProcedureExecutionException(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
