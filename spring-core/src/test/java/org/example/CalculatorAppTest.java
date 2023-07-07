package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class CalculatorAppTest {

    @Test
    @DisplayName("1 + 1 = 2")
    public void addsTwoNumbers() {
        CalculatorApp calculator = new CalculatorApp();
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "-1,    -2,   -3",
            "-1,    2,   -3",
            "49,  51, 100",
            "1,  100, 101"
    })
    public void add(int first, int second, int expectedResult) {
        CalculatorApp calculator = new CalculatorApp();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    public void testApp() {
        assert (true);
    }
}
