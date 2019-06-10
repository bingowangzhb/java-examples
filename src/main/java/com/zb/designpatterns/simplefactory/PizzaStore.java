package com.zb.designpatterns.simplefactory;

import com.zb.designpatterns.model.Pizza;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/8/9 15:45
 */
public class PizzaStore {
    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new SimplePizzaFactory());
        store.orderPizza("cheese");
    }
}
