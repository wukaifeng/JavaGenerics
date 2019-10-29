package com.banksteel.generics;

import java.util.ArrayList;
import java.util.List;

public class Test1<T> {

    public void add(T t) {
        System.out.println(t);
    }
    public static void main(String[] args) {
        
        Test1<? extends Number> t = new Test1<>();
        Integer integer = new Integer(1);
       // t.add(integer);
        List<? super Number> list = new ArrayList<>();
        list.add(integer);
        list.add(1L);
        list.add(2.3d);
    }
}
