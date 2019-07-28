package com.bingo.jdemo.java8.ch2.case1;

/**
 * 说明：
 *
 * @author ShujuboDev 2019/1/18 17:16
 */
public class Apple implements Comparable<Apple> {

    private String color;

    private int weight;

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }


    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Apple o) {
        return this.getWeight() - o.getWeight();
    }
}
