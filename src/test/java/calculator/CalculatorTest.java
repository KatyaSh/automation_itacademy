package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void initCalculatorObject() {
        calculator = new Calculator();
    }

    @Test
    public void testSum() {
        assertEquals(5.0, calculator.sum(1.0, 4.0));
    }

    @Test
    public void testDif() {
        assertEquals(4.0, calculator.dif(6, 2.0));
    }

    @Test
    public void testMultiplication() {
        assertEquals(12.0, calculator.multiplication(6, 2.0));
    }

    @Test
    public void testExpectedException() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.division(5.0, 0);
        });
        Assertions.assertEquals("division by zero is not allowed", thrown.getMessage());
    }

    @Test
    public void testDivision() {
        assertEquals(2.41, calculator.division(6, 2.4884454));
    }

}