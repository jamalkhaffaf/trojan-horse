package com.roman.numeral.trojanhorse.service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RomanNumeralsToNumbersService {

    /**
     * Validate correct Roman Numeral symbols.
     */
    private static final Pattern PATTERN = Pattern.compile("[MDCLXVI]+");

    /**
     * @param romanNumeral to be converted into numbers.
     * @return expected numbers to be returned.
     */
    public int convert(final String romanNumeral) {

        if (romanNumeral == null || romanNumeral.isEmpty()) {
            throw new IllegalArgumentException(
                    "Invalid argument been used, Null or Empty are not valid!");
        }

        String upperCase = romanNumeral.toUpperCase(Locale.ROOT);
        if (!PATTERN.matcher(upperCase).matches()) {
            throw new IllegalArgumentException(
                    "Invalid argument been detected, "
                            + "please use values within expected range "
                            + "[M, D, C, L, X, V, I].");
        }

        return transformRomanNumeralsToNumbers(upperCase);
    }

    private static int transformRomanNumeralsToNumbers(final String upperCase) {
        Map<Character, Integer> romanToNumberMap = new HashMap<>();
        romanToNumberMap.put('I', 1);
        romanToNumberMap.put('V', 5);
        romanToNumberMap.put('X', 10);
        romanToNumberMap.put('L', 50);
        romanToNumberMap.put('C', 100);
        romanToNumberMap.put('D', 500);
        romanToNumberMap.put('M', 1000);

        int result = 0;
        for (int i = 0; i < upperCase.length(); i++) {
            if (i > 0 && romanToNumberMap.get(upperCase.charAt(i))
                    > romanToNumberMap.get(upperCase.charAt(i - 1))) {
                result += romanToNumberMap.get(upperCase.charAt(i)) - 2
                        * romanToNumberMap.get(upperCase.charAt(i - 1));
            } else {
                result += romanToNumberMap.get(upperCase.charAt(i));
            }
        }
        return result;
    }
}
