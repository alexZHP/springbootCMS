package com.ritu.cms.base.dao;

import java.util.List;
import java.util.Map;

import com.ritu.cms.base.where.Where;

/**
 * 
 * 类名：BaseDao.java<br>
 * 包名：com.ritu.search.api.base.dao<br>
 * 描述：基础的dao接口<br>
 * 创建时间：2018年9月10日 上午11:16:47<br>
 * @author 阮建钧<br>
 * @version <br>
 */
public interface BaseDao<T> {
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：获取指定条件的记录数<br>
	 * 创建时间：2018年8月31日 下午3:10:01<br>
	 * @author 阮建钧<br>
	 * @param where
	 * @return<br>
	 */
	long count(Where where);
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：获取指定条件的单个实体<br>
	 * 创建时间：2018年9月7日 下午2:41:34<br>
	 * @author 阮建钧<br>
	 * @param where
	 * @return<br>
	 */
	T get(Where where); 
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：获取指定条件的列表<br>
	 * 创建时间：2018年8月31日 下午3:10:24<br>
	 * @author 阮建钧<br>
	 * @param where
	 * @return<br>
	 */
	List<T> list(Where where);
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：级联查询<br>
	 * 创建时间：2019年2月14日 上午11:49:44<br>
	 * @author 阮建钧<br>
	 * @param where
	 * @return<br>
	 */
	List<T> getCascadeList(Where where);
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：添加单个实体<br>
	 * 创建时间：2019年2月13日 下午1:24:03<br>
	 * @author 阮建钧<br>
	 * @param entity
	 * @return<br>
	 */
	int add(Object entity);
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：修改单体实体<br>
	 * 创建时间：2019年2月13日 下午1:33:03<br>
	 * @author 阮建钧<br>
	 * @param entity
	 * @return<br>
	 */
	int update(Object entity);
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：根据条件修改<br>
	 * 创建时间：2019年2月13日 下午3:05:27<br>
	 * @author 阮建钧<br>
	 * @param columnMap
	 * @param where
	 * @return<br>
	 */
	int update(Map<String, Object> columnMap, Where where);
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：删除单个实体<br>
	 * 创建时间：2019年2月13日 下午2:16:13<br>
	 * @author 阮建钧<br>
	 * @param entity
	 * @return<br>
	 */
	int delete(Object entity);
	
	/**
	 * 
	 * 方法名：<br>
	 * 描述：根据条件删除<br>
	 * 创建时间：2019年2月14日 上午9:06:19<br>
	 * @author 阮建钧<br>
	 * @param where
	 * @return<br>
	 */
	int delete(Where where);
	
	
}
