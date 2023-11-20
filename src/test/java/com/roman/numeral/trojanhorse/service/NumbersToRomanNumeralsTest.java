package com.roman.numeral.trojanhorse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumbersToRomanNumeralsTest {

    @Autowired
    private NumbersToRomanNumeralsService suit;

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenSendingLessThanOneTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.covert(0));
        assertEquals("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!", ex.getMessage());
    }

    @Test
    public void shouldReturnIllegalArgumentExceptionWhenSendingMoreThanThreeThousandTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.covert(3001));
        assertEquals("Only Numbers Greater Than 0 And Less Than 3001 Are Accepted!", ex.getMessage());
    }

    @Test
    public void shouldReturnIWhenSendingOneTest() {
        assertEquals("I", suit.covert(1));
    }

    @Test
    public void shouldReturnIXWhenSendingNineTest() {
        assertEquals("IX", suit.covert(9));
    }

    @Test
    public void shouldReturnXWhenSendingTenTest() {
        assertEquals("X", suit.covert(10));
    }

    @Test
    public void shouldReturnXCWhenSendingNinetyTest() {
        assertEquals("XC", suit.covert(90));
    }

    @Test
    public void shouldReturnLVWhenSendingFiftyFiveTest() {
        assertEquals("LV", suit.covert(55));
    }

    @Test

    public void shouldReturnCWhenSendingHundredTest() {
        assertEquals("C", suit.covert(100));
    }

    @Test
    public void shouldReturnCMWhenSendingNineHundredTest() {
        assertEquals("CM", suit.covert(900));
    }

    @Test
    public void shouldReturnDLVWhenSendingFiveHundredTest() {
        assertEquals("DLV", suit.covert(555));
    }

    @Test
    public void shouldReturnDVWhenSendingFiveHundredAndFiveTest() {
        assertEquals("DV", suit.covert(505));
    }

    @Test
    public void shouldReturnMWhenSendingOneThousandTest() {
        assertEquals("M", suit.covert(1000));
    }

    @Test
    public void shouldReturnMMMWhenSendingThreeThousandTest() {
        assertEquals("MMM", suit.covert(3000));
    }

    @Test
    public void shouldReturnMMDLVWhenSendingTwoThousandFiveHundredFiftyFiveTest() {
        assertEquals("MMDLV", suit.covert(2555));
    }

    @Test
    public void shouldReturnMMDWhenSendingTwoThousandFiveHundredTest() {
        assertEquals("MMD", suit.covert(2500));
    }
}
