package com.ritu.cms.pojo;

import java.io.Serializable;

import com.ritu.cms.index.annotation.Column;
import com.ritu.cms.index.annotation.TableName;

import lombok.Data;

/**
 * 
 * 类名：VilageDO.java<br>
 * 包名：com.ritu.cms.pojo<br>
 * 描述：小区<br>
 * 创建时间：2019年2月12日 下午4:13:16<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Data
@TableName(value = "village")
public class VillageDO implements Serializable {

	/**
	 * 描述：
	 */
	private static final long serialVersionUID = 612968854792433183L;
	
	/**
	 * 小区id
	 */
	@Column
	private Integer id;
	/**
	 * 小区名称
	 */
	@Column
	private String name;
	/**
	 * 省
	 */
	@Column
	private String province;
	/**
	 * 市
	 */
	@Column
	private String city;
	/**
	 * 区
	 */
	@Column
	private String district;
	/**
	 * 物业电话
	 */
	@Column
	private String propertyPhone;
	/**
	 * 地址
	 */
	@Column
	private String address;
	/**
	 * 周边
	 */
	@Column
	private String around;
	/**
	 * 交通
	 */
	@Column
	private String traffic;
	/**
	 * 经度
	 */
	@Column
	private String lng;
	/**
	 * 纬度
	 */
	@Column
	private String lat;
	/**
	 * 物业费
	 */
	@Column
	private Double propertyFee;
	/**
	 * 水费
	 */
	@Column
	private Double waterFee;
	/**
	 * 电费
	 */
	@Column
	private Double electricityFee;
	/**
	 * 燃气费
	 */
	@Column
	private Double gasFee;
	/**
	 * 备注
	 */
	@Column
	private String remarks;
	
	@Override
	public String toString() {
		return "Vilage [id=" + id + ", name=" + name + ", province=" + province + ", city=" + city + ", district="
				+ district + ", propertyPhone=" + propertyPhone + ", address=" + address + ", around=" + around
				+ ", traffic=" + traffic + ", lng=" + lng + ", lat=" + lat + ", propertyFee=" + propertyFee
				+ ", waterFee=" + waterFee + ", electricityFee=" + electricityFee + ", gasFee=" + gasFee + ", remarks="
				+ remarks + "]";
	}
	
	
}
