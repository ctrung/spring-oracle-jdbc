package com.example.spring_oracle_jdbc.domain;

public record LoggingEvent (Long eventId, String loggerName, String formattedMessage) {
}
