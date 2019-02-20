package com.ritu.cms.response;

import java.io.Serializable;

public class Result extends StatusElem implements Serializable {
	/**
	 * 描述：
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 检索总数
	 */
	private Long total;
	/**
	 * 结果字段
	 */
	private Object result;

	public Result() {

	}

	public Result(Integer status, String message) {
		setStatus(status);
		setMessage(message);
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
