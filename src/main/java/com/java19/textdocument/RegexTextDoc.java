package com.java19.textdocument;

import java.util.regex.Pattern;

public class RegexTextDoc {
    public static void main(String[] args) {
        var text = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2000			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;

        var regex = """
                Student\\sNumber:\\s(?<studentNumber>\\d{10}).* #Grab student number
                Grade:\\s+(?<Grade>\\d{1,2}).*
                Birthdate:\\s+(?<birthDate>\\d{1,2}[/]\\d{1,2}[/]\\d{4}).*
                Gender:\\s+(?<gender>[A-Z])\\b.*
                State\\sID:\\s+(?<stateId>\\d+).*
                Cumulative\\sGPA\\s\\(Weighted\\)\\s+(?<weighted>\\d{1}[.]\\d{1,2}).*
                Cumulative\\sGPA\\s\\(Unweighted\\)\\s+(?<unweighted>\\d[.]?\\d{1,}).*
                """;

        var patten = Pattern.compile(regex,Pattern.DOTALL | Pattern.COMMENTS);
        var mat = patten.matcher(text);
        System.out.println(mat.matches());
        System.out.println("c".matches("[a-z]"));
        if(mat.matches()){
            System.out.format("Student number %s \n",mat.group("studentNumber"));
            System.out.format("Grade number %s \n",mat.group("Grade"));
            System.out.format("Birth date %s \n",mat.group("birthDate"));
            System.out.format("Gender %s \n",mat.group("gender"));
            System.out.format("State Id %s \n",mat.group("stateId"));
            System.out.format("Weighted %s \n",mat.group("weighted"));
            System.out.format("Uneighted %s \n",mat.group("unweighted"));
        }
    }
}
