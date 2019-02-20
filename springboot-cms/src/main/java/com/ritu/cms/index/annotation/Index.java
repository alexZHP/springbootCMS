package com.ritu.cms.index.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention; 
import java.lang.annotation.RetentionPolicy;  

/**
 * 
 * 类名：Index.java<br>
 * 包名：com.ritu.es.index.annotation<br>
 * 描述：ES索引注解<br>
 * 创建时间：2018年5月8日 上午10:10:31<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) 
@Documented
public @interface Index {
	
	String indexName() default "";  //index名称
	
	String typeName() default "";  //type名称
	
	int shardsNum() default 1;  //分片数量
	
	int replicasNum() default 0;  //备份数量
	
	String description() default ""; //描述字段
}
