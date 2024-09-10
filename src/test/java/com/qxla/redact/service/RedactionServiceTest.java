package com.qxla.redact.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RedactionServiceTest {

    private static final List<String> configList
            = List.of("Dog", "Cat", "Snake", "Dolphin", "Mammal");
    private String inputText = """
                A dog, a monkey or a dolphin are all mammals.\s
                A snake, however, is not a mammal, it is a reptile.\s
                Who can say what a DogSnake is?""";

    @Test
    void testRedact() {
        //expected
        String expected = """
                A REDACTED, a monkey or a REDACTED are all mammals.\s
                A REDACTED, however, is not a REDACTED, it is a reptile.\s
                Who can say what a DogSnake is?""";

        //action
        String actual = RedactionService.redact(inputText);

        //test
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
