package com.bgw.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LocalTimeSplitTest
 *
 * @author zhibin.wang
 * @since 2020/08/14 16:00
 */
public class LocalTimeSplitTest {

    public static void main(String[] args) {

        LocalTime l1 = LocalTime.of(8, 30, 0);
        LocalTime l2 = LocalTime.of(12, 0, 0);

        long size = ChronoUnit.MINUTES.between(l1, l2) / 30 + 1;
        System.out.println(size);
        List<LocalTime> lts = Stream.iterate(l1, h -> h.plusMinutes(30))
                .limit(size)
                .collect(Collectors.toList());

        System.out.println(lts);


        Map<String, String> map = new HashMap<>();
        map.put("1", "1");


        LocalDateTime ldt = LocalDateTime.parse("2020-08-09T22:00:00");
        System.out.println(ldt);






    }
}
