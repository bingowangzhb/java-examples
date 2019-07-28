package com.zb.designpatterns.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/8/9 14:57
 */
public abstract class Pizza {
    /**
     * 名称
     */
    String name;

    /**
     * 生面团
     */
    String dough;

    /**
     * 调味汁
     */
    String sauce;

    /**
     * 调料
     */
    List<String> toppings = new ArrayList<String>();

    /**
     * prepare
     */
    public void prepare() {
        System.out.println("正在准备做" + name + "...");
        System.out.println("和面团...");
        System.out.println("加入调味汁...");
        System.out.println("加入调料:");
        for (int i = 0, len = toppings.size(); i < len; i++) {
            System.out.println(" " + toppings.get(i));
        }
    }

    public void bake() {
        System.out.println("烘焙25-30分钟");
    }

    public void cut() {
        System.out.println("披萨切片");
    }

    public void box() {
        System.out.println("披萨打包");
    }

    public String getName() {
        return name;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getToppings() {
        return toppings;
    }
}
