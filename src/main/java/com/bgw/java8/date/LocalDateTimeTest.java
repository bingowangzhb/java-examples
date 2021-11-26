package com.bgw.java8.date;

import java.time.Duration;
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

        LocalDateTime d1 = LocalDateTime.of(2021, 11, 4, 11, 0);

        Duration duration = Duration.between(now, d1);
        System.out.println("duration = " + duration.toMinutes());
        //时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("now : " + now.format(formatter));

        //当天的零点
        LocalDateTime zeroTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println("当天的零点:  " + zeroTime.format(formatter));


        System.out.println("now.format = " + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));



        testPlus();


    }

    private static void testPlus() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime l = now.plusHours(0).plusMinutes(20);
        System.out.println("l = " + l);

    }
}
