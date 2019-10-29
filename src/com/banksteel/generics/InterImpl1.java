package com.banksteel.generics;

public class InterImpl1 extends InterImpl<String> {

    @Override
    public void show(String t) {
        super.show(t);
    }
    
    public static void main(String[] args) {
        InterImpl1 impl1 = new InterImpl1();
        impl1.show("test interImpl1");
    }

}
