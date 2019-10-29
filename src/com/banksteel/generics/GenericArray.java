package com.banksteel.generics;

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
    
    public static void main(String[] args) {
        GenericArray<Integer> ga = new GenericArray<>(1);
        ga.put(0, 12);
        Integer integer = ga.get(0);
        System.out.println("integer:" + integer);
        Integer[] rep = ga.rep();
        System.out.println("rep:" + rep.toString());
    }
}
