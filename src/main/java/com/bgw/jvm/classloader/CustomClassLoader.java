package com.bgw.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 说明：CustomClassLoader
 *
 * @author ShujuboDev
 */
public class CustomClassLoader extends ClassLoader {

    private String path;

    public CustomClassLoader(String path) {
        this.path = path;
    }

    public CustomClassLoader() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //String classFileName = name.replace(".", "/") + ".class";
        String fileName = getFileName(name);
        File classFile = new File(fileName);

        try {
            FileInputStream fis = new FileInputStream(classFile);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len;
            try {
                while ((len = fis.read()) != -1) {
                    baos.write(len);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();

            return defineClass(fileName, bytes, 0, bytes.length);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    //获取要加载 的class文件名 com.anbai.Test
    private String getFileName(String name) {
        // TODO Auto-generated method stub
        int index = name.lastIndexOf('.');
        if (index == -1) {
            return name + ".class";
        }
        else {
            //return name.substring(index + 1) + ".class";
            return name.replace(".", "/") + ".class";
        }
    }
}
