package com.roman.numeral.trojanhorse.service;

public class RomanNumeralsToNumbers {

    public int convert(String romanNumeral) {

        if (romanNumeral == null || romanNumeral.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument been used, Null or Empty are not valid!");
        }

        romanNumeral = romanNumeral.toUpperCase();
        if (!romanNumeral.matches("[MDCLXVI]+")) {
            throw new IllegalArgumentException("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].");
        }
        
        return -1;
    }
}
