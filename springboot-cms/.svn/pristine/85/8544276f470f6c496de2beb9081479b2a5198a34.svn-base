package com.ritu.cms.exception;

import lombok.Data;

/**
 * 
 * 类名：SearchException.java<br>
 * 包名：com.ritu.search.api.exception<br>
 * 描述：自定义异常<br>
 * 创建时间：2019年1月17日 下午4:08:22<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Data
public class SearchException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String code;

    public SearchException() {
        super();
    }

    public SearchException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public SearchException(String message) {
        super(message);
    }

    public SearchException(Throwable throwable) {
        super(throwable);
    }
    
    public SearchException(String code, String message) {
    	super(message);
        this.code = code;
    }
}
