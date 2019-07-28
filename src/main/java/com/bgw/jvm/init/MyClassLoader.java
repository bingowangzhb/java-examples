package com.bgw.jvm.init;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/10/30 15:33
 */
public class MyClassLoader extends ClassLoader {

    private String rootDir;

    public MyClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (null == classData) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, classData, 0, classData.length);
    }

    //编写读取字节流的方法
    private byte[] getClassData(String className) {
        // 读取类文件的字节
        // 省略代码

        String classPath = rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";

        System.out.println(classPath);


        try {
            InputStream in = new FileInputStream(classPath);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[4096];
            int bufferReaded;
            while((bufferReaded = in.read(bytes)) != -1){
                baos.write(bytes, 0, bufferReaded);
            }

            return baos.toByteArray();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public static void main(String[] args) {

        Day day = Day.TUESDAY;

//        MyClassLoader classLoader = new MyClassLoader("com.anbai.safecloud.test");
//        System.out.println("自定义类加载器的父加载器: " + classLoader.getParent());
//        System.out.println("系统默认的AppClassLoader: " + ClassLoader.getSystemClassLoader());
//        System.out.println("AppClassLoader的父类加载器: " + ClassLoader.getSystemClassLoader().getParent());
//        System.out.println("ExtClassLoader的父类加载器: " + ClassLoader.getSystemClassLoader().getParent().getParent());
//
//
//        String rootDir="D:\\workspace\\idea\\safecloud-api\\src\\test\\java";
//        //创建自定义文件类加载器
//        MyClassLoader loader = new MyClassLoader(rootDir);
//
//        try {
//            //加载指定的class文件
//            Class<?> obj = loader.loadClass("Test");
//            Method method = obj.getMethod("printTime");
//            method.invoke(obj.newInstance());
//            //输出结果:I am DemoObj
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println(day.getValue() + day.getDesc());


        Path path = Paths.get("G:", "classloader");
        System.out.println();

    }


    enum Day {
        MONDAY(1, "星期一"),
        TUESDAY(2, "星期二"),
        WEDNESDAY(3, "星期三"),
        THURSDAY(4, "星期四"),
        FRIDAY(5, "星期五"),
        SATURDAY(6, "星期六"),
        SUNDAY(7, "星期日");

        private int value;
        private String desc;


        Day(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }


        public int getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }
    }
}
