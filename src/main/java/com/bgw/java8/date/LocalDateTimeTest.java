package com.bgw.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ambow
 * @since 2021/10/19 17:42
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        //时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("now : " + now.format(formatter));

        //当天的零点
        LocalDateTime zeroTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println("当天的零点:  " + zeroTime.format(formatter));





    }
}
