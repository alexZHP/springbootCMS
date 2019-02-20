package com.ritu.cms.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 类名：HttpResults.java<br>
 * 包名：com.ritu.search.api.result<br>
 * 描述：接口返回的结果类<br>
 * 创建时间：2018年8月17日 下午3:35:27<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@JsonInclude(Include.ALWAYS)
public class HttpResults<T> {
	
	private String status;
	private String message;
	private int total;
	private T result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
