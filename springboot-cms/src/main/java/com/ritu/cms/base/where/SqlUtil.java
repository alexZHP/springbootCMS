package com.ritu.cms.base.where;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ritu.cms.common.utils.CommonUtils;
import com.ritu.cms.index.annotation.Column;
import com.ritu.cms.index.annotation.JoinColumn;
import com.ritu.cms.index.annotation.TableName;
import com.ritu.cms.reflect.utils.PropertyUtil;

public class SqlUtil {
	
	private static final String LNG = "lng";
	private static final String LAT = "lat";
	private static final String LOCATION = "location";
	private static final String POLY_EDGE = "poly_edge";
	private static final String LINE_EDGE = "line_edge";
	private static final String SELECT = " select ";
	private static final String POINT = ".";
	private static final String AS = " as ";
	private static final String FROM = " from ";
	private static final String JOIN = " join ";
	private static final String ON = " on ";
	private static final String UNDER_LINE = "_";
	private static final String LEFT_BRACKETS = " ( ";
	private static final String RIGHT_BRACKETS = " ) ";
	private static final String SINGLE_QUOT_MARK = "\"";
	private static final String COMMA = ",";
	private static final String EQUAL_SIGN = " = ";
	private static final String ID = "id";
			
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：<br>
	 * 创建时间：2018年9月5日 上午11:33:41<br>
	 * @author 阮建钧<br>
	 * @param clazz
	 * @return<br>
	 */
	public static String getTableFields(Class<?> clazz) {
		Long start = System.currentTimeMillis();
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer columns = new StringBuffer("");
		if (fields != null) {
			Arrays.stream(fields).forEach(field -> {
				String fieldName = field.getName();
				Annotation[] annotations = field.getAnnotations();
				if (annotations != null && annotations.length > 0) {
					if (field.isAnnotationPresent(Column.class)) {
						Column column = (Column) field.getAnnotation(Column.class);
						if (column.isGeom()) {
							switch (column.coordType()) {
							case LNG :
								columns.append(SqlEnum.LNG.getSql());
								break;
							case LAT :
								columns.append(SqlEnum.LAT.getSql());
								break;
							case LOCATION :
								columns.append(SqlEnum.LOCATION.getSql());
								break;
							case POLY_EDGE :
								columns.append(SqlEnum.POLY_EDGE.getSql());
								break;
							case LINE_EDGE :
								columns.append(SqlEnum.LINE_EDGE.getSql());
								break;
							default:
								break;
							}
						} else {
							columns.append(getColumnName(field));
						}
						columns.append(AS).append(fieldName).append(COMMA);
					}
				}
			});
			return columns.substring(0, columns.length() - 1);
		}
		System.out.println("耗时：" + (System.currentTimeMillis() - start) + "ms");
		return columns.toString();
	}

