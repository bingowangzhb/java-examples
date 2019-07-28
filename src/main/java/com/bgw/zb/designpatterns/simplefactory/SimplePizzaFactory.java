package com.bgw.zb.designpatterns.simplefactory;

import com.bgw.zb.designpatterns.model.CheesePizza;
import com.bgw.zb.designpatterns.model.ClamPizza;
import com.bgw.zb.designpatterns.model.PepperoniPizza;
import com.bgw.zb.designpatterns.model.Pizza;
import com.bgw.zb.designpatterns.model.VeggiePizza;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/8/9 15:12
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        }
        else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        else if(type.equals("clam")) {
            pizza = new ClamPizza();
        }
        else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        else {
            throw new RuntimeException("not exist");
        }

        return pizza;
    }
}
