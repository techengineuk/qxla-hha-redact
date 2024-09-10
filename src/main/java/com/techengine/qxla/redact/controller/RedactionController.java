package com.techengine.qxla.redact.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class RedactionController {


    @GetMapping("/")
    public @ResponseBody String getServiceName(){
        log.info("Call to root uri...");
        return "Redaction Service";
    }

    @PostMapping("/redact")
    public @ResponseBody String redact(@RequestBody String textForRedaction){
        log.info("Call to /redact uri with text: " + textForRedaction);
        return "Not yet Implemented";
    }
}