	/**
	 * 
	 * 方法名：<br>
	 * 描述：列表字段赋值<br>
	 * 创建时间：2018年9月5日 下午5:55:15<br>
	 * @author 阮建钧<br>
	 * @param selectList
	 * @param clazz
	 */
	public static <T> List<T> setListFieldValue(List<Map<String, Object>> selectList, Class<T> clazz) {
		List<T> resultList = new ArrayList<>();
		selectList.forEach(map -> {
			T entity = setEntityFieldValue(map, clazz);
			resultList.add(entity);
		});
		return resultList;
	}
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：单个实体字段赋值<br>
	 * 创建时间：2018年9月7日 下午3:20:40<br>
	 * @author 阮建钧<br>
	 * @param map
	 * @param clazz
	 * @return<br>
	 */
	public static <T> T setEntityFieldValue(Map<String, Object> map, Class<T> clazz){
		if (map == null) {
			return null;
		}
		T entity = null;
		try {
			entity = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String fileName = entry.getKey();
			Serializable fileValue = (Serializable) entry.getValue();
			if (null != fileValue) {
				Field[] fields = clazz.getDeclaredFields();
				if (fields != null) {
					for (Field field : fields) {
						if (fileName.equalsIgnoreCase(field.getName())) {
							PropertyUtil.setProperty(entity, field.getName(), fileValue);
						}
					}
				}
			}
		}
		return entity;
	}
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：<br>
	 * 创建时间：2019年2月13日 下午1:59:19<br>
	 * @author 阮建钧<br>
	 * @param entity
	 * @param clazz
	 * @return<br>
	 */
	public static Map<String, String> getEntityFieldAndValue(Object entity, Class<?> clazz) {
		
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer columns = new StringBuffer(LEFT_BRACKETS);
		StringBuffer values = new StringBuffer(LEFT_BRACKETS);
		Map<String, String> fieldMap = new HashMap<>();
		if (fields != null) {
			Arrays.stream(fields).forEach(field -> {
				String fieldName = field.getName();
				Annotation[] annotations = field.getAnnotations();
				if (annotations != null && annotations.length > 0) {
					if (field.isAnnotationPresent(Column.class)) {
						Object fieldValue = PropertyUtil.getProperty(entity, fieldName);
						if (CommonUtils.isNotEmptry(fieldValue)) {
							columns.append(getColumnName(field)).append(COMMA);
							values.append(SINGLE_QUOT_MARK).append(fieldValue).append(SINGLE_QUOT_MARK).append(COMMA);
						}
					}
				}
			});
			fieldMap.put("columns", columns.substring(0, columns.length() - 1) + RIGHT_BRACKETS);
			fieldMap.put("values", values.substring(0, values.length() - 1) + RIGHT_BRACKETS);
		}
		return fieldMap;
	}
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：<br>
	 * 创建时间：2019年2月13日 下午1:59:25<br>
	 * @author 阮建钧<br>
	 * @param entity
	 * @param clazz
	 * @return<br>
	 */
	public static Map<String, String> getEntityFieldAndId(Object entity, Class<?> clazz) {
		
		Field[] fields = clazz.getDeclaredFields();
		StringBuffer columns = new StringBuffer("");
		StringBuffer id = new StringBuffer("");
		Map<String, String> fieldMap = new HashMap<>();
		if (fields != null) {
			Arrays.stream(fields).forEach(field -> {
				String fieldName = field.getName();
				Annotation[] annotations = field.getAnnotations();
				if (annotations != null && annotations.length > 0) {
					if (field.isAnnotationPresent(Column.class)) {
						Object fieldValue = PropertyUtil.getProperty(entity, fieldName);
						if (CommonUtils.isNotEmptry(fieldValue) && !fieldName.equals(ID)) {
							columns.append(getColumnName(field))
								.append(EQUAL_SIGN).append(SINGLE_QUOT_MARK).append(fieldValue).append(SINGLE_QUOT_MARK).append(COMMA);
						} else if(fieldName.equals(ID)) {
							id.append(ID).append(EQUAL_SIGN).append(fieldValue);
						}
					}
				}
			});
			fieldMap.put("columns", columns.substring(0, columns.length() - 1));
			fieldMap.put("id", id.toString());
		}
		return fieldMap;
	}
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：获取级联查询SQL<br>
	 * 创建时间：2019年2月14日 下午2:37:07<br>
	 * @author 阮建钧<br>
	 * @param clazz
	 * @param tableName
	 * @return<br>
	 */
	public static StringBuffer getCascadeSQL(Class<?> clazz, String tableName){
		StringBuffer sql = new StringBuffer(SELECT);
		StringBuffer columnSql = new StringBuffer("");
		StringBuffer joinSql = new StringBuffer("");
		Field[] fields = clazz.getDeclaredFields();
		if (fields != null) {
			Arrays.stream(fields).forEach(field -> {
				Annotation[] annotations = field.getAnnotations();
				if (annotations != null && annotations.length > 0) {
					if (field.isAnnotationPresent(Column.class)) {
						columnSql.append("t").append(POINT).append(getColumnName(field)).append(COMMA);
					} else if (field.isAnnotationPresent(JoinColumn.class)) {
						Class<?> slaveClazz = field.getType();
						columnSql.append(getEntityField(tableName, field, slaveClazz).get("column"));
						joinSql.append(getEntityField(tableName, field, slaveClazz).get("join"));
					}
				}
			});
			sql.append(columnSql.substring(0, columnSql.length()-1)).append(FROM).append(tableName).append(AS).append(" t ").append(joinSql);
		}
		return sql;
	}
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：获取表的字段<br>
	 * 创建时间：2019年2月14日 上午11:04:24<br>
	 * @author 阮建钧<br>
	 * @param clazz
	 * @return<br>
	 */
	private static Map<String, String> getEntityField(String masterTableName, Field field, Class<?> slave){
		Map<String, String> sqlMap = new HashMap<>();
		StringBuffer columnSql = new StringBuffer("");
		StringBuffer joinSql = new StringBuffer("");
		JoinColumn joinColumn = (JoinColumn) field.getAnnotation(JoinColumn.class);
		String masterColumn = joinColumn.master();
		String slaveColumn = joinColumn.slave();
		Field[] fields = slave.getDeclaredFields();
		if (fields != null) {
			String slaveTableName = getTableName(slave);
			Arrays.stream(fields).forEach(f -> {
				Annotation[] annotations = f.getAnnotations();
				if (annotations != null && annotations.length > 0) {
					if (f.isAnnotationPresent(Column.class)) {
						columnSql.append(slaveTableName).append(POINT).append(getColumnName(f))
							.append(AS).append(UNDER_LINE).append(slaveTableName).append(UNDER_LINE).append(getColumnName(f)).append(COMMA);
					}
				}
			});
			sqlMap.put("column", columnSql.toString());
			sqlMap.put("join", joinSql.append(JOIN).append(slaveTableName).append(ON)
					.append(masterColumn).append(EQUAL_SIGN).append(slaveTableName).append(POINT).append(slaveColumn).toString());
		}
		return sqlMap;
	}
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：获取表名<br>
	 * 创建时间：2019年2月14日 上午11:04:59<br>
	 * @author 阮建钧<br>
	 * @param entityClass
	 * @return<br>
	 */
	public static String getTableName(Class<?> entityClass){
		if (entityClass.isAnnotationPresent(TableName.class)) {
			TableName table = (TableName) entityClass.getAnnotation(TableName.class);
			return table.value();
		}
		return null;
	}
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：根据对象字段获取表字段<br>
	 * 创建时间：2019年2月14日 下午2:19:25<br>
	 * @author 阮建钧<br>
	 * @param field
	 * @return<br>
	 */
	private static String getColumnName(Field field){
		Column column = (Column) field.getAnnotation(Column.class);
		return CommonUtils.isNotEmptry(column.name()) ? column.name() : toTableString(field.getName());
	}

	/**
	 * 
	 * 方法名：<br>
	 * 描述：驼峰转下划线<br>
	 * 创建时间：2018年9月5日 下午1:36:35<br>
	 * @author 阮建钧<br>
	 * @param text
	 * @return<br>
	 */
	public static String toTableString(String text) {
		String tName = text.substring(0, 1).toLowerCase();
		for (int i = 1; i < text.length(); i++) {
			if (!Character.isLowerCase(text.charAt(i))) {
				tName += UNDER_LINE;
			}
			tName += text.substring(i, i + 1);
		}
		return tName.toLowerCase();
	}

}
