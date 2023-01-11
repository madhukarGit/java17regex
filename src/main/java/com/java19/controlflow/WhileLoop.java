package com.java19.controlflow;

import java.util.Random;

public class WhileLoop {
    public static void main(String[] args) {
        int randomNum = new Random().nextInt(3)+1;
        boolean flag = true;
        while (flag) {
            String guessNumText = System.console().readLine("Please give a number between 1 and 3 inclusively: ");
            int guessedNum = Integer.parseInt(guessNumText);

            if(guessedNum == randomNum){
                System.out.printf("%d\n",randomNum);
                flag = false;
            }else{
                System.out.printf("not get it %d\n",randomNum);
            }

        }
    }
}
