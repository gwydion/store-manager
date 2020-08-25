package com.chatbot.storemanager.exceptions;

public class ClientNotFoundException extends EntityNotFoundException {

    private static final String TEMPLATE = "Client %s from company %s was not found";

    public ClientNotFoundException(final String clientId, final String companyId) {
        super(String.format(TEMPLATE, clientId, companyId));
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
