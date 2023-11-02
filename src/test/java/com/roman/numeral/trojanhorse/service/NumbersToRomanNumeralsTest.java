package com.roman.numeral.trojanhorse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumbersToRomanNumeralsTest {

    @Autowired
    NumbersToRomanNumeralsService suit;

    @Test
    public void sendNumerValueLessThanOneExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.covert(0));
        assertEquals("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!", ex.getMessage());
    }

    @Test
    public void sendNumberValueMoreThanThreeThousandExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.covert(3001));
        assertEquals("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!", ex.getMessage());
    }

    @Test
    public void sendUnitNumberValueOfOneExpectCorrectRomanNumeralValueOfITest() {
        assertEquals("I", suit.covert(1));
    }

    @Test
    public void sendUnitNumberValueOfNineExpectCorrectRomanNumeralValueOfIXTest() {
        assertEquals("IX", suit.covert(9));
    }

    @Test
    public void sendTenNumberValueOfTenExpectCorrectRomanNumeralValueOfXTest() {
        assertEquals("X", suit.covert(10));
    }

    @Test
    public void sendTenNumberValueOfNinetyExpectCorrectRomanNumeralValueOfXCTest() {
        assertEquals("XC", suit.covert(90));
    }

    @Test
    public void sendTenNumberValueOfFiftyFiveExpectCorrectRomanNumeralValueOfLVTest() {
        assertEquals("LV", suit.covert(55));
    }

    @Test
    public void sendHundredNumerValueOfHundredExpectCorrectRomanNumeralValueOfCTest() {
        assertEquals("C", suit.covert(100));
    }

    @Test
    public void sendHundredNumerValueOfNineHundredExpectCorrectRomanNumeralValueOfCMTest() {
        assertEquals("CM", suit.covert(900));
    }

    @Test
    public void sendHundredNumerValueOfFiveHundredAndFiftyFiveExpectCorrectRomanNumeralValueOfDLVTest() {
        assertEquals("DLV", suit.covert(555));
    }

    @Test
    public void sendHundredNumerValueOfFiveHundredAndFiveExpectCorrectRomanNumeralValueOfDVTest() {
        assertEquals("DV", suit.covert(505));
    }

    @Test
    public void sendThousandNumberValueOfOneThousandExpectCorrectRomanNumeralValueOfMTest() {
        assertEquals("M", suit.covert(1000));
    }

    @Test
    public void sendThousandNumberValueOfThreeThousandExpectCorrectRomanNumeralValueOfMMMTest() {
        assertEquals("MMM", suit.covert(3000));
    }

    @Test
    public void sendThousandNumberValueOfTwoThousandFiveHundredFiftyFiveExpectCorrectRomanNumeralValueOfMMDLVTest() {
        assertEquals("MMDLV", suit.covert(2555));
    }

    @Test
    public void sendThousandNumberValueOfTwoThousandFiveHundredExpectCorrectRomanNumeralValueOfMMDTest() {
        assertEquals("MMD", suit.covert(2500));
    }
}
