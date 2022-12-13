package com.java19.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPract {
    public static void main(String[] args) {
        var phoneNumber = "12.232.333.2365";
        var regex = "(?:(?<countryCode>\\d{1,2})[.,\\s]?)?(?:(?<areaCode>\\d{3})[-.,\\s]?)(?:(\\d{3})[-.,\\s]?)(\\d{4})";
        var pat = Pattern.compile(regex);
        var mat = pat.matcher(phoneNumber);
        System.out.println(mat.matches());

        if(mat.matches()){
            System.out.format("Country code : %s\n" , mat.group("countryCode"));
            System.out.format("Area code : %s\n" , mat.group("areaCode"));
            System.out.format("Exchange code : %s\n" , mat.group(3));
            System.out.format("Line number code : %s\n" , mat.group(4));
        }
    }
}
