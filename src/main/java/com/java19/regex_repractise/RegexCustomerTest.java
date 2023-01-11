package com.java19.regex_repractise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCustomerTest {
    public static void main(String[] args) {
        String text = """
                      {"customer_id":2,"customer_fname":"Mary","customer_lname":"Barrett","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX","customer_street":"9526 Noble Embers Ridge","customer_city":"Littleton","customer_state":"CO","customer_zipcode":"80126"}
                      {"customer_id":12420,"customer_fname":"Nathan","customer_lname":"Adams","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX","customer_street":"2877 Thunder Spring Isle","customer_city":"Caguas","customer_state":"PR","customer_zipcode":"00725"}
                      {"customer_id":12421,"customer_fname":"Kyle","customer_lname":"Small","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX","customer_street":"2584 Round Square","customer_city":"Middletown","customer_state":"CT","customer_zipcode":"06457"}                
                      """;
        String val = """
                {"customer_id":1,"customer_fname":"Richard","customer_lname":"Hernandez","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX","customer_street":"6303 Heather Plaza","customer_city":"Brownsville","customer_state":"TX","customer_zipcode":"78521"}
                {"customer_id":2,"customer_fname":"Mary","customer_lname":"Barrett","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX","customer_street":"9526 Noble Embers Ridge","customer_city":"Littleton","customer_state":"CO","customer_zipcode":"80126"}
                                                                                                                                                                                                                                                         
                        """;
        String textSmall = """
              {"customer_id":2,"customer_fname":"Mary","customer_lname":"Barrett","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX"}
              {"customer_id":12420,"customer_fname":"Nathan","customer_lname":"Adams","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX"}
              {"customer_id":12421,"customer_fname":"Kyle","customer_lname":"Small","customer_email":"XXXXXXXXX","customer_password":"XXXXXXXXX"}                
              """;
        /*
        {"customer_password":"XXXXXXXXX","customer_state":"TX","customer_zipcode":"78521",
                "customer_email":"XXXXXXXXX","customer_lname":"Hernandez","customer_fname":"Richard",
                "customer_id":1,"customer_street":"6303 Heather Plaza","customer_city":"Brownsville"}
            */
        String jsonText = """
                {"customer_password":"AXXXXXXXXX","customer_state":"TX","customer_zipcode":"78521","customer_email":"XXXXXXXXX","customer_lname":"Hernandez","customer_fname":"Richard","customer_id":1,"customer_street":"6303 Heather Plaza","customer_city":"Brownsville"}
                {"customer_password":"BXXXXXXXXX","customer_state":"TX","customer_zipcode":"78521","customer_email":"XXXXXXXXX","customer_lname":"Hernandez","customer_fname":"Richard","customer_id":1,"customer_street":"6303 Heather Plaza","customer_city":"Brownsville"}
                {"customer_password":"CXXXXXXXXX","customer_state":"TX","customer_zipcode":"78521","customer_email":"XXXXXXXXX","customer_lname":"Hernandez","customer_fname":"Richard","customer_id":1,"customer_street":"6303 Heather Plaza","customer_city":"Brownsville"}
                {"customer_password":"DXXXXXXXXX","customer_state":"TX","customer_zipcode":"78521","customer_email":"XXXXXXXXX","customer_lname":"Hernandez","customer_fname":"Richard","customer_id":1,"customer_street":"6303 Heather Plaza","customer_city":"Brownsville"}
                {"customer_password":"EXXXXXXXXX","customer_state":"TX","customer_zipcode":"78521","customer_email":"XXXXXXXXX","customer_lname":"Hernandez","customer_fname":"Richard","customer_id":1,"customer_street":"6303 Heather Plaza","customer_city":"Brownsville"}
                """;
        String jsonRegex = """
                [{][\"]customer_password[\"][:][\"](?<customerPassword>\\w+)[\"][,]
                [\"]customer_state[\"][:][\"](?<customerState>\\w+)[\"][,]
                [\"]customer_zipcode[\"][:][\"](?<customerZipcode>\\d+)[\"][,]
                [\"]customer_email[\"][:][\"](?<customerEmail>\\w+)[\"][,]
                [\"]customer_lname[\"][:][\"](?<customerLname>\\w+)[\"][,]
                [\"]customer_fname[\"][:][\"](?<customerFname>\\w+)[\"][,]
                [\"]customer_id[\"][:](?<customerId>\\d{1,})[,]
                [\"]customer_street[\"][:][\"](?<customerStreet>[0-9\\s\\w]*)[\"][,]
                [\"]customer_city[\"][:][\"](?<customerCity>\\w+)[\"][}]\\n
                """;
        String regex = """
                    [{][\"]customer_id[\"][:](?<customerId>\\d{1,})[,]
                    [\"]customer_fname[\"][:][\"](?<customerFname>\\w+)[\"][,]
                    [\"]customer_lname[\"][:][\"](?<customerLname>\\w+)[\"][,]
                    [\"]customer_email[\"][:][\"](?<customerEmail>\\w+)[\"][,]
                    [\"]customer_password[\"][:][\"](?<customerPassword>\\w+)[\"][}]\\n                             
                    """;

        String regexBig = """
                    [{][\"]customer_id[\"][:](?<customerId>\\d{1,})[,]
                    [\"]customer_fname[\"][:][\"](?<customerFname>\\w+)[\"][,]
                    [\"]customer_lname[\"][:][\"](?<customerLname>\\w+)[\"][,]
                    [\"]customer_email[\"][:][\"](?<customerEmail>\\w+)[\"][,]
                    [\"]customer_password[\"][:][\"](?<customerPassword>\\w+)[\"][,] 
                    [\"]customer_street[\"][:][\"](?<customerStreet>[0-9\\s\\w]*)[\"][,]
                    [\"]customer_city[\"][:][\"](?<customerCity>\\w+)[\"][,]
                    [\"]customer_state[\"][:][\"](?<customerState>\\w+)[\"][,]
                    [\"]customer_zipcode[\"][:][\"](?<customerZipcode>\\d+)[\"][}]\\n                          
                    """;
        Pattern pattern = Pattern.compile(jsonRegex,Pattern.DOTALL | Pattern.COMMENTS);
        Matcher matcher = pattern.matcher(jsonText);
        while(matcher.find()) {
//            System.out.println(matcher.group("customerId"));
//            System.out.println(matcher.group("customerFname"));
//            System.out.println(matcher.group("customerLname"));
//            System.out.println(matcher.group("customerEmail"));
//            System.out.println(matcher.group("customerStreet"));
//            System.out.println(matcher.group("customerCity"));
            System.out.println(matcher.group("customerPassword"));
            System.out.println(matcher.group("customerState"));
            System.out.println(matcher.group("customerZipcode"));
            System.out.println("..............");
        }
    }
}
