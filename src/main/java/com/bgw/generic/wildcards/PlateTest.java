package com.bgw.generic.wildcards;

/**
 * 首先 List<? extents Fruit> fList= xxx 可以是 fList = List<Apple> 也可以是 fList = List<Banana> ，编译时刻 是没法确定 这个
 * 变量最终会指向谁，没准运行的时刻 你的指向一直在变呢 对吧？假如你指向了 Apple 那往苹果的盘子里添加香蕉总是不对的吧？
 * 香蕉是没法转型成苹果的，当然object也是不能向下转型成苹果的, 所以索性禁止你添加任何元素 除了null，
 * 往下是深不见底的 鬼知道你的盘子最终会要装啥 红苹果 红色烂苹果 红色富士苹果 看不透啊
 *
 * List<? super Apple > aList = xxx 可以是 aList = List<Apple> 也可以是 aList = List<Fruit> 还可以是 aList = List<Food> ，
 * 那么我们可以往苹果的盘子里放红苹果么 当然是没问题的 红苹果可以安全的向上转型成苹果，极端情况 你的盘子指向了Object ，
 * 把一个红苹果转成Object也是没任何问题的，那么我们可以向这个集合中添加 Food 么 ？不行的 因为你的盘子 可能指向 水果
 * aList = List<Fruit> Food是没法安全的转型成 水果的 ，同理Object也是不能添加的
 *
 *
 *
 * 总结一下 就是说 List<? xxx A> list 声明了 list这个变量 可以指向哪种类型的集合，但不是一种确定的类型 而是一个范围 ，
 * 只要我们的右值在这个范围内 就可以赋值给这个变量，而又因为 只声明了一个范围 ，所以具体是啥类型在编译时刻没法确定
 * @author ambow
 * @since 2021/7/7 10:26
 */
public class PlateTest {


    public static void main(String[] args) {

        Plate<? extends Fruit> p1 = new Plate<>(new RedApple());

        Plate<? super Apple> p2 = new Plate<>(new Fruit());

        //p2.setItem(new Fruit());

        System.out.println("p1.getItem() = " + p1.getItem());
        System.out.println("p2.getItem() = " + p2.getItem());

        Plate<? extends Fruit> p3 = new Plate<>();

        // p3.setItem(new Apple());

        Plate<? super Apple> p4 = new Plate<>();

        // p4.setItem(new Fruit());
        p4.setItem(new Apple());
        p4.setItem(new RedApple());


        Fruit f = p3.getItem();
        Object o = p4.getItem();
    }

}

/*
 * List<? extends Fruit> 中表示存放的元素是 Fruit 的任意一种子类，继承 Fruit 的类型那么多，这个特定类型是哪种呢，编译器不知道，
 * 因此无法写入，但是可以读，为什么呢，因为他们都继承于 Fruit，所以读出来就是 Fruit。
 *
 * List<? super Fruit> 中表示存放的元素是 Fruit 的任意一种超类，这当然可以存 Fruit及子类，因为编译器能确定继承Fruit ，
 * 这个特定类型就是 Fruit。他也可以读，但是读出来只能是Object，因为编译器不知道他到底属于 Fruit 的哪个超类，但它一定属于 Object，
 * 因为 Fruit 的祖宗一定是 Object。super 理解的难点在于虽然类型是 Fruit 的超类，但是只能存 Fruit 的子类，因为只有 Fruit 的子类才能确定它一定 instanceof Fruit 的父类！
 */