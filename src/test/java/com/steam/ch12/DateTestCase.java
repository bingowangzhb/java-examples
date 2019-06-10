package com.steam.ch12;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/23 17:29
 */
public class DateTestCase {


    @Test
    public void testDate() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        System.out.println(year);

        Month month = date.getMonth();
        int m = month.getValue();
        System.out.println(m);

        int day = date.getDayOfMonth();
        System.out.println(day);



        int year2 = date.get(ChronoField.YEAR);
        int month2 = date.get(ChronoField.MONTH_OF_YEAR);
        int day2 = date.get(ChronoField.DAY_OF_MONTH);

        System.out.println(year2 + "" + month2 + "" + day2);


        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalTime localTime = LocalTime.now();


        LocalDate ld1 = localDateTime.toLocalDate();
        LocalTime lt1 = localDateTime.toLocalTime();

        System.out.println(localDate);
        System.out.println(localDateTime);
        System.out.println(localTime);
        System.out.println(ld1);
        System.out.println(lt1);

    }
}
