package com.liantuo.unittest.mockito;

import org.mockito.ArgumentMatcher;

public class IsTClass<T extends Object> extends ArgumentMatcher<T> {
	private T t;

	public IsTClass(T t) {
		this.t = t;
	}

	public boolean matches(Object para) {
		return para.getClass() == t.getClass();
	}
}
