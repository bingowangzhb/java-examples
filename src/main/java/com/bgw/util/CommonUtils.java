package com.bgw.util;

/**
 * 手机号脱敏
 * @author Administrator
 */
public class CommonUtils {
    public static boolean isEmpty(String str) {
        // 判断字符串是否为空或长度为0
        return str == null || str.length() == 0;

    }


    public static boolean isBlank(String str) {
        int strLen;
        // 判断字符串是否为空或长度为是否为0
        if (str != null && (strLen = str.length()) != 0) {
            // 如果字符串不为空，且长度不为0，进行循环遍历
            for(int i = 0; i < strLen; ++i) {
                // 如果字符串指定位置的值不为空白字符，返回false；否则返回true
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
    /**
     * 手机号码前三后四脱敏
     */
    public static String mobileEncrypt(String mobile) {
        if (isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    /**
     * 身份证前三后四脱敏
     */
    public static String idEncrypt(String id) {
        if (isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }

    /**
     * 护照前2后3位脱敏，护照一般为8或9位
     * 中国护照号一共是9位数。开头一个大写字母，后面是八个阿拉伯数字。
     */
    public static String idPassport(String id) {
        if (isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.substring(0, 2) + new String(new char[id.length() - 5]).replace("\0", "*") + id.substring(id.length() - 3);
    }

    public static void main(String[] args) {
        System.out.println("手机号码前三后四脱敏: " + mobileEncrypt("18746046987"));
        System.out.println("身份证前三后四脱敏: " + idEncrypt("159898199502262713"));
        System.out.println("护照前2后3位脱敏: " + idPassport("A88888888"));
    }
}