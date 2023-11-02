package com.roman.numeral.trojanhorse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralsToNumbersTest {

    @Autowired
    RomanNumeralsToNumbersService suit;

    @Test
    public void sendNullObjectExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert(null));
        assertEquals("Invalid argument been used, Null or Empty are not valid!", ex.getMessage());
    }

    @Test
    public void sendEmptyObjectExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert(""));
        assertEquals("Invalid argument been used, Null or Empty are not valid!", ex.getMessage());
    }

    @Test
    public void sendRomanNumeralsContainsOutOfRangeValuesExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert("MDZZ"));
        assertEquals("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].", ex.getMessage());
    }

    @Test
    public void sendRomanNumeralsInLowerCaseContainsOutOfRangeValuesExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert("zzvi"));
        assertEquals("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].", ex.getMessage());
    }

    @Test
    public void sendValidRomanNumeralUnitsValueOfIExpectConvertedToOneTest() {
        assertEquals(1, suit.convert("I"));
    }

    @Test
    public void sendValidRomanNumeralUnitsValueOfIXExpectConvertedToNineTest() {
        assertEquals(9, suit.convert("IX"));
    }

    @Test
    public void sendValidRomanNumeralTensValueOfXExpectConvertedToTenTest() {
        assertEquals(10, suit.convert("X"));
    }

    @Test
    public void sendValidRomanNumeralTensValueOfXCExpectConvertedToNinetyTest() {
        assertEquals(90, suit.convert("XC"));
    }

    @Test
    public void sendValidRomanNumeralTensValueOfLVExpectConvertedToFiftyFiveTest() {
        assertEquals(55, suit.convert("LV"));
    }

    @Test
    public void sendValidRomanNumeralHundredsValueOfCExpectConvertedToHundredTest() {
        assertEquals(100, suit.convert("C"));
    }

    @Test
    public void sendValidRomanNumeralHundredsValueOfCMExpectConvertedToNineHundredTest() {
        assertEquals(900, suit.convert("CM"));
    }

    @Test
    public void sendValidRomanNumeralHundredsValueOfDLVExpectConvertedToFiveHundredAndFiftyFiveTest() {
        assertEquals(555, suit.convert("DLV"));
    }

    @Test
    public void sendValidRomanNumeralHundredsValueOfDVExpectConvertedToFiveHundredAndFiveTest() {
        assertEquals(505, suit.convert("DV"));
    }

    @Test
    public void sendValidRomanNumeralThousandsValueOfMExpectConvertedToThousandTest() {
        assertEquals(1000, suit.convert("M"));
    }

    @Test
    public void sendValidRomanNumeralThousandsValueOfMMMExpectConvertedToThreeThousandTest() {
        assertEquals(3000, suit.convert("MMM"));
    }

    @Test
    public void sendValidRomanNumeralThousandsValueOfMMDLVExpectConvertedToTwoThousandFiveHundredFiftyFiveTest() {
        assertEquals(2555, suit.convert("MMDLV"));
    }

    @Test
    public void sendValidRomanNumeralThousandsValueOfMMDExpectConvertedToTwoThousandFiveHundredTest() {
        assertEquals(2500, suit.convert("MMD"));
    }
}
