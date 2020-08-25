package com.chatbot.storemanager.converters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListConverter<T, M> implements Converter<List<T>, List<M>> {
    private final Converter<T, M> converter;

    public ListConverter(Converter<T, M> converter) {
        this.converter = converter;
    }

    public List<M> convert(List<T> object) {
        if (object == null) {
            return null;
        } else {
            List<M> converted = new ArrayList();
            Iterator<T> iterator = object.iterator();

            while (iterator.hasNext()) {
                M result = this.converter.convert(iterator.next());
                if (result != null) {
                    converted.add(result);
                }
            }
            return converted;
        }
    }
}
