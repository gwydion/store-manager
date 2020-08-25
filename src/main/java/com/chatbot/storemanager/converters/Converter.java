package com.chatbot.storemanager.converters;

public interface Converter<T, K> {
    K convert(T var1);
}

