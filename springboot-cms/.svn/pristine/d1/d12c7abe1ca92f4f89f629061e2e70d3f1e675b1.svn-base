package com.ritu.cms.reflect.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ReflectUtil {

	public static Class<?> getClzzByT(Class<?> clzz){
		Type genericSuperclass = clzz.getGenericSuperclass();  
        //参数化类型  
        ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;  
        //返回表示此类型实际类型参数的 Type 对象的数组  
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();  
		return (Class<?>) actualTypeArguments[0];  
	}
}
