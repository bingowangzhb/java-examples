package com.bgw.thd;

import lombok.extern.slf4j.Slf4j;

import java.security.AccessController;
public class TestLog {

    public static void main(String[] args) {

        SecurityManager securityManager = System.getSecurityManager();
        if (null != securityManager) {
            System.out.println("securityManager = " + securityManager);

        }


    }

    public void log1() {

        new Thread(() -> {
            Task t = new Task();
            for (int i = 0; i < 4; i++) {
                try {
                    t.exec(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void log2() {

        new Thread(() -> {
            Task t = new Task();
            for (int i = 0; i < 4; i++) {
               t.exec(i);
               System.out.println("log = " + i);

            }
        }).start();

    }

    class Task {
        public void exec(int i) {
            if (i == 1) {
                throw new RuntimeException("1");
            }
            else if (i == 2) {
                throw new RuntimeException("2");
            }

            System.out.println("i = " + i);
        }
        
    }
    
    
    
}
