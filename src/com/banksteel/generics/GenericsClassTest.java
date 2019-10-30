package com.banksteel.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import org.junit.Test;

public class GenericsClassTest {

    @Test
    public void test1() {
        GenericsClass<String, Integer> gc = new GenericsClass<>();
        String s = gc.getString("123", "123", 12);
        String string3 = gc.getString(12, "12", 23);
        String string = gc.getString("12", "12", 12);
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

        // 泛型不支持 8种基本数据类型，需要用对应类型的包装类。
        // List<int> l = new ArrayList<>(); // 编译报错

        // 创建泛型类数组时只能创建无限定通配符的。
        // List<Integer>[] l1 = new ArrayList<>[]; // 编译报错
        List<?>[] l2 = new ArrayList<?>[2]; // 编译通过
        l2[1] = new ArrayList<String>();
        List<?> a = l2[1]; // 变量 a 只能用于取数据，不能写入
    }

    /**
     * 把泛型变量当成方法的参数，利用Method类的getGenericParameterTypes方法来获取泛型的实际类型参数
     *
     */
    @Test
    public void test3() throws Exception {
        getParamType();

        // 定义一个包含int的链表
        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        // 获取链表的add方法，注意这里是Object.class，如果写int.class会抛出NoSuchMethodException异常
        Method m = al.getClass().getMethod("add", Object.class);
        // 调用反射中的add方法加入一个string类型的元素，因为add方法的实际参数是Object
        m.invoke(al, "hello");
        System.out.println(al.get(2));
    }
    
    @Test
    public void test4() {
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

    /* 利用反射获取方法参数的实际参数类型 */
    public void getParamType() throws NoSuchMethodException {
        Method method = GenericsClassTest.class.getMethod("applyMap", Map.class);
        // 获取方法的泛型参数的类型
        Type[] types = method.getGenericParameterTypes();
        System.out.println(types[0]);
        // 参数化的类型
        ParameterizedType pType = (ParameterizedType) types[0];
        // 原始类型
        System.out.println(pType.getRawType());
        // 实际类型参数
        System.out.println(pType.getActualTypeArguments()[0]);
        System.out.println(pType.getActualTypeArguments()[1]);
    }

    /* 供测试参数类型的方法 */
    public static void applyMap(Map<Integer, String> map) {}

}
