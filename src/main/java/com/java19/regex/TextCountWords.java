package com.java19.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCountWords {
    public static void main(String[] args) {
        String text = "Hey  hello      world";
        System.out.println(text.matches("(([A-Za-z]{3}[\\s]*))((\\w{1,}[\\s]*))((\\w{1,}))"));
        String regex = "(([A-Za-z]{3}[\\s]*))((\\w{1,}[\\s]*))((\\w{1,}))";
        Pattern pat  = Pattern.compile(regex);
        Matcher matcher = pat.matcher(text);
        int count = 0;
        if(matcher.matches()){
            System.out.println(matcher.groupCount()/2);
        }

//        String textToOptimize = "Hey  hello   john click    world";
//        System.out.println("optimize "+textToOptimize.matches("(\\w{1,}[\\s]*)*"));
//
//        String regexOpti = "(\\w{1,}[\\s]*)*";
//        Pattern patO = Pattern.compile(regexOpti);
//        Matcher matcherO = patO.matcher(textToOptimize);
    }
}
