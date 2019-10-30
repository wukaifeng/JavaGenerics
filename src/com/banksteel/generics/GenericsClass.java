package com.banksteel.generics;

public class GenericsClass<T, V> {
	
	/**
	 * 方法声明中定义的形参只能在该方法里使用，而接口、类声明中定义的类型形参则可以在整个接口、类中使用。
	 * 当调用fun()方法时，根据传入的实际对象，编译器就会判断出类型形参T所代表的实际类型
	 * @return
	 */
	public <R> R getString(R t, V v) {
		
		return t;
	}

	public <R> R getString2(R v) {
		
		return v;
	}
	
}
