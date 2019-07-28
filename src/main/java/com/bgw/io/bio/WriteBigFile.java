package com.bgw.io.bio;

import javax.sql.DataSource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/12 10:34
 */
public class WriteBigFile {
    private static String str = "HelloWorldFriend";

    public static void main(String[] args) throws Exception {
        String word2048 = "";
        for (int i = 0; i < 128; ++i) {
            word2048 += str;
        }

        System.out.println(word2048.getBytes().length);
        File file = new File("bio.txt");

        long start = System.currentTimeMillis();
        writeBuffer(file, word2048);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        DriverManager driverManager;
        Driver driver;
    }

    //  FileOutputStream的写入方式类似，在此略
    public static void writeBuffer(File file, String word2048) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        int i = 1000000;
        while (i > 0) {
            //  word2048为字符串常量，刚好4800个字节
            writer.write(word2048);
            i--;
        }
        writer.close();
        fos.close();
    }

}
