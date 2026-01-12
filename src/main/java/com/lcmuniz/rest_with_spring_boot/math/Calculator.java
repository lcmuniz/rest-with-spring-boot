package com.lcmuniz.rest_with_spring_boot.math;

import com.lcmuniz.rest_with_spring_boot.utils.NumberUtils;

public class Calculator {

    public Double sum(Double a, Double b) {
        return a + b;
    }

    public Double subtract(Double a, Double b) {
        return a - b;
    }

    public Double multiply(Double a, Double b) {
        return a * b;
    }

    public Double divide(Double a, Double b) {
        if (b == 0) throw new UnsupportedOperationException("The value can not be zero!");
        return a / b;
    }

    public Double avg(Double a, Double b) {
        return (a + b) / 2;
    }

    public Double sqrt(Double a) {
        if (NumberUtils.isNegative(a)) throw new UnsupportedOperationException("The value can not be negative!");
        return Math.sqrt(a);
    }

}
