package com.roman.numeral.trojanhorse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumbersToRomanNumeralsTest {

    NumbersToRomanNumerals suit = new NumbersToRomanNumerals();

    @Test
    public void lessThanOneTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.covert(0));
        assertEquals("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!", ex.getMessage());
    }

    @Test
    public void moreThanThreeThousandTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.covert(3001));
        assertEquals("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!", ex.getMessage());
    }

    @Test
    public void unitNumbersSendNumberOneExpectCorrectRomanNumeralITest() {
        assertEquals("I", suit.covert(1));
    }

    @Test
    public void unitNumbersSendNumberNineExpectCorrectRomanNumeralIXTest() {
        assertEquals("IX", suit.covert(9));
    }

    @Test
    public void tenNumbersSendNumberTenExpectCorrectRomanNumeralXTest() {
        assertEquals("X", suit.covert(10));
    }

    @Test
    public void tenNumbersSendNumberNinetyExpectCorrectRomanNumeralXCTest() {
        assertEquals("XC", suit.covert(90));
    }

    @Test
    public void tenNumbersSendNumberFiftyFiveExpectCorrectRomanNumeralLVTest() {
        assertEquals("LV", suit.covert(55));
    }

    @Test
    public void hundredNumersSendNumberHundredExpectCorrectRomanNumeralCTest() {
        assertEquals("C", suit.covert(100));
    }

    @Test
    public void hundredNumersSendNumberNineHundredExpectCorrectRomanNumeralCMTest() {
        assertEquals("CM", suit.covert(900));
    }

    @Test
    public void hundredNumersSendNumberFiveHundredAndFiftyFiveExpectCorrectRomanNumeralDLVTest() {
        assertEquals("DLV", suit.covert(555));
    }

    @Test
    public void hundredNumersSendNumberFiveHundredAndFiveExpectCorrectRomanNumeralDVTest() {
        assertEquals("DV", suit.covert(505));
    }
}
