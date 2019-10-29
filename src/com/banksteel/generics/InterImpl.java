package com.banksteel.generics;

public class InterImpl<T> implements Inter<T> {

    @Override
    public void show(T t) {
        System.out.println("t:" + t);
    }
    
    public static void main(String[] args) {
        InterImpl<String> imp = new InterImpl<>();
        imp.show("测试..........");
    }

}
