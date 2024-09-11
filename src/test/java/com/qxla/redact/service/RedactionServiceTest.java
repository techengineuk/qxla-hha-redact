package com.qxla.redact.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * {@code @author:} Jane Ajayi

 * Redaction Service Test

 * Unit Tests for Redaction Service
 */
@SpringBootTest
@TestPropertySource("classpath:test.properties")
class RedactionServiceTest {

    @Autowired
    private RedactionService redactionService;

    /**
     * Test Redaction Service
     */
    @Test
    void testRedact() {

        //input
        String inputText = """
                A dog, a monkey or a dolphin are all mammals.\s
                A snake, however, is not a mammal, it is a reptile.\s
                Who can say what a DogSnake is?""";

        //expected
        String expected = """
                A REDACTED, a monkey or a REDACTED are all mammals.\s
                A REDACTED, however, is not a REDACTED, it is a reptile.\s
                Who can say what a DogSnake is?""";

        //action
        String actual = redactionService.redact(inputText);

        //test
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}
