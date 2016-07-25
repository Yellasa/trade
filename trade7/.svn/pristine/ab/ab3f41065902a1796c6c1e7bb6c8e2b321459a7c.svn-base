package com.liantuo.unittest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UnitUtil {

	/**
	 * parameterObjects 参数全部为非空并且被调用方法没有基本类型参数
	 * 
	 * @param o
	 * @param methodName
	 * @param parameterObjects
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 */
	public static <T> T invokePrivateMethod(Object o, String methodName,
			Object... parameterObjects) throws IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		Class<?>[] c = null;
		if (parameterObjects != null && parameterObjects.length != 0) {
			c = new Class<?>[parameterObjects.length];
			for (int i = 0; i < parameterObjects.length; i++) {
				c[0] = parameterObjects[i].getClass();
			}
		}
		return (T) getMethod(o, methodName, c).invoke(o, parameterObjects);
	}

	public static <T> T invokePrivateMethod(Object o, String methodName,
			Class<?>[] parameterTypes, Object... parameterObjects)
			throws IllegalArgumentException, SecurityException,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {

		return (T) getMethod(o, methodName, parameterTypes).invoke(o,
				parameterObjects);
	}

	public static Method getMethod(Object o, String methodName,
			Class<?>... parameterTypes) throws SecurityException,
			NoSuchMethodException {
		// 测试没有参数的echoRequest()方法
		Method method;
		method = o.getClass().getDeclaredMethod(methodName, parameterTypes);
		method.setAccessible(true);
		return method;
	}
}
