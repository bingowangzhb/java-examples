package com.bgw.zb;

public class TestKey {
    public static void main(String[] args) {
        StringBuffer url = new StringBuffer("https://dev-shop.huanyuliren.cn/person/insert");
        StringBuffer tmp = null;
        String domain = (tmp = url.delete(0, url.indexOf("//") + 2)).delete(tmp.indexOf("/"), tmp.length()).toString();
        System.out.println(domain);

        Integer i = 128;
        Integer j = new Integer(4);
        IntegerHolder integerHolder = new IntegerHolder(128);
        System.out.println("integerHolder.i == i :" + (integerHolder.i == i));

    }


    static class IntegerHolder {
        final Integer i;

        public IntegerHolder(Integer i) {
            this.i = i;
        }
    }
}