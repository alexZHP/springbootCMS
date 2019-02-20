package com.ritu.cms.index.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 类名：JoinColumn.java<br>
 * 包名：com.ritu.es.index.annotation<br>
 * 描述：用于多表<br>
 * 创建时间：2018年7月24日 上午9:37:04<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) 
@Documented
public @interface JoinColumn {

	String name() default "";  //名称
	
	String table() default "";  //表名
	
	String master() default ""; //主表对应的字段
	
	String slave() default "id"; //关联表对应的字段
	
	String description() default ""; //描述字段
}
