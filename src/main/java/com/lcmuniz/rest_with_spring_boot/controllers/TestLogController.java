package com.lcmuniz.rest_with_spring_boot.controllers;

import com.lcmuniz.rest_with_spring_boot.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestLogController {

    private final Logger logger = LoggerFactory.getLogger(TestLogController.class.getName());

    @GetMapping("/test")
    public String testLog() {
        logger.trace("Trace message");
        logger.debug("Debug message");
        logger.info("Information message");
        logger.warn("Warning message");
        logger.error("Error message");
        return "Testando log";
    }

}
