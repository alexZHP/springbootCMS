package com.ritu.cms.pojo;

import java.io.Serializable;

import com.ritu.cms.index.annotation.Column;
import com.ritu.cms.index.annotation.JoinColumn;
import com.ritu.cms.index.annotation.TableName;

import lombok.Data;

/**
 * 
 * 类名：HouseDO.java<br>
 * 包名：com.ritu.cms.pojo<br>
 * 描述：房屋<br>
 * 创建时间：2019年2月12日 下午5:03:59<br>
 * @author 阮建钧<br>
 * @version <br>
 */
@Data
@TableName(value = "house")
public class HouseDO implements Serializable {

	/**
	 * 描述：
	 */
	private static final long serialVersionUID = 6430056991475275014L;
	
	/**
	 * 房屋id
	 */
	@Column
	private Integer id;
	/**
	 * 房屋编码
	 */
	@Column
	private String code;
	/**
	 * 房屋名称
	 */
	@Column
	private String name;
	/**
	 * 地址
	 */
	@Column
	private String address;
	/**
	 * 级别
	 */
	@Column
	private String level;
	/**
	 * 房间数
	 */
	@Column
	private Integer roomNum;
	/**
	 * 大厅数
	 */
	@Column
	private Integer hallNum;
	/**
	 * 卫生间数
	 */
	@Column
	private Integer toiletNum;
	/**
	 * 阳台数
	 */
	@Column
	private Integer balconyNum;
	/**
	 * 面积
	 */
	@Column
	private Double area;
	/**
	 * 可用业主物品(1：毛巾；2：衣架；3：蚕丝被；4：夏凉被；5:四件套；6：枕头；7：拖鞋；8：漱口杯；9：马克杯；10：吹风机；11：电饭煲；12：菜刀；13：砧板；14：扫把簸箕套)
	 */
	@Column
	private String availableGoods;
	/**
	 * 业主
	 */
	@JoinColumn(master = "proprietor_id")
	private ProprietorDO proprietor;
	/**
	 * 所在小区
	 */
	@JoinColumn(master = "vilage_id")
	private VillageDO vilage;
	
	@Override
	public String toString() {
		return "HouseDO [id=" + id + ", code=" + code + ", name=" + name + ", proprietor=" + proprietor + ", vilage="
				+ vilage + ", address=" + address + ", level=" + level + ", roomNum=" + roomNum + ", hallNum=" + hallNum
				+ ", toiletNum=" + toiletNum + ", balconyNum=" + balconyNum + ", area=" + area + ", availableGoods="
				+ availableGoods + "]";
	}
}
