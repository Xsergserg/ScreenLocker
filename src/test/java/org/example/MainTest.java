package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void equalityTest() {
        assertEquals(0, Screenlocker.calculateCombinations('A', 10, 3));
        assertEquals(0, Screenlocker.calculateCombinations('A', 0, 3));
        assertEquals(0, Screenlocker.calculateCombinations('E', 14, 3));
        assertEquals(1, Screenlocker.calculateCombinations('B', 1, 3));
        assertEquals(5, Screenlocker.calculateCombinations('C', 2, 3));
        assertEquals(8, Screenlocker.calculateCombinations('E', 2, 3));
        assertEquals(256, Screenlocker.calculateCombinations('E', 4, 3));
    }
}
