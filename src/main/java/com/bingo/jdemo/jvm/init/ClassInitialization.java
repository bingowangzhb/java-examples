package com.bingo.jdemo.init;

import java.util.Random;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/10/26 13:47
 */
class Initable {
    //编译期静态常量
    static final int staticFinal = 47;
    //非编期静态常量
    static final int staticFinal2 =
            Initable4.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }

    public Initable() {
        System.out.println("Initable constructor...");
    }
}

class Initable2 {
    //静态成员变量
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    //静态成员变量
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }

}

class Initable4 {
    public static Random rand = new Random(47);

    static {
        System.out.println("Initializing Initable4");
    }
}

public class ClassInitialization {


    static {
        System.out.println("ClassInitialization ...");
    }

    public static void main(String[] args) throws Exception {
        //字面常量获取方式获取Class对象
        Class initable = Initable.class;

        System.out.println("After creating Initable ref");

        //不触发类初始化
        System.out.println(Initable.staticFinal);
        //会触发类初始化
        System.out.println(Initable.staticFinal2);
        //会触发类初始化
        System.out.println(Initable2.staticNonFinal);
        //forName方法获取Class对象
        Class initable3 = Class.forName("com.bingo.jdemo.init.Initable3");
        //System.out.println("After creating Initable3 ref");
        //System.out.println(Initable3.staticNonFinal);
    }
}

