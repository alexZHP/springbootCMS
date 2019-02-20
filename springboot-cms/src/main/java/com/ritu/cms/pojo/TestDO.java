package com.ritu.cms.pojo;

import java.io.Serializable;

import com.ritu.cms.index.annotation.Column;
import com.ritu.cms.index.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "test")
public class TestDO implements Serializable{
	
	/**
	 * 描述：
	 */
	private static final long serialVersionUID = -4886487019302835189L;

	@Column
	private Integer id;
	
	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
