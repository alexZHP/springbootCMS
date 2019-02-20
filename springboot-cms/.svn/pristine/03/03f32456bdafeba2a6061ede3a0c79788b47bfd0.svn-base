package com.ritu.cms.reflect.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * 类名：PropertyUtil.java<br>
 * 包名：com.ritu.common.util<br>
 * 描述：根据需求，定制 自己的get和set方法<br>
 * 创建时间：2017年11月16日 上午11:34:38<br>
 * @author 阮建钧<br>
 * @version <br>
 */
public class PropertyUtil {
    
    private static final String SET_PREFIX = "set";
//    private static final String IS_PREFIX = "is";
    private static final String GET_PREFIX = "get";
    
    public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {
        Method setMethod = null;
        Method getMethod = null;
        PropertyDescriptor pd = null;
        try {
            Field field = clazz.getDeclaredField(propertyName);// 根据字段名来获取字段
            if (field != null) {
                // 构建方法的后缀
                String methodEnd = propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                setMethod = clazz.getDeclaredMethod(SET_PREFIX + methodEnd, new Class[] { field.getType() });
                // 构建get 方法
                getMethod = clazz.getDeclaredMethod(GET_PREFIX + methodEnd, new Class[] {});
                // 构建一个属性描述器 把对应属性 propertyName 的 get 和 set 方法保存到属性描述器中
                pd = new PropertyDescriptor(propertyName, getMethod, setMethod);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return pd;
    }
    
    public static PropertyDescriptor getPropertyDescriptor2(Class<?> clazz, String propertyName) {//使用 PropertyDescriptor 提供的 get和set方法
        try {
            return new PropertyDescriptor(propertyName, clazz);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setProperty(Object obj, String propertyName, Object value) {
        Class<?> clazz = obj.getClass();// 获取对象的类型
        PropertyDescriptor pd = getPropertyDescriptor(clazz, propertyName);
        Method setMethod = pd.getWriteMethod();// 从属性描述器中获取 set 方法
        try {
            setMethod.invoke(obj, new Object[] { value });// 调用 set
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object getProperty(Object obj, String propertyName) {
       
        Object value = null;
        try {
        	Class<?> clazz = obj.getClass();// 获取对象的类型
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, clazz);
            Method get = pd.getReadMethod();
            value = get.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;// 返回值
    }
}