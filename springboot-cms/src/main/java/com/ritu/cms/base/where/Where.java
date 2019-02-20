package com.ritu.cms.base.where;

import com.ritu.cms.common.utils.CommonUtils;
import com.ritu.cms.common.utils.StringUtils;

/**
 * 
 * 类名：WhereParams.java<br>
 * 包名：com.ritu.search.api.base.where<br>
 * 描述：组装sql语句的where对象<br>
 * 创建时间：2018年9月5日 下午4:27:31<br>
 * @author 阮建钧<br>
 * @version <br>
 */
public class Where {

	private StringBuffer prams;
	
	private static final String STRING = "java.lang.String";
	
	private static final String LIMIT = " limit ";
	
	private static final String OFFSET = " offset ";
	
	private static final String QUOTATION_MARK = "'";

	public Where() {
		this.prams = new StringBuffer(SqlEnum.ALL.getSql());
	}

	public StringBuffer getPrams() {
		return prams;
	}

	public void setPrams(StringBuffer prams) {
		this.prams = prams;
	}

	/**
	 * 条件等于
	 * 
	 * @param condition
	 * @param columnName
	 * @param value
	 * @param clazz
	 * @return
	 */
	public Where eq(Symbol condition, String columnName, Object value, Class<?> clazz) {
		if(CommonUtils.isNotEmptry(value)){
			this.prams.append(condition.getValue()).append(columnName).append(Symbol.EQ.getValue()).append(isString(value, clazz));
		}
		return this;
	}

	/**
	 * 条件不等于
	 * 
	 * @param condition
	 * @param columnName
	 * @param value
	 * @param clazz
	 * @return
	 */
	public Where ne(Symbol condition, String columnName, Object value, Class<?> clazz) {
		if(CommonUtils.isNotEmptry(value)){
			this.prams.append(condition.getValue()).append(columnName).append(Symbol.NE.getValue()).append(isString(value, clazz));
		}
		return this;
	}

	/**
	 * 条件大于
	 * 
	 * @param condition
	 * @param columnName
	 * @param value
	 * @return
	 */
	public Where gt(Symbol condition, String columnName, Object value) {
		if(CommonUtils.isNotEmptry(value)){
			this.prams.append(condition.getValue()).append(columnName).append(Symbol.GT.getValue()).append(value);
		}
		return this;
	}

	/**
	 * 条件小于
	 * 
	 * @param condition
	 * @param columnName
	 * @param value
	 * @return
	 */
	public Where lt(Symbol condition, String columnName, Object value) {
		if(CommonUtils.isNotEmptry(value)){
			this.prams.append(condition.getValue()).append(columnName).append(Symbol.LT.getValue()).append(value);
		}
		return this;
	}

	/**
	 * 模糊查询
	 * 
	 * @param condition
	 * @param columnName
	 * @param value
	 * @return
	 */
	public Where like(Symbol condition, String columnName, Object value) {
		if(CommonUtils.isNotEmptry(value)){
			this.prams.append(condition.getValue()).append(columnName).append(Symbol.LIKE.getValue()).append("'%").append(value).append("%'");
		}
		return this;
	}
	
	/**
	 * 条件包含
	 * 
	 * @param columnName
	 * @param value
	 * @return
	 */
	public Where in(Symbol condition, String columnName, String values, Class<?> clazz) {
		if(CommonUtils.isNotEmptry(values)){
			if(clazz != null && clazz.getName().equals(STRING)){
				values = StringUtils.toSqlIn(values);
			} else {
				values = "(" + values + ")";
			}
			this.prams.append(condition.getValue()).append(columnName).append(Symbol.IN.getValue()).append(values);
		}
		return this;
	}
	
	/**
	 * 条件为空
	 * 
	 * @param condition
	 * @param columnName
	 * @return
	 */
	public Where isNull(Symbol condition, String columnName) {
		this.prams.append(condition.getValue()).append(columnName).append(" is null");
		return this;
	}
	
	/**
	 * 条件不为空
	 * 
	 * @param condition
	 * @param columnName
	 * @return
	 */
	public Where isNotNull(Symbol condition, String columnName) {
		this.prams.append(condition.getValue()).append(columnName).append(" is not null");
		return this;
	}
	
	/**
	 * 点所在的线段
	 * 
	 * @param location
	 * @param condition
	 * @return
	 */
	public Where pointLocatedLine(Symbol condition, String location) {
		if(CommonUtils.isNotEmptry(location)){
			location = StringUtils.comma2Space(location);
			this.prams.append(condition.getValue()).append("ST_Distance(st_geomfromtext('POINT("+location+")',4326), geom) = 0");
		}
		return this;
	}
	
	/**
	 * 点所在的多边形
	 * 
	 * @param location
	 * @param condition
	 * @return
	 */
	public Where pointLocatedPolygon(Symbol condition, String location){
		if(CommonUtils.isNotEmptry(location)){
			location = StringUtils.comma2Space(location);
			this.prams.append(condition.getValue()).append("ST_Within(st_geomfromtext('point("+location+")',4326),geom)");
		}
		return this;
	}
	
	/**
	 * 范围内包含的多边形
	 * 
	 * @param range
	 * @param condition
	 * @return
	 */
	public Where rangeContainPolygon(Symbol condition, String range){
		if(CommonUtils.isNotEmptry(range)){
			range = StringUtils.toSqlRange(range);
			this.prams.append(condition.getValue()).append("ST_DWithin(st_geomfromtext('POLYGON(("+range+"))',4326),geom,0)");
		}
		return this;
	}
	
	/**
	 * 分页
	 * 
	 * @param num
	 * @param size
	 * @return
	 */
	public Where limit(int num, int size){
		this.prams.append(LIMIT).append(size).append(OFFSET).append(num);
		return this;
	}
	
	/**
	 * 
	 * 
	 * @param entity
	 * @param clazz
	 * @return
	 */
	private Object isString(Object entity, Class<?> clazz){
		if(clazz != null && clazz.getName().equals(STRING)){
			return new StringBuffer(QUOTATION_MARK).append(entity).append(QUOTATION_MARK);
		}
		return entity;
	}
}
