package com.java19.controlflow;

import java.util.Random;

public class GuessIt {
    public static void main(String[] args) {
        //int num = new Random().nextInt(5) + 1;
        int num = 0;
        System.out.printf("Generated number is: %d\n",num);

        switch (num){
            case 1:
                System.out.println("color is green");
                break;
            case 2:
                System.out.println("color is red");
                break;
            case 3:
                System.out.println("color is purple");
                break;
            case 4:
                System.out.println("color is orange");
                break;
            default:
                System.out.println("colorless odorless");
        }
    }
}
