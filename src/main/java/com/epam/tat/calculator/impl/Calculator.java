package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Calculator implements ICalculator {
    private int precision;
    public Calculator(int precision) {
        this.precision = precision;
    }
    @Override
    public double add(double a, double b) {
        return BigDecimal.valueOf(a + b)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();
    }
    @Override
    public double subtract(double a, double b) {
        return BigDecimal.valueOf(a-b)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();

    }
    @Override
    public double multiply(double a, double b) {
      return BigDecimal.valueOf(a*b)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();
           }
    @Override
    public double divide(double a, double b) {
        if (a > 0 && b == 0) {
            return Double.POSITIVE_INFINITY;
        } else if (a < 0 && b == 0) {
            return Double.NEGATIVE_INFINITY;
        } else if (a == 0 && b == 0) {
            return Double.NaN;
        }
        return BigDecimal.valueOf(a/b)
                .setScale(precision, RoundingMode.HALF_UP)
                .doubleValue();
            }
}
