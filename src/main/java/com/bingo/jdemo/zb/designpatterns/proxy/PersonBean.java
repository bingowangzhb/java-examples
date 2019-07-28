package com.bingo.jdemo.zb.designpatterns.proxy;

/**
 * 说明：
 *
 * @author ShujuboDev 2018/8/3 16:08
 */
public interface PersonBean {

    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);

}
