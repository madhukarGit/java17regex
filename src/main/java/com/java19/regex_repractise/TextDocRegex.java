package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextDocRegex {
    public static void main(String[] args) {
        var text = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;
        var regex = """
                    Student\\sNumber:\\s+(?<studentNumber>\\d+)\\s+
                    Grade:\\s+(?<grade>\\d+)\\s+
                    Birthdate:\\s+(?<month>\\d+)[/\\s.-](?<day>\\d+)[/\\s-.](?<year>\\d+).*
                    Gender:\\s+(?<gender>\\w+   )\\b.*
                    State\\sID:\\s+(?<stateId>\\d+).*
                    Cumulative\\s+GPA\\s+\\(Weighted\\)\\s+(?<weighted>\\d[.]\\d+)\\b.*?
                    Unweighted\\)\\s+(?<unweighted>\\d[.]\\d+).*
                    """;

        Pattern pat = Pattern.compile(regex,Pattern.COMMENTS | Pattern.DOTALL);
        Matcher matcher  = pat.matcher(text);
        if(matcher.matches()){
            System.out.println(matcher.group("studentNumber"));
            System.out.println(matcher.group("grade"));
            System.out.println(matcher.group("month"));
            System.out.println(matcher.group("day"));
            System.out.println(matcher.group("year"));
            System.out.println(matcher.group("gender"));
            System.out.println(matcher.group("stateId"));
            System.out.println(matcher.group("weighted"));
            System.out.println(matcher.group("unweighted"));
        }
    }
}
