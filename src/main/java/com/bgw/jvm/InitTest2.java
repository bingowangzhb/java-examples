package com.bgw.jvm;

/**
 * 说明：InitTest2
 *
 * @author ShujuboDev
 */
public class InitTest2 extends InitTest2Parent{
    static {
        i = 100;
        System.out.println("i");
    }

    {
        System.out.println("2"); // 示例代码块只有在类实例化的时候调用
    }

    public InitTest2() {
        System.out.println("3");
    }

    static int i = 3;

    public static void main(String[] args) {
        // 没有继承
        // System.out.println(InitTest2.i); i 3
        //InitTest2 initTest2 = new InitTest2(); // i 2 3

        // 继承
        // 1. 调用父类final变量不会触发父类初始化
        System.out.println(InitTest2Parent.k); // 4 5


    }
}

class InitTest2Parent {
    static int j = 100;
    static final int k = 200;
    static {
        j = 101;
        System.out.println("4");
    }

    public InitTest2Parent() {
        System.out.println("5");
    }
}
