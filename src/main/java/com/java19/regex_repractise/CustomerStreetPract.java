package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStreetPract {
    public static void main(String[] args) {
        String text = """
                "customer_street":"9526 Noble Embers Ridge"
                "customer_street":"1536 mobile rangers"
                "customer_street":"1345 johnny loop"
                """;

        String regex = """
                    \"customer_street\":\"(?<data>[0-9\\s\\w]*)\"\\n
                    """;
        Pattern pattern = Pattern.compile(regex,Pattern.DOTALL | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group("data"));
        }
    }
}
