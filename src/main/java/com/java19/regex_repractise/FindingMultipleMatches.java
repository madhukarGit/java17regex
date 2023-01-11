package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindingMultipleMatches {
    private static String people = """
            Flinstone, Fred, 11/01/1990
            Rubble, Barney, 2/2/1905
            Flinstone, Wilma, 3/3/1990
            Rubble, Betty, 4/7/1991 
            """;
    public static void main(String[] args) {
        String regex = """
                        (?<firstName>\\w+)[-,][\\s+]?(?<lastName>\\w+)[-,\\s][\\s+]?
                        (?<day>\\d+)[/-](?<month>\\d+)[/-](?<year>\\d+)\\n
                        """;

        Pattern pat = Pattern.compile(regex,Pattern.DOTALL | Pattern.COMMENTS);
        Matcher matcher = pat.matcher(people);
        while(matcher.find()){
            System.out.println(matcher.group("firstName"));
            System.out.println(matcher.group("lastName"));
            System.out.println(matcher.group("day"));
            System.out.println(matcher.group("month"));
            System.out.println(matcher.group("year"));
            System.out.println(".....");
        }
    }
}
