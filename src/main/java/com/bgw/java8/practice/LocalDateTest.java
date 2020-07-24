package com.bgw.java8.practice;

/**
 * LocalDateTest
 *
 * @author zhibin.wang
 * @since 2020/07/24 20:37
 */
public class LocalDateTest {

    public static void main(String[] args) {
        List<LocalDate> list = Arrays.asList(LocalDate.parse("2020-07-11"),
                LocalDate.parse("2020-07-12"),
                LocalDate.parse("2020-07-20"),
                LocalDate.parse("2020-07-21"),
                LocalDate.parse("2020-07-22"),
                LocalDate.parse("2020-07-23"),
                LocalDate.parse("2020-07-24"));

        List<LocalDate> lds = list.stream()
                .filter(l -> WEEKDAY_NO_MAP.get(EVERY_SATURDAY).contains(l.getDayOfWeek()))
                .collect(Collectors.toList());

        System.out.println(lds.size());
        LocalDate from = LocalDate.parse("2020-06-26");
        LocalDate to = LocalDate.parse("2020-07-25");

        ClassTime ct = new ClassTime();
        ct.setStartDate(from);
        ct.setEndDate(to);
        ct.setStartTime(LocalTime.of(12, 23));

        List<ClassTime> cts = new ArrayList<>();
        cts.add(ct);

        List<JSONObject> js = cts.stream()
                .flatMap(c -> c.getQualifiedDates()
                        .stream()
                        .map(cc -> {
                            JSONObject o = new JSONObject();
                            o.put("c", c.getStartTime());
                            o.put("cc", cc);
                            return o;
                        }))
                .collect(Collectors.toList());

        System.out.println(js.size());

        LocalTime lt = LocalTime.parse("14:00");
        System.out.println(lt.format(DateTimeFormatter.ofPattern("HH:mm:ss")));

        System.out.println(ct.getQualifiedDates());
    }
}
