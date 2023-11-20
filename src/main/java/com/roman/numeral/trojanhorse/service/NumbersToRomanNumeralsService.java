package com.roman.numeral.trojanhorse.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class NumbersToRomanNumeralsService {

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
    /**
     * Used to remove rest of the numbers.
     */
    private static final int THOUSAND_DEVIDER = 1000;
    /**
     * Used to remove rest of the numbers.
     */
    private static final int HUNDRED_DEVIDER = 100;
    /**
     * Used to remove rest of the numbers.
     */
    private static final int TEN_DEVIDER = 10;

    /**
     * @param number to be converted to Roman Numerals.
     * @return Roman Numerals.
     */
    public String covert(final int number) {

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

        return romanThousands[number % THOUSAND_REMAINDER / THOUSAND_DEVIDER]
                + romanHundreds[number % HUNDRED_REMAINDER / HUNDRED_DEVIDER]
                + romanTens[number % TEN_REMAINDER / TEN_DEVIDER]
                + romanUnits[number % UNIT_REMAINDER];
    }

}
