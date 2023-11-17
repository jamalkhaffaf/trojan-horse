package com.roman.numeral.trojanhorse.service;

import org.springframework.stereotype.Service;

@Service
public class NumbersToRomanNumeralsService {

    /**
     * Minimum accepted Roman Numeral number to be converted.
     */
    private static final int MINIMUM_ACCEPTED_ROMAN_NUMERAL = 1;
    /**
     * Maximum accepted Roman Numeral number to be converted.
     */
    private static final int MAXIMUM_ACCEPTED_ROMAN_NUMERAL = 3000;
    /**
     * Used to extract the thousand position.
     */
    private static final int THOUSAND_REMAINDER = 10000;
    /**
     * Used to extract the hundred position.
     */
    private static final int HUNDRED_REMAINDER = 1000;
    /**
     * Used to extract the ten position.
     */
    private static final int TEN_REMAINDER = 100;
    /**
     * Used to extract the unit position.
     */
    private static final int UNIT_REMAINDER = 10;

    public String covert(int number) {

        if (number < MINIMUM_ACCEPTED_ROMAN_NUMERAL
                || number > MAXIMUM_ACCEPTED_ROMAN_NUMERAL) {
            throw new IllegalArgumentException("Only Numbers Greater Than"
                    + " 0 And Less Than 3001 Are Accepted!");
        }

        String[] romanUnits =
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] romanTens =
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanHundreds =
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] romanThousands =
                {"", "M", "MM", "MMM"};

        return romanThousands[number % THOUSAND_REMAINDER / 1000]
                + romanHundreds[number % HUNDRED_REMAINDER / 100]
                + romanTens[number % TEN_REMAINDER / 10]
                + romanUnits[number % UNIT_REMAINDER];
    }

}
