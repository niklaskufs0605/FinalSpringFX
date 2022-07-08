package com.example.finalspringfx.Helper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {
    @Test
    void formatDateTest() {

        Assertions.assertThat(DateFormatter.formatDate(Instant.EPOCH)).isEqualTo("1970-01-01 01:00:00");
    }
}