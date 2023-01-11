package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExGroupingNotToRemember {
    public static void main(String[] args) {
        String phoneNumber = "12.232.333.2365";
        String regex = "(?:(\\d{1,2})[-./\\s]?)?(?:(\\d{3})[-./\\s]?)(?:(\\d{3})[-./\\s]?)(\\d{4})";
        Pattern pat = Pattern.compile(regex);
        Matcher matcher =pat.matcher(phoneNumber);
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
    }
}
