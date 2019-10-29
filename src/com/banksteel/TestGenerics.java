package com.banksteel;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.junit.Test;

public class TestGenerics {

    @Test
    public void test1() {
        List list = new ArrayList();

        list.add(1234);
        list.add("123");

        // 会报java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
        // list.forEach(x -> System.out.println((String)x));
        // lambda 表达式
        Consumer consumer = System.out :: println;
        consumer = consumer.andThen(x -> System.out.println("end......" + x));
        // list.forEach(consumer.andThen(System.out::println));
        list.forEach(consumer);
    }
}
