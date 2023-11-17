package com.roman.numeral.trojanhorse.service;

import org.springframework.stereotype.Service;

@Service
public class NumbersToRomanNumeralsService {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 3000;
    private static final int THOUSAND_REMAINDER = 10000;
    private static final int HUNDRED_REMAINDER = 1000;
    private static final int TEN_REMAINDER = 100;

    public String covert(int number) {

        if (number < MINIMUM || number > MAXIMUM) {
            throw new IllegalArgumentException("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!");
        }

        String[] romanUnits = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] romanTens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] romanThousands = {"", "M", "MM", "MMM"};

        return romanThousands[number % THOUSAND_REMAINDER / 1000]
                + romanHundreds[number % HUNDRED_REMAINDER / 100]
                + romanTens[number % TEN_REMAINDER / 10]
                + romanUnits[number % 10];
    }

}
