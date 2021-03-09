package com.bgw.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class Client {

    public static void main(String[] args) throws Exception {

        // TCP连接
        Socket client = new Socket("localhost", 8899);
        //client.setSoTimeout(10000);

        //获取键盘输入
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));


        //获取socket输出流 用来发送数据到服务端
        PrintStream out = new PrintStream(client.getOutputStream());

        //获取socket输入流 接收来自服务端的数据
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

        boolean flag = true;
        while (flag) {
            System.out.println("input : ");
            String str = input.readLine();

            out.println(str);

            if ("bye".equals(str)) {
                flag = false;
            }
            else {
                try {
                    String echo = br.readLine();
                    System.out.println("echo: " + echo);
                }
                catch (SocketTimeoutException e) {
                    e.printStackTrace();
                }
            }

        }

        input.close();
        //如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
        client.close(); //只关闭socket，其关联的输入输出流也会被关闭
    }
}
