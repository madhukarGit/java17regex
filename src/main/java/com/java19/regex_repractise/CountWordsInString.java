package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountWordsInString {
    public static void main(String[] args) {
        String text  = "hey.k  hwlllo  hii dude";
        //var regex = "([\\s+]?(?<word>\\w+)[.-/?!]?[\\s+]*)*";
        var regex = "\\s+";
        String[] arr = text.split(regex);
        System.out.println(arr.length);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
