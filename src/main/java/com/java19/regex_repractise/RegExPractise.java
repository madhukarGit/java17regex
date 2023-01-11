package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RegExPractise {
    public static void main(String[] args) {
        // System.out.println("Cat".matches("[A-Z]\\w+"));
        // System.out.println("321-333-7652".matches("\\d{3}[-./]\\d{3}[-./]\\d+"));
        //System.out.println("321333. 7652".matches("\\d+[-./\\s]*\\d+[-./\\s]+\\d+"));
        //System.out.println("321 333 7652".matches("(\\d+[-.\\s]*)+\\d+"));
        //System.out.println("1.321 333 7652".matches("(\\d+[-.\\s]*)+\\d+"));
        String regex = "(1[-,.\\s]?)?(\\d+[-./\\s]*)(\\d+[-./\\s]*)(\\d+)";
        Pattern pat=Pattern.compile(regex);
        String phoneNum = "1.321 333 7652";
        Matcher matcher = pat.matcher(phoneNum);
        System.out.println(matcher.matches());
        if(matcher.matches()){
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }
    }
}
