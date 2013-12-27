package com.nacorpio.pjsocial.serialization;

public class Serialization<T> {
	
	T data;
	Class<?> base_class;
	
	public Serialization() {
		base_class = data.getClass();
	}
	
	@SuppressWarnings("unchecked")
	public final T getInstance() throws InstantiationException, IllegalAccessException {
		return (T) base_class.newInstance();
	}
	
}
