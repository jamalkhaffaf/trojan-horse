package com.roman.numeral.trojanhorse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralsToNumbersTest {

    @Autowired
    private RomanNumeralsToNumbersService suit;

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
    public void sendOutOfRangeValuesExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert("MDZZ"));
        assertEquals("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].", ex.getMessage());
    }

    @Test
    public void sendOutOfRangeSmallLetterValuesExpectIllegalArgumentExceptionTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert("zzvi"));
        assertEquals("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].", ex.getMessage());
    }

    @Test
    public void sendValidValueIExpectConvertedToOneTest() {
        assertEquals(1, suit.convert("I"));
    }

    @Test
    public void sendValidValueIXExpectConvertedToNineTest() {
        assertEquals(9, suit.convert("IX"));
    }

    @Test
    public void sendValidValueXExpectConvertedToTenTest() {
        assertEquals(10, suit.convert("X"));
    }

    @Test
    public void sendValidValueXCExpectConvertedToNinetyTest() {
        assertEquals(90, suit.convert("XC"));
    }

    @Test
    public void sendValidValueLVExpectConvertedToFiftyFiveTest() {
        assertEquals(55, suit.convert("LV"));
    }

    @Test
    public void sendValidValueCExpectConvertedToHundredTest() {
        assertEquals(100, suit.convert("C"));
    }

    @Test
    public void sendValidValueCMExpectConvertedToNineHundredTest() {
        assertEquals(900, suit.convert("CM"));
    }

    @Test
    public void sendValidValueDLVExpectConvertedToFiveHundredAndFiftyFiveTest() {
        assertEquals(555, suit.convert("DLV"));
    }

    @Test
    public void sendValidValueDVExpectConvertedToFiveHundredAndFiveTest() {
        assertEquals(505, suit.convert("DV"));
    }

    @Test
    public void sendValidValueMExpectConvertedToThousandTest() {
        assertEquals(1000, suit.convert("M"));
    }

    @Test
    public void sendValidValueMMMExpectConvertedToThreeThousandTest() {
        assertEquals(3000, suit.convert("MMM"));
    }

    @Test
    public void sendValidValueMMDLVExpectConvertedToTwoThousandFiveHundredFiftyFiveTest() {
        assertEquals(2555, suit.convert("MMDLV"));
    }

    @Test
    public void sendValidValueMMDExpectConvertedToTwoThousandFiveHundredTest() {
        assertEquals(2500, suit.convert("MMD"));
    }
}
