package com.bingo.jdemo.jvm.classloader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * 说明：CustomClassLoaderTest
 *
 * @author ShujuboDev
 */
public class CustomClassLoaderTest {

//    public static void main(String[] args) throws Exception {
//        CustomClassLoader loader = new CustomClassLoader();
//        Class c = loader.loadClass("com.bingo.jdemo.jvm.classloader.Test2");
//        if (null != c) {
//            System.out.println(c.getClassLoader());
//            Object obj = c.newInstance();
//            Method m = c.getMethod("sayHello");
//            m.invoke(obj);
//        }
//    }

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            FileInputStream fis = new FileInputStream(classPath + "/" + name.replaceAll("\\.", "/")
                    + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;

        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

    };

    public static void main(String args[]) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("D:/mnt");
        Class clazz = classLoader.loadClass("com.anbai.Test");
        Object obj = clazz.newInstance();
        Method helloMethod = clazz.getMethod("sayHello");
        helloMethod.invoke(obj);
    }
}
