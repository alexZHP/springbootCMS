package com.ritu.cms.constant;

/**
 * 
 * 类名：ConstantResponse.java<br>
 * 包名：com.ritu.citrus.api.constant<br>
 * 描述：输出状态码及描述<br>
 * 创建时间：2017年5月10日 下午3:20:49<br>
 * 
 * @author 徐万<br>
 * @version v1<br>
 */
public class ConstantResponse {

	public static final Integer OK_STATUS = 0;
	public static final String OK_MSG = "正常";

	public static final Integer PARAMETER_INVALID_STATUS = 2;
	public static final String PARAMETER_INVALID_MSG = "请求参数非法";

	public static final Integer VERIFY_FAILURE_STATUS = 3;
	public static final String VERIFY_FAILURE_MSG = "权限校验失败";

	public static final Integer QUOTA_FAILURE_STATUS = 4;
	public static final String QUOTA_FAILURE_MSG = "配额校验失败";

	public static final Integer AK_FAILURE_STATUS = 5;
	public static final String AK_FAILURE_MSG = "ak不存在或者非法";

	public static final String No_AUTHORITY_STATUS = "2xx";
	public static final String No_AUTHORITY_MSG = "无权限";

	public static final String Quota_ERROR_STATUS = "3xx";
	public static final String Quota_ERROR_MSG = "配额错误";
}
