package com.java19.numbers;

import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimal {
    public static void main(String[] args) {
        MathContext mc = new MathContext(4, RoundingMode.HALF_UP);
        System.out.println(new BigDecimal());
    }
}
