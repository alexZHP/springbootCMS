package com.ritu.cms.pojo;

import java.io.Serializable;

import com.ritu.cms.index.annotation.Column;
import com.ritu.cms.index.annotation.TableName;

import lombok.Data;

/**
 * 
 * 类名：ProprietorDO.java<br>
 * 包名：com.ritu.cms.pojo<br>
 * 描述：业主<br>
 * 创建时间：2019年2月12日 下午4:10:02<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Data
@TableName(value = "proprietor")
public class ProprietorDO implements Serializable {

	/**
	 * 描述：
	 */
	private static final long serialVersionUID = -748930503653281705L;
	
	/**
	 * 业主id
	 */
	@Column
	private Integer id;
	/**
	 * 业主名称
	 */
	@Column
	private String name;
	/**
	 * 业主电话
	 */
	@Column
	private String phone;
	/**
	 * 银行名称
	 */
	@Column
	private String bankName;
	/**
	 * 银行卡
	 */
	@Column
	private String bankCard;
	/**
	 * 银行卡所属人
	 */
	@Column
	private String bankCardHolder;
	/**
	 * 结算周期
	 */
	@Column
	private String settlementCycle;
	/**
	 * 备注
	 */
	@Column
	private String remarks;
	/**
	 * 意向度
	 */
	@Column
	private Integer intentionality;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getBankCardHolder() {
		return bankCardHolder;
	}

	public void setBankCardHolder(String bankCardHolder) {
		this.bankCardHolder = bankCardHolder;
	}

	public String getSettlementCycle() {
		return settlementCycle;
	}

	public void setSettlementCycle(String settlementCycle) {
		this.settlementCycle = settlementCycle;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getIntentionality() {
		return intentionality;
	}

	public void setIntentionality(Integer intentionality) {
		this.intentionality = intentionality;
	}

	@Override
	public String toString() {
		return "ProprietorDO [id=" + id + ", name=" + name + ", phone=" + phone + ", bankName=" + bankName
				+ ", bankCard=" + bankCard + ", bankCardHolder=" + bankCardHolder + ", settlementCycle="
				+ settlementCycle + ", remarks=" + remarks + ", intentionality=" + intentionality + "]";
	} 
}
