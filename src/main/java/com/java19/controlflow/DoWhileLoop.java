package com.java19.controlflow;

import java.util.Random;

public class DoWhileLoop {
    public static void main(String[] args) {
        int randomNum = new Random().nextInt(4)+1;
        boolean flag = true;
        String guessedTextNum = null;
        int wrongGuessesCount = 0;
        do{
            guessedTextNum = System.console().readLine("Please guess a number between 1 and 4 : ");
            if(guessedTextNum.matches("\\d{1,2}")){
                int guessedNum = Integer.parseInt(guessedTextNum);
                if(guessedNum == randomNum){
                    System.out.printf("The random number was %d, got it %n",randomNum);
                    flag = false;
                }else{
                    wrongGuessesCount +=1;

                    System.out.printf("You didn't get it \n");
                }
                System.out.printf("Total Number of Wrong guesses are %d\n",wrongGuessesCount);
            }else {
                System.out.println("the input number to be of 2 digits ");
            }
        }while (flag);
    }
}
