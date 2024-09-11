package com.qxla.redact.controller;

import com.qxla.redact.service.RedactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RedactionController {

    @Autowired
    private RedactionService redactionService;

    @GetMapping("/redact")
    public @ResponseBody String getServiceName(){

        log.info("Call to root uri...");

        return "Redaction Service";
    }

    @PostMapping("/redact")
    public @ResponseBody String redact(@RequestBody String textForRedaction){

        log.info("Call to /redact uri with text: " + textForRedaction);

        return redactionService.redact(textForRedaction);
    }
}
