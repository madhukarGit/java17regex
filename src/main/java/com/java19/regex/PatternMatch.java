package com.java19.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {
    public static void main(String[] args) {
        //String regex = "(\\d{1,4}[.]?){1,}";
        String splitCamelCase = "aidNightBlue";
        //String resultCamel = splitCamelCase.replaceAll("([A-Z]{1,}?){1,}"," $1");
        //splitCamelCase.replaceAll("[A-Z]"," ");
        //System.out.println("splitCamelCase "+resultCamel);


        String result = splitCamelCase.replaceFirst(splitCamelCase,"[A-Z]*");

        String regex = "((\\d{1,2})[-.,\\s]?)?((\\d{3})[-,.\\s]?)((\\d{3})[-,.\\s]?)(\\d{4})";
        Pattern pat = Pattern.compile(regex);
        String phoneNo = "12.232.333.2365";
        //System.out.println(phoneNo.matches(regex));
        Matcher matcher = pat.matcher(phoneNo);
        if(matcher.matches()){
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(4));
            System.out.println(matcher.group(6));
            System.out.println(matcher.group(7));
        }
    }
}
