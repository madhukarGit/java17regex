package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExCaptureGroups {
    public static void main(String[] args) {
        String phoneNumber = "12.324 456 98901";
        String regex = "((\\d{1,2})[.-/\\s]?)?(\\d+[-.\\s]?)(\\d+[-.\\s]?)(\\d+)";
        Pattern pat = Pattern.compile(regex);
        Matcher matcher =pat.matcher(phoneNumber);
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
            System.out.println(matcher.group(5));
        }
    }
}
