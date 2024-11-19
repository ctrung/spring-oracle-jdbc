package com.example.spring_oracle_jdbc.controller;

import com.example.spring_oracle_jdbc.domain.LoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class LoggingEventController {

    private static final Logger log = LoggerFactory.getLogger(LoggingEventController.class);

    private final JdbcClient jdbcTemplate;

    public LoggingEventController(JdbcClient jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody LoggingEvent loggingEvent) {
        log.info("Creation : " + loggingEvent);

        // todo insertion en table
    }

}
