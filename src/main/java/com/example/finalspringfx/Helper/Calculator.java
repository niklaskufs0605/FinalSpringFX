package com.example.finalspringfx.Helper;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    //Get Values form application.properties
    private static double basicCharge = 3;

    private static double costsPerMinute = 0.1;

    //Calculates the price per Trip
    public static double calculator(int minutes, int seconds) {
        double minuteCosts = minutes * costsPerMinute;
        double secondCosts = (seconds * costsPerMinute) / 60;
        double sum = basicCharge + minuteCosts + secondCosts;
        //Round to two decimals
        BigDecimal bd = new BigDecimal(sum).setScale(2, RoundingMode.HALF_UP);
        //Returns price
        return bd.doubleValue();

    }
}
