package com.ritu.cms.index.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention; 
import java.lang.annotation.RetentionPolicy;  

/**
 * 
 * 类名：Meta.java<br>
 * 包名：com.ritu.es.index.annotation<br>
 * 描述：ES索引属性注解<br>
 * 创建时间：2018年5月8日 上午10:11:00<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD}) 
@Documented
public @interface Meta {
	
	String name() default "";  //字段名称
	
	String type() default "keyword";  //字段类型
	
	boolean isAnalyzer() default false; //是否使用分词
	
	String analyzer() default "ik_smart"; //分词方式
	
	String store() default "no";
	
	boolean docValues() default true; //坐标类型节省空间
	
	boolean coordinate() default false; //是否属于坐标数组类型
	
	boolean  merge() default false; //是否属于合并坐标 (例如：114.265384,27.273544)
	
	String description() default ""; //描述字段
}
