package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class Server {


    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(8899);
        Socket client = null;

        boolean f = true;
        while (f) {
            client = server.accept();
            System.out.println("与客户端连接成功" + client.getInetAddress());

            new Thread(new ServerThread(client)).start();
        }

        server.close();
    }




    static class ServerThread extends Thread {
        private Socket client;

        public ServerThread(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // 获取socket输出流 向客户端发送数据
                PrintStream out = new PrintStream(client.getOutputStream());
                // 获取socket输入流 用来接收从客户端发来的信息
                BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

                boolean flag = true;

                while (flag) {

                    try {
                        String str = br.readLine();
                        System.out.println("received : " + str);
                        if (null == str || "".equals(str)) {
                            flag = false;
                        }
                        else {
                            if ("bye".equals(str)) {
                                flag = false;
                            }
                            else {
                                out.println("echo: " + str);
                            }
                        }
                    }
                    catch (SocketException e) {
                        System.out.println("断开连接");
                        flag = false;
                    }
                }

                out.close();
                br.close();
                client.close();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
