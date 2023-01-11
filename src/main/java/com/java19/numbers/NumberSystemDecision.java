package com.java19.numbers;

public class NumberSystemDecision {
    public static void main(String[] args) {
        char value = 32767;
        System.out.println(((Object)value).getClass().getSimpleName());

        /*
        * Hexadecimal representation
        * */

        int hexVal = 0x91;
        byte binaryVal = 0b10;
        int binaryValInt = 0b101010101;

        int sum = 1 | 2 | 4 ;
        System.out.println(sum);
    }
}
