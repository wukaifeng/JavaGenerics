package com.banksteel.generics;

/**
 * 测试泛型数组
 * @author wukaifeng
 *
 * @param <T>
 */
public class GenericArray<T> {

    private Object[] array;
    
    public GenericArray(int v) {
        array = new Object[v];
    }
    
    public void put(int index, T item) {
        array[index] = item;
    }
    
    public T get(int index) {
        return (T) array[index];
    }
    
    public T[] rep() {
        return (T[]) array;
    }
    
    public Object[] rep2() {
        return array;
    }
    
    public static void main(String[] args) {
        GenericArray<Integer> ga = new GenericArray<>(1);
        ga.put(0, 12);
        Integer integer = ga.get(0);
        System.out.println("integer:" + integer);
       // 下面不可强转
        // Integer[] rep2 = ga.rep();
        Object[] rep = ga.rep();
        for (int i = 0; i < rep.length; i++) {
            Integer in = (Integer) rep[i];
            System.out.println("in:" + in);
        }
        
        Object[] objArray = new Object[5];
        objArray[0] = 1;
        // 同样是不可强转
        // Integer[] integerArray = (Integer[]) objArray;
       
    }
}
