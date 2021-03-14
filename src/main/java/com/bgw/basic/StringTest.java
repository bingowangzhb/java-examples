package com.bgw.basic;

/**
 * StringTest
 *
 * @author wang
 * @since 2021/3/13 15:36
 **/
public class StringTest {
    public static void main(String[] args) {
        StringTest st = new StringTest();
        String str = "BEA";
        st.change(str);
        System.out.println("str = " + str);
    }

    void change(String str) {
        str = str.replace('A', 'E');
        str = str.toLowerCase();
    }

}
