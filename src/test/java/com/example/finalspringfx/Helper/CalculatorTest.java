package com.example.finalspringfx.Helper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void calculatorTest() {
        Assertions.assertThat(calculator.calculator(10, 10)).isEqualTo(4.02);
    }
}