package com.ritu.cms.result;

/**
 * 
 * 类名：StateCode.java<br>
 * 包名：com.ritu.search.api.result<br>
 * 描述：接口返回的状态和信息<br>
 * 创建时间：2018年8月17日 下午3:38:25<br>
 * @author 阮建钧<br>
 * @version <br>
 */
public enum StateCode {
	SUCESS(0, "请求成功"), 
	PARAM_ERR(203, "请求失败，参数有误！");
	
	private int state;
	private String message;
	
	private StateCode(int state, String message){
		this.state = state;
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
