package com.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/12/25 14:28
 */
public class NioTest {

    public static void main(String[] args) throws Exception {

        RandomAccessFile randomAccessFile = new RandomAccessFile("nio-test.txt", "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        int byteRead = fileChannel.read(byteBuffer);

        while (byteRead != -1) {
            System.out.println("Read: " + byteRead);

            byteBuffer.flip();

            while (byteBuffer.hasRemaining()) {
                System.out.println((char) byteBuffer.get());
            }


            byteBuffer.clear();

           byteRead = fileChannel.read(byteBuffer);
        }

        randomAccessFile.close();
    }
}
