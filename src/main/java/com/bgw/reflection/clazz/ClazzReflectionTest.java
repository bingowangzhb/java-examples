package com.bgw.reflection.clazz;

import com.bgw.reflection.beans.Drivable;
import com.bgw.reflection.beans.Father;
import com.bgw.reflection.beans.Flyable;
import com.bgw.reflection.beans.Gender;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ambow
 * @since 2021/8/30 14:04
 */
public class ClazzReflectionTest {
    public List<Class<?>> classes = new ArrayList<>(Arrays.asList(String.class, Integer[].class, int.class,
            long[].class, List.class, Void.class, Map.class, Gender.class));

    @Test
    public void testClasses() {
        System.out.println("ClazzReflectionTest.class.getClasses() = " + Arrays.toString(ClazzReflectionTest.class.getClasses()));
    }

    @Test
    public void testSuperClass() {

        // getSuperClass 获取显式父类
        System.out.println("Flyable.class.getGenericSuperclass() = " + Flyable.class.getGenericSuperclass());
        System.out.println("Flyable.class.getSuperclass() = " + Flyable.class.getSuperclass());
        System.out.println("Flyable.class.getInterfaces() = " + Arrays.toString(Flyable.class.getInterfaces()));

    }


    @Test
    public void testDeclaringClass() {
        // 注意：getEnclosingClass获取的是直接定义该类的外部类Class实例、这点和getDeclaringClass一致
        System.out.println("InnerClass.class.getDeclaringClass() = " + InnerClass.class.getDeclaringClass());
        System.out.println("InnerClass.class.getEnclosingClass() = " + InnerClass.class.getEnclosingClass());

        System.out.println("InnerClass.InnerInnerClass.class.getDeclaringClass() = " + InnerClass.InnerInnerClass.class.getDeclaringClass());
        System.out.println("InnerClass.InnerInnerClass.class.getEnclosingClass() = " + InnerClass.InnerInnerClass.class.getEnclosingClass());

        InnerClass innerClass = new InnerClass();
        innerClass.getInnerService().sayHello();
    }

    @Test
    public void testDeclaredClass() {
        System.out.println("ClazzReflectionTest.class.getDeclaredClasses() = " + Arrays.toString(ClazzReflectionTest.class.getDeclaredClasses()));
        System.out.println("InnerService.class.getDeclaredClasses() = " + Arrays.toString(InnerService.class.getDeclaredClasses()));
        System.out.println("Father.class.getDeclaredClasses() = " + Arrays.toString(Father.class.getDeclaredClasses()));
    }


    @Test
    public void testModifiers() {
        System.out.println("Object.class.getModifiers() = " + Object.class.getModifiers());
        System.out.println("ClazzReflectionTest.class.getModifiers() = " + ClazzReflectionTest.class.getModifiers());
        System.out.println("Father.class.getModifiers() = " + Father.class.getModifiers());
        System.out.println("Drivable.class.getModifiers() = " + Drivable.class.getModifiers());
        System.out.println("Gender.class.getModifiers() = " + Gender.class.getModifiers());
        System.out.println("Serializable.class.getModifiers() = " + Serializable.class.getModifiers());
        System.out.println("Flyable.class.getModifiers() = " + Flyable.class.getModifiers());
    }

    @Test
    public void testIsAssignableFrom() {
        System.out.println("Object.class.isAssignableFrom(String.class) = " + Object.class.isAssignableFrom(String.class));
        System.out.println("Object.class.isAssignableFrom(List.class) = " + Object.class.isAssignableFrom(List.class));
        System.out.println("List.class.isAssignableFrom(ArrayList.class) = " + List.class.isAssignableFrom(ArrayList.class));
        System.out.println("String.class.isAssignableFrom(String.class) = " + String.class.isAssignableFrom(String.class));
        System.out.println("String.class.isAssignableFrom(Integer.class) = " + String.class.isAssignableFrom(Integer.class));
        System.out.println("Object.class.isAssignableFrom(String[].class) = " + Object.class.isAssignableFrom(String[].class));
        System.out.println("int.class.isAssignableFrom(int.class) = " + int.class.isAssignableFrom(int.class));
        System.out.println("int.class.isAssignableFrom(Integer.class) = " + int.class.isAssignableFrom(Integer.class));
        System.out.println("Integer.class.isAssignableFrom(int.class) = " + Integer.class.isAssignableFrom(int.class));
    }

    @Test
    public void testName() {
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getSimpleName() + " : " + clazz.getName());
        }
    }

    @Test
    public void testCanonicalName() {
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getSimpleName() + " : " + clazz.getCanonicalName());
        }
    }

    @Test
    public void testToString() {
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getSimpleName() + ".toString() = " + clazz.toString());
        }
    }

    @Test
    public void testToGenericString() {
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getSimpleName() + ".toGenericString() = " + clazz.toGenericString());
        }
    }



    private static class InnerClass {

        private static class InnerInnerClass {

        }

        InnerService getInnerService() {
            return new InnerService() {
                @Override
                public void sayHello() {
                    // getEnclosingClass对匿名内部类也有效
                    System.out.println(this.getClass().getEnclosingClass());
                    System.out.println(this.getClass().getDeclaringClass());
                }
            };
        }
    }

    private interface InnerService {
        void sayHello();
    }


    public class PublicInnerClass {}

    private interface PublicService {}
}

