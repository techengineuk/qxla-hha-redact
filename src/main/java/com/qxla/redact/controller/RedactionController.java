package com.qxla.redact.controller;

import com.qxla.redact.service.RedactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class RedactionController {

    @Autowired
    private RedactionService redactionService;

    @GetMapping("/redact")
    public @ResponseBody String getServiceName(){

        log.info("Get request to /redact...");

        return "Redaction Service";
    }

    @PostMapping("/redact")
    public @ResponseBody String redact(@RequestBody String textForRedaction){

        log.info("Post request to /redact with text: " + textForRedaction);

        return redactionService.redact(textForRedaction);
    }
}
