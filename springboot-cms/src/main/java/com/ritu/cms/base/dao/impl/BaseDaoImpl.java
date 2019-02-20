package com.ritu.cms.base.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ritu.cms.base.dao.BaseDao;
import com.ritu.cms.base.util.GenericsUtils;
import com.ritu.cms.base.where.SqlUtil;
import com.ritu.cms.base.where.Where;

/**
 * 
 * 类名：BaseDaoImpl.java<br>
 * 包名：com.ritu.search.api.base.dao.impl<br>
 * 描述：基础的dao接口实现<br>
 * 创建时间：2018年9月10日 上午11:15:54<br>
 * @author 阮建钧<br>
 * @version <br>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	private Class<T> entityClass; // 当前泛型实际类

	private String tableName; // 当前泛型对应的表名
	
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		super();
		this.entityClass = (Class<T>) GenericsUtils.getSuperClassGenricType(this.getClass());
		tableName = SqlUtil.getTableName(entityClass);
	}
	
	/**
	 * 查询总数
	 */
	@Override
	public long count(Where where) {
		StringBuffer sql = new StringBuffer(" select count(*) from ").append(tableName).append(where.getPrams());
		logger.warn(sql.toString());
		return sqlSessionTemplate.selectOne("selectCountByParm", sql.toString());
	}
	
	/**
	 * 查询单个实体
	 */
	@Override
	public T get(Where where) {
		StringBuffer sql = new StringBuffer(" select ").append(SqlUtil.getTableFields(entityClass));
		sql.append(" from ").append(tableName).append(where.getPrams());
		logger.warn(sql.toString());
		Map<String, Object> map = sqlSessionTemplate.selectOne("getByParm", sql.toString());
		return SqlUtil.setEntityFieldValue(map, entityClass);
	}

	/**
	 * 查询列表
	 */
	@Override
	public List<T> list(Where where) {
		StringBuffer sql = new StringBuffer(" select ").append(SqlUtil.getTableFields(entityClass));
		sql.append(" from ").append(tableName).append(where.getPrams());
		logger.warn(sql.toString());
		List<Map<String, Object>> selectList = sqlSessionTemplate.selectList("selectListByParm", sql.toString());
		return SqlUtil.setListFieldValue(selectList, entityClass);
	}
	
	/**
	 * 查询级联列表
	 */
	@Override
	public List<T> getCascadeList(Where where){
		StringBuffer sql = SqlUtil.getCascadeSQL(entityClass, tableName);
		logger.warn(sql.toString());
		List<Map<String, Object>> selectList = sqlSessionTemplate.selectList("selectListByParm", sql.toString());
		return null;
	}
	
	/**
	 * 添加单个实体
	 */
	@Override
	public int add(Object entity) {
		Map<String, String> valMap = SqlUtil.getEntityFieldAndValue(entity, entityClass);
		StringBuffer sql = new StringBuffer(" update ").append(tableName)
				.append(valMap.get("columns")).append(" values ").append(valMap.get("values"));
		logger.warn(sql.toString());
		return sqlSessionTemplate.insert("addEntity", sql.toString());
	}
	
	/**
	 * 修改单个实体
	 */
	@Override
	public int update(Object entity) {
		Map<String, String> valMap = SqlUtil.getEntityFieldAndId(entity, entityClass);
		StringBuffer sql = new StringBuffer(" update ").append(tableName).append(" set ")
			.append(valMap.get("columns")).append(" where ").append(valMap.get("id"));
		logger.warn(sql.toString());
		return sqlSessionTemplate.update("updateEntity", sql.toString());
	}
	
	/**
	 * 根据条件修改
	 */
	@Override
	public int update(Map<String, Object> columnMap, Where where) {
		StringBuffer sql = new StringBuffer(" update ").append(tableName).append(" set ");
		columnMap.forEach((k, v) -> {
			sql.append(k).append("= '").append(v).append("' ,");
		});
		String s = sql.substring(0, sql.length() - 1) + where.getPrams();
		logger.warn(s);
		return sqlSessionTemplate.update("updateEntity", s);
	}
	
	/**
	 * 根据id删除
	 */
	@Override
	public int delete(Object id) {
		if(id != null){
			StringBuffer sql = new StringBuffer(" delete from ").append(tableName)
					.append(" where id = ").append(id);
			logger.warn(sql.toString());
			return sqlSessionTemplate.delete("deleteEntity", sql.toString());
		}
		return 0;
	}
	
	/**
	 * 根据条件删除
	 */
	@Override
	public int delete(Where where) {
		StringBuffer sql = new StringBuffer(" delete from ").append(tableName).append(where.getPrams());
		logger.warn(sql.toString());
		return sqlSessionTemplate.delete("deleteEntity", sql.toString());
	}

}
