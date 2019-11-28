package com.bgw.encrytion;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.StandardCharsets;

/**
 * RsaEncryptionTestCase
 *
 * @author zhibin.wang
 * @since 2019-11-28 14:14
 **/
public class RsaEncryptionTestCase {


    public static void main(String[] args) throws Exception {
        // String plainText = "我爱你中国&+-/==";
        // encodeBase64(plainText);
        // System.out.println("--------------");
        // encodeBase64URLSafe(plainText);

        testRsa();

    }



    private static void encodeBase64(String plainText) {
        byte[] bs = plainText.getBytes();

        String encodedContent = Base64.encodeBase64String(bs);
        System.out.println("plainText: " + plainText);
        System.out.println("encode: " + encodedContent);
        System.out.println("decode: " + new String(Base64.decodeBase64(encodedContent), StandardCharsets.UTF_8));
    }

    private static void encodeBase64URLSafe(String plainText) {
        byte[] bs = plainText.getBytes();
        String encodedContent = Base64.encodeBase64URLSafeString(bs);
        System.out.println("plainText: " + plainText);
        System.out.println("encode: " + encodedContent);
        System.out.println("decode: " + new String(Base64.decodeBase64(encodedContent), StandardCharsets.UTF_8));
    }

    private static void testRsa() throws Exception {
        String[] keys = RSAUtils.genKeyPair();

        String publicKey = keys[0];
        String privateKey = keys[1];

        System.out.println("publicKey: " + publicKey);
        System.out.println("privateKey: " + privateKey);

        String plainText = "我爱你中国";
        System.out.println("plainText: " + plainText);

        String cipherText  = RSAUtils.encrypt(plainText, publicKey);
        System.out.println("encryptionText: " + cipherText);

        String decodedPlainText = RSAUtils.decrypt(cipherText, privateKey);

        System.out.println("decodedPlainText: " + decodedPlainText);

    }
}
