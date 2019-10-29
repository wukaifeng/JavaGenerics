package com.banksteel.generics;

public class Demo {
    
    /**
     * 泛型方法
     */
    public <T> T getInput(T t) {
        
        return t;
    }
    
    public static void main(String[] args) {
        Demo demo = new Demo();
        
        String demoStr = demo.getInput("123");
        Long demoLong = demo.getInput(12L);
        Integer demoInteger = demo.getInput(12);
        System.out.println("demoStr:" + demoStr);
        System.out.println("demoLong:" + demoLong);
        System.out.println("demoInteger:" + demoInteger);
    }

}
