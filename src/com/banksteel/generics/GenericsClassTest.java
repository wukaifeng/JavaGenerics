package com.banksteel.generics;

public class GenericsClassTest{
	
	public static void main(String[] args) {
		GenericsClass<String, Integer> gc = new GenericsClass<>();
		String s = gc.getString("123", 12);
		Integer string3 = gc.getString(12, 23);
		Integer string = gc.getString(12, 12);
		System.out.println("s:" + s);
		
		Integer string2 = gc.getString2(12);
		System.out.println("string2:" + string2);
	}

}
