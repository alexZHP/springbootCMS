package com.ritu.cms.base.where;

/**
 * 
 * 类名：Symbol.java<br>
 * 包名：com.ritu.search.api.base.where<br>
 * 描述：sql符号的枚举类型<br>
 * 创建时间：2018年9月5日 下午4:24:02<br>
 * @author 阮建钧<br>
 * @version <br>
 */
public enum Symbol {  
	
	AND(" and ", "并且"), 
	OR(" or ", "或者"), 
	EQ(" = ", "等于"), 
	NE(" <> ", "不等于"), 
	LIKE(" like ", "模糊查询"), 
	GT(" > ", "大于"), 
	LT(" < ", "小于"), 
	IN(" in ", "包含");
	
    private String value;
    private String description;
    
    private Symbol(String value, String description) {  
        this.value = value;  
        this.description = description;  
    }  
    
    public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
} 
