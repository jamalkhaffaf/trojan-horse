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
        assertEquals("Only Numbers Greater Than 0 And Less Than 3000 Are Accepted!", ex.getMessage());
    }

    @Test
    public void moreThanThreeThousandTest() {
        IllegalArgumentException ex = assertThrowsExactly(IllegalArgumentException.class, () -> suit.covert(3001));
        assertEquals("Only Numbers Greater Than 0 And Less Than 3000 Are Accepted!", ex.getMessage());
    }
}
