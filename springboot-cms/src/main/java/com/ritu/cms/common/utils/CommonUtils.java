package com.ritu.cms.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ritu.cms.constant.ConstantParamter;
import com.ritu.cms.constant.ConstantResponse;
import com.ritu.cms.response.StatusElem;

/**
 * 
 * 类名：CommonUtils.java<br>
 * 包名：com.ritu.citrus.api.util<br>
 * 描述：通用工具类<br>
 * 创建时间：2017年5月10日 下午3:13:29<br>
 * @author 徐万<br>
 * @version v1<br>
 */
public class CommonUtils {
	/**
	 * 
	 * 方法名：beanToJson<br>
	 * 描述：将对象转化成json格式<br>
	 * 创建时间：2017年5月10日 下午3:13:39<br>
	 * @author 徐万<br>
	 * @param object 传入参数Object
	 * @return 返回String类型
	 * @throws JsonProcessingException json转换异常<br>
	 */
	public final static String beanToJson(Object object) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
//		String json = mapper.writeValueAsString(object);
		String json = JSON.toJSONString(object,SerializerFeature.WriteMapNullValue);
		return json;
	}

	/**
	 * 
	 * 方法名：filterNullToResponse<br>
	 * 描述：出现异常时，只保留状态信息<br>
	 * 创建时间：2017年5月16日 下午8:16:48<br>
	 * @author 徐万<br>
	 * @param object 待过滤的对象
	 * @return json格式字符串
	 * @throws JsonProcessingException<br>
	 */
	public final static String filterNullToResponse(Object object, String output) {
		StatusElem needToConvert = (StatusElem) object;
		StatusElem statusItem = new StatusElem();
		try{
			if(object!=null&&needToConvert.getStatus()!=null){
				if (!ConstantResponse.OK_STATUS.equals(needToConvert.getStatus())) {
					statusItem.setStatus(needToConvert.getStatus());
					statusItem.setMessage(needToConvert.getMessage());
					if (ConstantParamter.OUTPUT_VALUE[0].equals(output)) {
						return beanToJson(statusItem);
					} else if (ConstantParamter.OUTPUT_VALUE[1].equals(output)) {
						return beanToXml(statusItem);
					}
				}
				if (ConstantParamter.OUTPUT_VALUE[1].equals(output)) {
					return beanToXml(object);
				}
				return beanToJson(object);
			}
		}  catch (JsonProcessingException e) {
			e.printStackTrace();
			return "{status:3xx,message:error response}";
		}
		return null;
	}

	/**
	 * 
	 * 方法名：beanToXml<br>
	 * 描述：将对象转化成xml格式<br>
	 * 创建时间：2017年5月10日 下午3:15:22<br>
	 * @author 徐万<br>
	 * @param object 传入参数Object
	 * @return 返回String类型
	 * @throws JsonProcessingException json转换异常<br>
	 */
	public final static String beanToXml(Object object) throws JsonProcessingException {
		XmlMapper xml = new XmlMapper();
		xml.setSerializationInclusion(Include.NON_NULL);
		String xmlStr = xml.writeValueAsString(object);
		return xmlStr;
	}


	/**
	 * 
	 * 方法名：isNullOrBlank<br>
	 * 描述：是不是空字符串或空指针<br>
	 * 创建时间：2017年5月10日 下午3:17:10<br>
	 * @author 徐万<br>
	 * @param arg String类型参数
	 * @return 合法返回true，不合法返回false<br>
	 */
	public final static Boolean isNullOrBlank(String arg) {
		if (arg == null || arg.trim().equals("")) {
			return true;
		}
		return false;
	}
	
	
	public static final boolean isNotEmptry(Object o){
		if(o != null){
			return true;
		}
		return false;
	}
	
	public static final boolean isNotEmptry(String str){
		if(str != null && !"".equals(str)){
			return true;
		}
		return false;
	}
}
