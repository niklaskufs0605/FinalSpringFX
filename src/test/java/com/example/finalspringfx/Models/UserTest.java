package com.example.finalspringfx.Models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void ConstructorTest() {
        User user = new User("TestFirstname", "TestLastname", "TestUsername", "TestPassword");
        Assertions.assertThat(user). isEqualTo(user);
    }
}
