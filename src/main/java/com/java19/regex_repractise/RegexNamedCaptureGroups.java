package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexNamedCaptureGroups {
    public static void main(String[] args) {
        String phoneNumber = "12.232.333.2365";
        String regex = "(?:(?<countryCode>\\d{1,2})[-./\\s]?)?(?:(?<areaCode>\\d{3})[-./\\s]?)" +
                "(?:(?<exchange>\\d{3})[-./\\s]?)(?<lineNumber>\\d{4})";
        Pattern pat = Pattern.compile(regex,Pattern.COMMENTS);
        Matcher matcher =pat.matcher(phoneNumber);
        if(matcher.matches()){
            System.out.println(matcher.group("countryCode"));
            System.out.println(matcher.group("areaCode"));
            System.out.println(matcher.group("exchange"));
            System.out.println(matcher.group("lineNumber"));
        }
    }
}
