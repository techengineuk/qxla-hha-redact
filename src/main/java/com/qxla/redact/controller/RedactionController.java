package com.qxla.redact.controller;

import com.qxla.redact.RedactionException;
import com.qxla.redact.service.RedactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jane Ajayi on 10.09.2024.
 * Redaction Controller
 */
@Controller
@Slf4j
public class RedactionController {

    @Autowired
    private RedactionService redactionService;

    /**
     * @return Service Name
     */
    @GetMapping("/redact")
    public @ResponseBody String getServiceName(){

        log.info("Get request to /redact...");

        return "Redaction Service";
    }

    /**
     * @param textForRedaction  Text to be redacted
     * @return Redacted Text
     */
    @PostMapping("/redact")
    public @ResponseBody String redact(@RequestBody String textForRedaction){

        log.info("Post request to /redact with text: " + textForRedaction);

        return redactionService.redact(textForRedaction);
    }
}
