package com.bgw.generic.wildcards;

/**
 * @author ambow
 * @since 2021/7/7 10:18
 */
public class Plate<T> {

    private T item;

    public Plate() {
    }

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
