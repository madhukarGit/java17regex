package com.java19.regex;

public class ABCRegExp {
    public static void main(String[] args) {
        System.out.println("Lat".matches("[^a-z]at"));
        //match three ,letter words
        System.out.println("123".matches("\\w\\w\\w"));

        //match digits using //d
        System.out.println("80D".matches("\\d\\d[A-Z]"));

        //match a phone number
        System.out.println("321-333-7652".matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"));
        //optimize using a quantifier
        System.out.println("321-333-7652".matches("\\d{3}-\\d{3}-\\d{4}"));
        System.out.println("321,333     7652".matches("\\d{3}[-.,\\s]\\d{3}[-.,\\s]+\\d{4}"));

        System.out.println("...................");

        System.out.println("-91 7382435935".matches("[+-]\\d+[.,\\s]*\\d+"));

        System.out.println("--------matching US mobile number for practise---------");
        System.out.println("+316-412-892".matches("[+]\\d{3}[-,.\\s]*\\d{3}[-,.\\s]*\\d{3,4}"));

        System.out.println("-------grouping the matches and add the quantifier-----");
        System.out.println("+312-319-567-43243".matches("[+](\\d{3}[-\\s]*){2,}\\d*"));

        System.out.println("......challenge....");
        System.out.println("1.232.333.2365".matches("\\d{1}[.]\\d{3}[.]\\d{3}[.]\\d{4}"));

        System.out.println("......challenge optimized....");
        System.out.println("1.232.333.2365".matches("\\d{1}[.](\\d{3}[.]){1,2}\\d{4}"));

        System.out.println("1.232.333.2365".matches("(\\d{1,4}[.]?){1,}"));

    }
}
