package com.roman.numeral.trojanhorse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RomanNumeralsToNumbersTest {

    RomanNumeralsToNumbers suit = new RomanNumeralsToNumbers();

    @Test
    public void sendNullObjectExpectIllegalArgumentException() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert(null));
        assertEquals("Invalid argument been used, Null or Empty are not valid!", ex.getMessage());
    }

    @Test
    public void sendEmptyObjectExpectIllegalArgumentException() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert(""));
        assertEquals("Invalid argument been used, Null or Empty are not valid!", ex.getMessage());
    }

    @Test
    public void sendRomanNumeralsContainsOutOfRangeValuesExpectIllegalArgumentException() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert("MDZZ"));
        assertEquals("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].", ex.getMessage());
    }

    @Test
    public void sendRomanNumeralsInLowerCaseContainsOutOfRangeValuesExpectIllegalArgumentException() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.convert("zzvi"));
        assertEquals("Invalid argument been detected, please use values within expected range [M, D, C, L, X, V, I].", ex.getMessage());
    }

    @Test
    public void sendValidRomanNumeralUnitIExpectConvertedToOne() {
        assertEquals(1, suit.convert("I"));
    }

    @Test
    public void sendValidRomanNumeralUnitIXExpectConvertedToNine() {
        assertEquals(9, suit.convert("IX"));
    }
}
