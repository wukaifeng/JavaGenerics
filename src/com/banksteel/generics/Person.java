package com.banksteel.generics;

public class Person {
    
    public <T> Person(T t) {
        System.out.println(t);
    }
    
    public static void main(String[] args) {
        Person s = new Person("zhangsan");
        
    }

}
