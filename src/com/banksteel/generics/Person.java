package com.banksteel.generics;

public class Person<E> {
    public <T> Person(T t) {
        System.out.println(t);
    }
    
    public void sys(E e) {
        System.out.println("e:" + e);
    }
    
    public static void main(String[] args) {
        Person<Integer> p = new Person<>("zhangsan");
        p.sys(12);
    }
}
