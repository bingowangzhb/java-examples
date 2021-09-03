package com.bgw.regex;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ambow
 * @since 2021/7/8 14:56
 */
public class SimpleRegexTest {


    public static void main(String[] args) {
        r3();


    }

    private static void r() {
        String myText = "this is my 1st 2test string";
        String myRegex = "\\d+\\w+"; // \d+\w+
        Pattern p = Pattern.compile(myRegex);
        Matcher m = p.matcher(myText);
        while (m.find()) {

            MatchResult matchResult = m.toMatchResult();
            System.out.println("matchResult = " + matchResult);

            String matchedText = m.group();
            int matchedFrom = m.start();
            int matchedTo = m.end();

            System.out.println("matched [" + matchedText + "] from " + matchedFrom + " to " + matchedTo + ".");

            System.out.println(myText.charAt(matchedFrom)); // [11, 14)
            System.out.println(myText.charAt(matchedTo - 1));
        }


        boolean f1 = "1234".matches("\\d+");
        boolean f2 = "123s".matches("\\d+");

        System.out.println(f1 + " " + f2);
        String s = "foo bar foo bar";
        String r = "(foo)\\s(bar) \\1 \\2";
        boolean f3 = s.matches(r);
        System.out.println("f3 = " + f3);

        String ss = s.replaceFirst(r, "$1,$2");
        System.out.println("ss = " + ss);
    }


    public static void r2() {
        String url = "http://regex.info/blog";
        String regex = "(?x) ^";
        // (?x) 是注释模式 忽略空格和注释

    }

    public static void r3() {
        String text = "-->one+test<--";
        String regex = "\\w+";
        StringBuffer head = new StringBuffer();
        StringBuffer tail = new StringBuffer();
        Matcher m = Pattern.compile(regex).matcher(text);

        while (m.find()) {
            m.appendReplacement(head, "XXX");
            System.out.println("head = " + head);

        }



        //System.out.println("replaceAll(m, \"XXX\") = " + replaceAll(m, "XXX"));
    }



    public static String replaceAll(Matcher m, String replacement) {
        m.reset();
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(result, replacement);
        }
        m.appendTail(result);
        return result.toString();
    }
}
