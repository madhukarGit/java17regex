package com.java19.regex_repractise;

import java.util.HashMap;
import java.util.Map;

public class RegexExpertLevelSection50 {
    public static void main(String[] args) {
        String text = "boudie123456abu";
        Map<Character, Integer> values = new HashMap<>();
        for (char character : text.replaceAll("\\d", "").toCharArray()) {
            if(values.containsKey(character)){
                values.put(Character.valueOf(character),values.get(character)+1);
            }else{
                values.put(Character.valueOf(character),1);
            }
        }
        values.entrySet().forEach((a)->{
            System.out.println(a);
        });
    }
}
