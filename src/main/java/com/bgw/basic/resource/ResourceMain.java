package com.bgw.basic.resource;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * ResourceMain
 *
 * @author zhibin.wang
 * @since 2020/10/12 20:46
 */
public class ResourceMain {

    public static void main(String[] args) {
        // loadResourceWithClass();
        // loadResourceWithClassLoader();
        loadResourceWithFile();
    }



    private static void loadResourceWithClass() {

        // file:/D:/Codes/IdeaProjects/java-examples/target/classes/com/bgw/basic/resource/
        System.out.println("ResourceMain.class.getResource(\"\") = " + ResourceMain.class.getResource(""));
        // file:/D:/Codes/IdeaProjects/java-examples/target/classes/
        System.out.println("ResourceMain.class.getResource(\"/\") = " + ResourceMain.class.getResource("/"));

        // 前提是需要配置maven资源配置打包.properties文件
        // 类名.class.getResource 相对路径 包内
        URL resource = ResourceMain.class.getResource("sample.properties");
        // file:/D:/Codes/IdeaProjects/java-examples/target/classes/com/bgw/basic/resource/sample.properties
        System.out.println("resource = " + resource);


        // 绝对路径从/开始
        resource = ResourceMain.class.getResource("/com/bgw/basic/resource/sample.properties");
        // file:/D:/Codes/IdeaProjects/java-examples/target/classes/com/bgw/basic/resource/sample.properties
        System.out.println("resource = " + resource);

        // 一样
        InputStream is = ResourceMain.class.getResourceAsStream("sample.properties");
        System.out.println("is = " + is);

        // file:/D:/Codes/IdeaProjects/java-examples/target/classes/demo.properties
        System.out.println("ResourceMain.class.getResource(\"/demo.properties\") = " + ResourceMain.class.getResource("/demo.properties"));
    }


    private static void loadResourceWithClassLoader() {
        // 末尾带了/
        // file:/D:/Codes/IdeaProjects/java-examples/target/classes/
        System.out.println("ClassLoader.getSystemResource(\"\") = " + ClassLoader.getSystemResource(""));

        // 注意这里不能以/开头  与class.getResource相比没有处理 /
        // file:/D:/Codes/IdeaProjects/java-examples/target/classes/com/bgw/basic/resource/sample.properties
        URL resource = ClassLoader.getSystemResource("com/bgw/basic/resource/sample.properties");
        System.out.println("resource = " + resource);

        // java.io.BufferedInputStream@3764951d
        System.out.println("ClassLoader.getSystemResourceAsStream(\"com/bgw/basic/resource/sample.properties\") = " + ClassLoader.getSystemResourceAsStream("com/bgw/basic/resource/sample.properties"));
        // java.io.BufferedInputStream@4b1210ee
        System.out.println("ClassLoader.getSystemResourceAsStream(\"demo.properties\") = " + ClassLoader.getSystemResourceAsStream("demo.properties"));

        // 备注像getSystemResources或者getResources相当于不仅在本类加载器中找，还会去父加载器中去找
    }


    private static void loadResourceWithFile() {
        // 显然通过这种间接的方式去构建一个File对象也是可行的 只是比较绕
        String filePath = ClassLoader.getSystemResource("config/jdbc/jdbc.properties").getFile();
        System.out.println("filePath = " + filePath);
        System.out.println(new File(filePath).exists()); //true

        // 项目根路径
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        // 相对路径的file只能获取和项目平级的资源 new File("names.txt");
        System.out.println("new File(\"names.txt\").getAbsolutePath() = " + new File("names.txt").getAbsolutePath());

    }

}
