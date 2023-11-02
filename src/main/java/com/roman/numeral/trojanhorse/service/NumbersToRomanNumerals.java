package com.roman.numeral.trojanhorse.service;

public class NumbersToRomanNumerals {

    public String covert(int number) {

        if (number < 1 || number > 3000) {
            throw new IllegalArgumentException("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!");
        }

        String[] romanUnits = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        String result = romanUnits[number];

        return result;
    }
    
}
