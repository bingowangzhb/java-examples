package com.util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/2/12 10:26
 */
public class CollectionsTestCase {

    private List<String> list1;

    private List<String> list2;

    private String[] strs = {"One", "Two", "Three", "One", "Two", "Three"};


    @Before
    public void setUp() throws Exception {
        list1 = new ArrayList<>(Arrays.asList(strs));
        list2 = new ArrayList<>(Arrays.asList(strs));
    }

    @Test
    public void test() {
        System.out.println(list1);

        List<String> removeList = Arrays.asList("One", "Two");
        list1.removeAll(removeList);
        System.out.println(list1);

        List<String> singletonList = Collections.singletonList("One");



    }
}
