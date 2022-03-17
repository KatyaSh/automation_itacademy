package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

    private final static int PRECISION = 2;

    public double sum(double a, double b) {
        double sum = a + b;
        return round(sum);
    }

    public double dif(double a, double b) {
        double dif = a - b;
        return round(dif);
    }

    public double multiplication(double a, double b) {
        double multiple = a * b;
        return round(multiple);
    }

    public double division(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException ("division by zero is not allowed");
        }
        double division = a / b;
        return round(division);
    }

    private double round(double value) {
        BigDecimal roundValue = new BigDecimal(Double.toString(value));
        roundValue = roundValue.setScale(PRECISION, RoundingMode.HALF_EVEN);
        return roundValue.doubleValue();
    }
}
