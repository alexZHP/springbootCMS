package com.ritu.cms.index.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 类名：Column.java<br>
 * 包名：com.ritu.es.index.annotation<br>
 * 描述：<br>
 * 创建时间：2018年9月5日 下午1:57:31<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) 
@Documented
public @interface Column {

	String name() default "";  //名称
	
	boolean isGeom() default false; //是否geometry类型（postgis坐标类型）
	
	String coordType() default ""; //坐标类型：1、lng(经度);2、lat(纬度);3、edge(围成坐标);4、location(经度，纬度)，基于isGeom = true时使用。
	
	String description() default ""; //描述字段
}
