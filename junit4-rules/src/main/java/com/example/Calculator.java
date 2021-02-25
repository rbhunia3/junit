package com.example;

public class Calculator {

    public double sqrt(double x) {
        if (x < 0) {
            throw new
                    IllegalArgumentException("Cannot extract the square root of a negative value");
        }
        return Math.sqrt(x);
    }

    public double divide(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return x / y;
    }
}
