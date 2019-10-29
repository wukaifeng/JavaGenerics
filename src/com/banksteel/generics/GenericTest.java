package com.banksteel.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 把泛型变量当成方法的参数，利用Method类的getGenericParameterTypes方法来获取泛型的实际类型参数
 *
 */
public class GenericTest {

    public static void main(String[] args) throws Exception {
        getParamType();
        
      //定义一个包含int的链表
        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(2);
        //获取链表的add方法，注意这里是Object.class，如果写int.class会抛出NoSuchMethodException异常
        Method m = al.getClass().getMethod("add", Object.class);
        //调用反射中的add方法加入一个string类型的元素，因为add方法的实际参数是Object
        m.invoke(al, "hello");
        System.out.println(al.get(2));
    }

    /* 利用反射获取方法参数的实际参数类型 */
    public static void getParamType() throws NoSuchMethodException {
        Method method = GenericTest.class.getMethod("applyMap", Map.class);
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
