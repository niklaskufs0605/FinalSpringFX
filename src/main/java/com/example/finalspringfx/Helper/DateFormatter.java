package com.example.finalspringfx.Helper;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String formatDate(Instant instant) {
        final String PATTERN_FORMAT = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());

        return formatter.format(instant);
    }

}
