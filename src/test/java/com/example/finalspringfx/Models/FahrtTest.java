package com.example.finalspringfx.Models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FahrtTest {

    @Test
    void ConstructorTests() {
        Fahrt fahrt1 = new Fahrt("10", "10", 10.10, "10.10.2022");
        Fahrt fahrt2 = new Fahrt("10", "10", new User(), 10.10, "10.10.2022");
        Fahrt fahrt3 = null;
        Fahrt fahrt4 = new Fahrt();

        Assertions.assertThat(fahrt1).isEqualTo(fahrt1);
        Assertions.assertThat(fahrt3).isNull();
        Assertions.assertThat(fahrt2).isEqualTo(fahrt2);
        Assertions.assertThat(fahrt4).isEqualTo(fahrt4);
    }
}