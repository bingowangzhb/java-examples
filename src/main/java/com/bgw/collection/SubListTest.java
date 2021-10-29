package com.bgw.collection;

import com.alibaba.fastjson.JSON;

import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ambow
 * @since 2021/10/18 16:58
 */
public class SubListTest {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        List<Integer> subList = list.subList(4, 5);
        System.out.println("subList = " + subList);

        String ss = JSON.toJSONString(null);
        System.out.println("ss = " + ss);


        System.out.println("JSON.toJSON(list) = " + JSON.toJSON(list).getClass()); // com.alibaba.fastjson.JSONArray
        System.out.println("JSON.toJSONString(list) = " + JSON.toJSONString(list).getClass()); // java.lang.String

        List<Integer> ff = JSON.parseArray(null, Integer.class);
        System.out.println("ff = " + ff);



    }
}
