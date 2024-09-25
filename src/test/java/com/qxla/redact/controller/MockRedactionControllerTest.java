package com.qxla.redact.controller;

import com.qxla.redact.service.RedactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MockRedactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RedactionService redactionService;

    @Autowired
    private RedactionController redactionController;

    @Test
    void testGet() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/redact"))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(status().isOk())
                .andExpect(content().string("Redaction Service"));
    }

    @Test
    void testController() throws Exception {

        String inputText = "A dog, a monkey or a dolphin";
        String redactedText = "A REDACTED, a monkey or a REDACTED";
        when(redactionService.redact(inputText))
                .thenReturn(redactedText);

        mockMvc.perform(MockMvcRequestBuilders.post("/redact")
                .contentType("application/json")
                .content(inputText))
                .andExpect(status().isOk())
                .andExpect(content().string(redactedText));
    }
}
