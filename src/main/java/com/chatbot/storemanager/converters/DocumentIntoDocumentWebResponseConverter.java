package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.Document;
import com.chatbot.storemanager.web.DocumentWebResponse;
import org.springframework.stereotype.Component;

@Component
public class DocumentIntoDocumentWebResponseConverter implements Converter<Document, DocumentWebResponse> {

    @Override
    public DocumentWebResponse convert(Document document) {
        return document == null ? null : new DocumentWebResponse(document.getType(), document.getNumber());
    }
}
