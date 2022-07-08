package com.example.finalspringfx.Helper.Validator;

public class ValidateCalculatorInput {

    public static boolean isCalculatorInputValid(String minutes, String seconds) {
        if(minutes.matches("^[0-9]*$") && seconds.matches("^[0-9]*$")) {
            return true;
        } else return false;
    }
}
