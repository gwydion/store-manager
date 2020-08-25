package com.chatbot.storemanager.exceptions;

public class ProductNotFoundException extends EntityNotFoundException {

    private static final String TEMPLATE = "No product was found by %s";

    public ProductNotFoundException(final String id) {
        super(String.format(TEMPLATE, id));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
