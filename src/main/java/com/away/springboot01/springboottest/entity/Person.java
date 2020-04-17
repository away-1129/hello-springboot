package com.away.springboot01.springboottest.entity;

/**
 * author:liuwei
 * date : 2019/12/27 15:20
 */
public class Person {
    private int age;
    private String name;

    public void writeavc(){

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
