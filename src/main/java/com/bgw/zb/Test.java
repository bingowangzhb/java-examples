package com.bgw.zb;

import java.util.Arrays;

/**
 * Test
 *
 * @author zhibin.wang
 * @since 2020/10/30 10:24
 */
public class Test {
    public static void main(String[] args) {

        String correctAnswer = "Cushing Academy's$high school's";

        correctAnswer = correctAnswer.replace("’", "'");
        correctAnswer = correctAnswer.replace("‘", "'");
        correctAnswer = correctAnswer.replace("＇", "'");


        String[] correctAnswerArray = correctAnswer.split("[;；]");

        System.out.println("Arrays.toString(correctAnswerArray) = " + Arrays.toString(correctAnswerArray));



        String str1 = "Cushing Academy's;high；school's";
        String str2 = "Cushing ！ A!cad#emy's@high;school's";

        String[] strs1 = str1.split("[;；]");
        String[] strs2 = str2.split("[!！#;@；]");

        System.out.println("Arrays.toString(strs1) = " + Arrays.toString(strs1));
        System.out.println("Arrays.toString(strs2) = " + Arrays.toString(strs2));

    }
}
