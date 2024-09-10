package com.qxla.redact.service;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedactionService {

    private static final List<String> configList
            = List.of("Dog", "Cat", "Snake", "Dolphin", "Mammal");

    public static String redact(String inputText) {

        String redactedText = "";

        for(String text : configList){
            String redactionText = text.toLowerCase();
            redactedText = inputText.replace(redactionText, "REDACTED");
        }

        return redactedText;
    }
}
