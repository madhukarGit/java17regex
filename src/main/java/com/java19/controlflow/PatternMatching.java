package com.java19.controlflow;

public class PatternMatching {
    public static void main(String[] args) {
        String name = "Jr";
        int num  = 10;
        Object obj = num;
        switch (obj){
            case Integer number-> System.out.println(number);
            case default -> System.out.println("");
        }
    }
}
