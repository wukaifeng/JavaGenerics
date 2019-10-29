package com.banksteel.generics;

public class UserTest<T, V> {
//    public void show(K k) { // 报错信息：'show(K)' clashes with 'show(V)'; both methods have same erasure
//        
//    }
//    public void show(V t) {
//    }
    
    public void show(String k) {
    }
    public void show(V t) {
    }
    
    private T[] values;
    public UserTest(T[] values) {
    //错误，不能实例化元素类型为类型参数的数组
    //this.values = new T[5];
    //正确，可以将values 指向类型兼容的数组的引用
    this.values = values;
    }
    
    //如果静态方法要使用泛型的话，必须将静态方法定义成泛型方法。正确
    public static <K> void test(K k) {
    }

}
