package com.java19.regex;

public class RegexExtraCahracters {
    public static void main(String[] args) {
        System.out.println("dog".matches("\\w{3}"));
        System.out.println("cat".matches(".*"));
        System.out.println("animal".matches("^......$"));
    }
}
