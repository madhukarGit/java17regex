package com.java19.numbers;

import java.util.Scanner;

public class NumberStuff {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int num1  = 7;
        storePetData(Integer.valueOf(num1));

    }


    public static void storePetData(Object obj){

        System.out.println(obj);
    }
}
