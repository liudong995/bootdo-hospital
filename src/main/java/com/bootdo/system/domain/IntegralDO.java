package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 积分明细表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2020-03-31 14:11:01
 */
public class IntegralDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//会员id
	private Integer memberId;
	//增长积分
	private Integer number;
	//增长理由
	private String remark;
	//添加人
	private Integer createId;
	//添加时间
	private Date createTime;

	String memberName;
	String memberPeopleId;
	String createName;

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPeopleId() {
		return memberPeopleId;
	}

	public void setMemberPeopleId(String memberPeopleId) {
		this.memberPeopleId = memberPeopleId;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：会员id
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getMemberId() {
		return memberId;
	}
	/**
	 * 设置：增长积分
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	/**
	 * 获取：增长积分
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * 设置：增长理由
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：增长理由
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：添加人
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	/**
	 * 获取：添加人
	 */
	public Integer getCreateId() {
		return createId;
	}
	/**
	 * 设置：添加时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
