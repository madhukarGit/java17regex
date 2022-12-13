package com.java19.textdocument;

import java.util.regex.Pattern;

public class TextDocumentGreedyOperator {
    /*
    * Parsing text document greedy operator ?
    * */

    public static void main(String[] args) {
        var text = """
                Student Number:	1234598872			Grade:		11
                Birthdate:		01/02/2020			Gender:	M
                State ID:		8923827123
                                
                Cumulative GPA (Weighted)		3.82
                Cumulative GPA (Unweighted)	3.46
                """;

        var regex = """
         Student\\sNumber:\\s+(?<studentNumber>\\d+).*
         Grade:\\s+(?<grade>\\d+).*
         Birthdate:\\s+((?<month>\\d{1,2})[/.])(?<day>\\d{1,2})[/.](?<year>\\d+).*
         Gender:\\s+(?<gender>\\w+).*
         State\\sID:\\s+(?<stateId>\\d+)\\b.*?
         Cumulative.*?(?<weighted>\\d{1}[.]\\d+).*
         Cumulative.*?(?<unweighted>[\\d\\.]+)\\b.*
         """;
        var pat = Pattern.compile(regex,Pattern.DOTALL | Pattern.COMMENTS);
        var mat = pat.matcher(text);
        System.out.println(mat.matches());
        if(mat.matches()){
            System.out.format("Student number %s \n",mat.group("studentNumber"));
            System.out.format("Grade is ",mat.group("grade"));
            System.out.format("month %s \n",mat.group("month"));
            System.out.format("day %s\n",mat.group("day"));
            System.out.format("Year %s\n",mat.group("year"));
            System.out.format("Gender %s\n",mat.group("gender"));
            System.out.format("State ID %s\n",mat.group("stateId"));
            System.out.format("weighted %s\n",mat.group("weighted"));
            System.out.format("weighted %s\n",mat.group("unweighted"));
        }
    }
}
