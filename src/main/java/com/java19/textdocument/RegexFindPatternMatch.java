package com.java19.textdocument;

import java.util.regex.Pattern;

public class RegexFindPatternMatch {

    private static String people = """
            Flinstone, Fred, 1/1/1990
            Rubble, Barney, 2/2/1905
            Flinstone, Wilma, 3/3/1990
            Rubble, Betty, 4/7/1991 
            """;

    public static void main(String[] args) {
        String regex = "(?<name>\\w+),\\s+(?<firstname>\\w+),\\s+(?<month>\\d{1,2})/(?<day>\\d{1,2})/(?<year>\\d{4})\\n";
        var pattern = Pattern.compile(regex,Pattern.DOTALL | Pattern.COMMENTS);
        var mat = pattern.matcher(people);

        mat.find();

        System.out.format("name is %s \n",mat.group("name"));
        System.out.format("firstname is %s \n",mat.group("firstname"));
        System.out.format("month %s \n",mat.group("month"));
        System.out.format("day %s \n",mat.group("day"));
        System.out.format("year %s \n",mat.group("year"));

        int count = 0;
        while(mat.find()){
            count++;
        }
        System.out.println("count is "+count);
       }
}
