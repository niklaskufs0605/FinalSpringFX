package com.example.finalspringfx.Helper.Validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCalculatorInputTest {


    ValidateCalculatorInput validateCalculatorInput = new ValidateCalculatorInput();

    @Test
    void isCalculatorInputValidTest() {
        Assertions.assertThat(validateCalculatorInput.isCalculatorInputValid("10", "10")).isTrue();

    }
    @Test
    void isCalculatorInputNotValidTest() {
        Assertions.assertThat(validateCalculatorInput.isCalculatorInputValid("not", "valid")).isFalse();
    }

}