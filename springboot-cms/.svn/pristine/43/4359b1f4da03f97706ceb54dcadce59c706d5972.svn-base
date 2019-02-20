package com.ritu.cms.exception;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.gson.Gson;

/**
 * 
 * 类名：CustomExceptionHandler.java<br>
 * 包名：com.ritu.search.api.exception<br>
 * 描述：自定义异常处理类<br>
 * 创建时间：2019年1月17日 下午4:09:44<br>
 * 
 * @author 阮建钧<br>
 * @version <br>
 */
@RestControllerAdvice
public class CustomExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = SearchException.class)
	public Object expHandler(SearchException e) {
		return new Result(e.getCode(), e.getMessage());
	}

	@SuppressWarnings("unused")
	class Result implements Serializable {
		/**
		 * 描述：
		 */
		private static final long serialVersionUID = 6619787452490150669L;

		private String code;
		private String message;

		public Result() {
		}

		public Result(String code, String message) {
			this.code = code;
			this.message = message;
		}

		@Override
		public String toString() {
			return new Gson().toJson(this);
		}
	}
}
