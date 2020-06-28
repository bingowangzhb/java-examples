package com.bgw.zb;

public class TestKey {
    public static void main(String[] args) {
        StringBuffer url = new StringBuffer("https://dev-shop.huanyuliren.cn/person/insert");
        StringBuffer tmp = null;
        String domain = (tmp = url.delete(0, url.indexOf("//") + 2)).delete(tmp.indexOf("/"), tmp.length()).toString();
        System.out.println(domain);
    }
}