package com.java19.challenge;

import java.util.regex.Pattern;

public class CountWords {
    public static void main(String[] args) {
        /*
        * count words in text, words can contain - and _ but not digits.
        * */

        var text = "    hey hi 123 hello help   cou-ntry loki_hulk";
        var regex = "[\\s+]?[A-Za-z-_]+[\\s+]?\\b";
        var results = Pattern.compile(regex).matcher(text).results().count();
        System.out.println(results);
    }
}
