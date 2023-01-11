package com.java19.numbers;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class BigDecimalNumbers {
    public static void main(String[] args) {
        MathContext mc = new MathContext(4, RoundingMode.HALF_UP);
        //System.out.println(new BigDecimal("0.9874567").divide(new BigDecimal("1.98754463"),mc));

        BigDecimal num1 = new BigDecimal("102");
        System.out.println(num1.byteValue());

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        //System.out.println(nf.format(new BigDecimal("14356.987")));

        System.out.printf("%f.2%n",27018.91);
    }
}
