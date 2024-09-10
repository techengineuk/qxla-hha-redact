package com.techengine.qxla.redact.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class RedactionControllerTest {

    private RedactionController redactController;
    private String originalText;
    private String expectedRedactedText;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    void setUp() {
        redactController = new RedactionController();
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

        //expected
        String expected = "Redaction Service";

        //action
        String actual = restTemplate.getForEntity("http://localhost:" + port + "/", String.class).getBody();

        //test
        assertEquals(expected, actual);
    }

    @Test
    public void testRedact() {
        log.debug("test redact");

        //action
        String redactedText = restTemplate.postForEntity("http://localhost:" + port + "/redact", originalText, String.class).getBody();

        //test
        assertEquals(expectedRedactedText, redactedText);
    }


}
