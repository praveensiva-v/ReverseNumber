package com.reverse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testReverseNumber() {
        assertEquals(54321, App.reverseNumber(12345));
    }

    @Test
    public void testReverseWithZero() {
        assertEquals(321, App.reverseNumber(1230));
    }

    @Test
    public void testSingleDigit() {
        assertEquals(7, App.reverseNumber(7));
    }
}