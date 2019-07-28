package com.bgw.java8.ch3;

/**
 * 说明：
 *
 * @author ShujuboDev
 */
public class Color {

    /**
     * r
     */
    private int red;

    /**
     * g
     */
    private int green;

    /**
     * b
     */
    private int blue;


    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }


    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }
}
