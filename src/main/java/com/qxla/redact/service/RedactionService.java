package com.qxla.redact.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RedactionService {

    @Value("${redaction.words}")
    private  List<String> redactionWords;

    public String redact(String inputText) {

        String redactedText = inputText;

        for(String text : redactionWords){
            String redactionText = text.toLowerCase();
            Pattern pattern = Pattern.compile("\\b" + redactionText + "\\b");
            Matcher matcher = pattern.matcher(inputText);
            redactedText = matcher.replaceAll("REDACTED");
            inputText = redactedText;
        }



        return redactedText;
    }
}