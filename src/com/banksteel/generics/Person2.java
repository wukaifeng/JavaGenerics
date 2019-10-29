package com.banksteel.generics;

public class Person2<E> {
    public <T> Person2(T t) {
        System.out.println(t);
    }
    
    public void sys(E e) {
        System.out.println("e:" + e);
    }
    
    public static void main(String[] args) {
        Person2<Integer> p = new Person2<>("zhangsan");
        p.sys(12);
    }
}
