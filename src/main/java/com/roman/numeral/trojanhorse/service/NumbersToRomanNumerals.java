package com.roman.numeral.trojanhorse.service;

public class NumbersToRomanNumerals {

    public String covert(int number) {

        if (number < 1 || number > 3000) {
            throw new IllegalArgumentException("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!");
        }

        String[] romanUnits = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] romanTens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanHundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] romanThousands = {"", "M", "MM", "MMM"};

        String result = romanThousands[(number % 10000) / 1000] + 
            romanHundreds[(number % 1000) / 100] + 
            romanTens[(number % 100) / 10] + 
            romanUnits[number % 10];

        return result;
    }
    
}
