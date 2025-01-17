package com.qxla.redact.service;

import com.qxla.redact.RedactionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@code @author:} Jane Ajayi
 * Redaction Service
 * Utility class to redact text from a list of words
 */
@Component
public class RedactionService {

    @Value("${redaction.words}")
    private  List<String> redactionWords;

    public String redact(String inputText) {

        if(inputText == null || inputText.isEmpty())
        {
            throw new RedactionException("Redaction Input must not be empty or null.");
        }
        String redactedText = inputText;

        for(String text : redactionWords){

            //configured redaction word
            String redactionText = text.toLowerCase();

            //match whole word pattern
            Pattern pattern = Pattern.compile("\\b" + redactionText + "\\b");
            Matcher matcher = pattern.matcher(inputText);

            //replace with 'REDACTED'
            redactedText = matcher.replaceAll("REDACTED");

            //update input text
            inputText = redactedText;
        }
        return redactedText;
    }
}
