package com.banksteel.generics;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class GenericsClassTest {

    @Test
    public void test1() {
        GenericsClass<String, Integer> gc = new GenericsClass<>();
        String s = gc.getString("123", 12);
        Integer string3 = gc.getString(12, 23);
        Integer string = gc.getString(12, 12);
        System.out.println("s:" + s);

        Integer string2 = gc.getString2(12);
        System.out.println("string2:" + string2);
    }

    // 无限通配符可以方便使用但也是有限制的，无限通配符意味着不知道具体类型，所以数据只能读取，不能写入。
    @Test
    public void test2() {
        List<Integer> lInt = new ArrayList<>();
        lInt.add(1);
        lInt.add(2);
        List<?> l = lInt;
        System.out.println(l.get(1)); // 输出：2
        // l.add(3); // 编译报错

        // 泛型不支持 8 中基本数据类型，需要用对应类型的包装类。
        // List<int> l = new ArrayList<>(); // 编译报错
        
        //创建泛型类数组时只能创建无限定通配符的。
        //List<Integer>[] l1 = new ArrayList<>[]; // 编译报错
        List<?>[] l2 = new ArrayList<?>[2]; // 编译通过
        l2[1] = new ArrayList<String>();
        List<?> a = l2[1]; // 变量 a 只能用于取数据，不能写入
    }

}
