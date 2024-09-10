package com.techengine.qxla.redact.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RedactControllerTest {

    private RedactController redactController;
    private String originalText;
    private String expectedRedactedText;

    @BeforeEach
    void setUp() {
        redactController = new RedactController();
        originalText = """
                A dog, a monkey or a dolphin are all mammals.\s
                A snake, however, is not a mammal, it is a reptile.\s
                Who can say what a DogSnake is?""";
        expectedRedactedText = """
                A REDACTED, a monkey or a REDACTED are all mammals.\s
                A REDACTED, however, is not a REDACTED, it is a reptile.\s
                Who can say what a DogSnake is?""";
    }

    @Test
    public void testGet() {
        fail("Not yet implemented");
    }

    @Test
    public void testRedact() {
        String redactedText = "";
        assertEquals(expectedRedactedText, redactedText);
    }


}
