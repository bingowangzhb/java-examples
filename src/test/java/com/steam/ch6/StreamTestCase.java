package com.steam.ch6;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summarizingInt;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/24 10:35
 */
public class StreamTestCase {

    private List<JSONObject> list;

    @Before
    public void before() {
        JSONObject obj1 = new JSONObject();
        obj1.put("name", "JamesHarden");
        obj1.put("team", "Rockets");
        obj1.put("value", 35);

        JSONObject obj2 = new JSONObject();
        obj2.put("name", "KevinDurant");
        obj2.put("team", "Warriors");
        obj2.put("value", 28);
        JSONObject obj3 = new JSONObject();
        obj3.put("name", "LebronJames");
        obj3.put("team", "Lakers");
        obj3.put("value", 25);
        JSONObject obj4 = new JSONObject();
        obj4.put("name", "StevinCurry");
        obj4.put("team", "Warriors");
        obj4.put("value", 30);
        JSONObject obj5 = new JSONObject();
        obj5.put("name", "DerrickRose");
        obj5.put("team", "Wolfives");
        obj5.put("value", 18);
        JSONObject obj6 = new JSONObject();
        obj6.put("name", "PaulGeorge");
        obj6.put("team", "OKC");
        obj6.put("value", 20);

        list = Arrays.asList(obj1, obj2, obj3, obj4, obj5, obj6);
    }

    @Test
    public void testCollect() {
        IntSummaryStatistics intSummaryStatistics = list.stream().collect(summarizingInt(obj -> obj.getIntValue("value")));
        System.out.println(intSummaryStatistics);

        String someStr = list.stream().map(obj -> obj.getString("name")).collect(joining(", "));
        System.out.println(someStr);

        int totalPoints = list.stream().map(obj -> obj.getIntValue("value")).reduce(0, (i, j) -> i + j);
        System.out.println(totalPoints);
    }

    @Test
    public void test() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
//        List<Integer> numbers = stream.reduce(
//                new ArrayList<Integer>(),
//                (List<Integer> l, Integer e) -> {
//                    l.add(e);
//                    return l;
//                }, (List<Integer> l1, List<Integer> l2) -> {
//                    l1.addAll(l2);
//                    return l1;
//                });
//
//
//        System.out.println(numbers);

       // List<JSONObject> list = stream.reduce(new ArrayList<JSONObject>(), )


//        Map<String, List<JSONObject>> teamMap = list.stream().collect(groupingBy(o -> o.getString("team")));
//
//        System.out.println(teamMap);
//
//        list.stream().map(o -> o.getString("name"));

        list.stream().map(new GetStringFunction()).forEach(new PrintFuncton());

        list.stream().map(new Function<JSONObject, String>() {
            @Override
            public String apply(JSONObject jsonObject) {
                return jsonObject.getString("name");
            }
        }).forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}


class GetStringFunction implements Function<JSONObject, String> {
    @Override
    public String apply(JSONObject jsonObject) {
        return jsonObject.getString("name");
    }
}

class PrintFuncton implements Consumer<String> {
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}