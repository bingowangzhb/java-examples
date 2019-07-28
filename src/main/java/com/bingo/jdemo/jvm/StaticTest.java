package com.bingo.jdemo.jvm;

/**
 * 说明：s
 *
 * @author ShujuboDev
 */
public class StaticTest extends StaticParent {


    StaticTest st = new StaticTest();
    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    
    static int b = 112;

    public static void main(String[] args) {
        staticFunction();
    }
}

class StaticParent {
    static {
        System.out.println("5");
    }
}
/*
 * 类的生命周期为 加载->验证->准备->解析->初始化->卸载
 * 只有在准备和初始化阶段才会涉及变量的初始化和赋值
 *
 * 1. 准备阶段：为类变量分配内存并设置默认值，因此st=null，b=0
 * 注意：如果类变量被final修饰，那么编译时会为value生成ConstantValue属性，
 *          在准备阶段虚拟机就会根据ConstantValue的设置将变量设置为指定的值
 *
 *
 */
/*
    类初始化阶段是执行类构造器<clinit>()方法的过程.
    <clinit>()方法是由编译器自动收集类中的所有类变量的赋值动作和静态语句块static{}中的语句合并产生的，
        编译器收集的顺序是由语句在源文件中出现的顺序所决定的，静态语句块只能访问到定义在静态语句块之前的变量，
        定义在它之后的变量，在前面的静态语句块可以赋值，但是不能访问

    类的实例化是指创建一个类的实例(对象)的过程；
    类的初始化是指为类中各个类成员(被static修饰的成员变量)赋初始值的过程，是类生命周期中的一个阶段

    创建一个对象常常需要经历如下几个过程：
    父类的类构造器<clinit>() -> 子类的类构造器<clinit>() -> 父类的成员变量和实例代码块 ->
    父类的构造函数 -> 子类的成员变量和实例代码块 -> 子类的构造函数
 */