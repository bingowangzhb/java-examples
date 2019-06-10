package com.util;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;


/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/21 10:29
 */
public class UtilTestCase {

    @Test
    public void test1() {
        JSONObject obj = new JSONObject();
        obj.put("user_name", "James ");
        obj.put("password", "");
        obj.put("flag", null);
        obj.put("flag2", "null");


        System.out.println(obj.containsKey("user_name"));
        System.out.println(obj.containsKey("password"));
        System.out.println(obj.containsKey("flag"));


        System.out.println(obj.getString("user_name"));
        System.out.println(obj.getString("password"));
        System.out.println(obj.getString("flag2").equals(obj.getString("flag")));
        System.out.println(null == obj.getString("flag"));

        System.out.println("-----------------------");

        System.out.println(isEmpty(obj, "user_name"));
        System.out.println(isEmpty(obj, "password"));
        System.out.println(isEmpty(obj, "flag2"));
        System.out.println(isEmpty(obj, "flag1"));
        System.out.println(isEmpty(obj, "flag"));

    }


    private boolean isEmpty(JSONObject obj, Object key) {
        if (null == obj || null == key || key.equals("")) {
            throw new IllegalArgumentException();
        }

        // 1 空字符串 2 空指针
        if (!obj.containsKey(key)) {
            return true;
        }

        Object value = obj.get(key);
        if (value == null) {
            return true;
        }
        else {
            if (value instanceof String) {
                return "".equals(((String) value).trim());
            }
            else {
                return false;
            }
        }
    }
}
