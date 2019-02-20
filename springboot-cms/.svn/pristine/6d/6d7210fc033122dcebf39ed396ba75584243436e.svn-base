package com.ritu.cms.index.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) 
@Documented
public @interface TableName {

	String value() default "";  //table名称
	
	String description() default ""; //描述字段
}
