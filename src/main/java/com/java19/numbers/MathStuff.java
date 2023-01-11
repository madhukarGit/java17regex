package com.java19.numbers;

import java.util.Random;

public class MathStuff {
    public static void main(String[] args) {
        /**
         *
         * area of circle
         */

        System.out.println(Math.floor(calculateAreaOfCircle(10)));
    }

    /**
     *
     * @param radius
     * @return
     */
    public static double calculateAreaOfCircle(int radius){
        return (Math.PI)*(radius * radius);
    }
}
