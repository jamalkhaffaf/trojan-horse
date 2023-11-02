package com.roman.numeral.trojanhorse.service;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralsToNumbers {

    public int convert(String romanNumeral) {

        if (romanNumeral == null || romanNumeral.isEmpty()) {
            throw new IllegalArgumentException("Invalid argument been used, Null or Empty are not valid!");
        }

        romanNumeral = romanNumeral.toUpperCase();
        if (!romanNumeral.matches("[MDCLXVI]+")) {
            throw new IllegalArgumentException("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].");
        }
        
        Map<Character, Integer> romanToNumberMap = new HashMap<>();
        romanToNumberMap.put('I', 1);
        romanToNumberMap.put('V', 5);
        romanToNumberMap.put('X', 10);

        // ex. IX
        int result = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            if (i > 0 && romanToNumberMap.get(romanNumeral.charAt(i)) > romanToNumberMap.get(romanNumeral.charAt(i - 1))) {
                result += romanToNumberMap.get(romanNumeral.charAt(i)) - 2 * romanToNumberMap.get(romanNumeral.charAt(i - 1));
            } else {
                result += romanToNumberMap.get(romanNumeral.charAt(i));
            }
        }

        return result;
    }
}
